package com.ssm.seckill.service.impl;

import com.ssm.seckill.dao.SeckillDao;
import com.ssm.seckill.dao.SuccessKilledDao;
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
import java.util.List;

@Service
public class SeckillServiceImpl implements SeckillService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

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
        if (0 == seckillId || null == seckillDao.queryById(seckillId)) {
            return new Exposer(false, seckillId);
        }
        Seckill seckill = seckillDao.queryById(seckillId);
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
            SeckillClosedException, RepeatkillException, SeckillException {
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
        // 执行秒杀
        int rowAffected = seckillDao.reduceNumber(seckillId, new Date());
        // 库存不足
        if (rowAffected <= 0) {
            throw new SeckillClosedException(1, "Closed seckill");
        }

        int successKilledNum = successKilledDao.insertSuccessKilled(seckillId, userPhone);
        // 重复秒杀
        if (successKilledNum <= 0) {
            throw new RepeatkillException("Repeated seckill");
        }
        // 秒杀成功
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
        SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
        return seckillExecution;
    }
}
