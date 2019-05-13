package com.ssm.seckill.service.impl;

import com.ssm.seckill.dao.SeckillDao;
import com.ssm.seckill.dao.SuccessKilledDao;
import com.ssm.seckill.dao.cache.RedisDao;
import com.ssm.seckill.dto.Exposer;
import com.ssm.seckill.dto.SeckillExecution;
import com.ssm.seckill.entity.Seckill;
import com.ssm.seckill.entity.SuccessKilled;
import com.ssm.seckill.enums.SeckillStateEnum;
import com.ssm.seckill.exception.*;
import com.ssm.seckill.service.SeckillService;
import com.ssm.seckill.util.SeckillUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SeckillServiceImpl implements SeckillService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Autowired
    private RedisDao redisDao;

    public List<Seckill> getSeckillList() {
        // 后面做分页处理
        return seckillDao.queryAll(0, 4);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    /**
     * 生成秒杀地址
     * @param seckillId
     * @return
     * @throws SeckillUnstartedException
     */
    public Exposer exportSeckillUrl(long seckillId) {
        // 使用redis缓存优化
        Seckill seckill = redisDao.getSeckill(seckillId);
        if (null == seckill) {
            seckill = seckillDao.queryById(seckillId);
            if (null == seckill) {
                return new Exposer(false, seckillId);
            } else {
                redisDao.putSeckill(seckill);
            }
        }
        long startTime = seckill.getStartTime().getTime();
        long endTime = seckill.getEndTime().getTime();
        long now = new Date().getTime();
        if (now < startTime || now > endTime) {
            return new Exposer(false, seckillId, now, startTime, endTime);
        }
        // 秒杀商品没有问题，生成秒杀地址
        String md5 = SeckillUtil.generateMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillUnexistedException, SeckillUnstartedException,
            SeckillClosedException, RepeatkillException, SeckillException, Exception {
        /**
         * 高并发优化
         * 前端控制：暴露接口，按钮防止重复
         * 动静态数据分离：CDN缓冲，后端缓冲（如：redis）
         * 控制事务时间-减少行级锁持有时间
         *  方案1：先insert再update
         *  方案2：使用存储过程代替java声明式事务
         */
        Exposer exposer = exportSeckillUrl(seckillId);
        // 秒杀不存在
        if (!exposer.isExpose() && 0 == exposer.getNow()) {
            throw new SeckillUnexistedException("Unexisted seckill");
        }
        // 秒杀未开始
        if (exposer.getNow() < exposer.getStart()) {
            throw new SeckillUnstartedException("Unstarted seckill");
        }
        // 秒杀结束
        if (exposer.getNow() > exposer.getEnd()) {
            throw new SeckillClosedException(0, "Closed seckill");
        }
        // 非法秒杀地址
        if (null == md5 || !md5.equals(exposer.getMd5())) {
            throw new IllegalSeckillException("Illegal seckill");
        }
        int successKilledNum = successKilledDao.insertSuccessKilled(seckillId, userPhone);
        // 重复秒杀
        if (successKilledNum <= 0) {
            throw new RepeatkillException("Repeated seckill");
        }
        // 执行秒杀，这里会存在行级锁
        int rowAffected = seckillDao.reduceNumber(seckillId, new Date());
        // 库存不足
        if (rowAffected <= 0) {
            throw new SeckillClosedException(1, "Closed seckill");
        }

        // 秒杀成功
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
        SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
        return seckillExecution;
    }

    public SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)
                    throws SeckillUnexistedException, SeckillUnstartedException, SeckillClosedException, RepeatkillException, SeckillException, Exception {
        Exposer exposer = exportSeckillUrl(seckillId);
        // 秒杀不存在
        if (!exposer.isExpose() && 0 == exposer.getNow()) {
            throw new SeckillUnexistedException("Unexisted seckill");
        }
        // 秒杀未开始
        if (exposer.getNow() < exposer.getStart()) {
            throw new SeckillUnstartedException("Unstarted seckill");
        }
        // 秒杀结束
        if (exposer.getNow() > exposer.getEnd()) {
            throw new SeckillClosedException(0, "Closed seckill");
        }
        // 非法秒杀地址
        if (null == md5 || !md5.equals(exposer.getMd5())) {
            throw new IllegalSeckillException("Illegal seckill");
        }
        // 调用存储过程
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("seckillId", seckillId);
        params.put("phone", userPhone);
        params.put("killTime", new Date());
        params.put("result", null); // 返回结果，只有为1时，执行成功
        try {
            seckillDao.executeSeckillProcedure(params);
            Integer result = (Integer)params.get("result");
            if (1 == result) {
                SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
                return seckillExecution;
            } else if(-1 == result) {
                throw new RepeatkillException("Repeated seckill");
            } else {
                throw new SeckillClosedException("Closed seckill");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SeckillException("sql execute error");
        }
    }
}
