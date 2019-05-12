package com.ssm.seckill.service;

import com.ssm.seckill.dto.Exposer;
import com.ssm.seckill.dto.SeckillExecution;
import com.ssm.seckill.entity.Seckill;
import com.ssm.seckill.exception.*;

import java.util.List;

public interface SeckillService {

    /**
     * 查询所有秒杀信息
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀信息
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 生成秒杀url地址，返回秒杀地址信息
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀，返回秒杀结果
     * @param seckillId
     * @param userPhone
     * @param md5：用于判断用户秒杀行为是否合法
     * @return
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillUnexistedException, SeckillUnstartedException, SeckillClosedException, RepeatkillException, SeckillException;
}
