package com.ssm.seckill.dto;

import com.ssm.seckill.entity.SuccessKilled;
import com.ssm.seckill.enums.SeckillStateEnum;

/**
 * 封装秒杀执行结果
 */
public class SeckillResult {
    private long seckillId; // 秒杀ID

    private SeckillStateEnum seckillStateEnum;

    private SuccessKilled successKilled; // 秒杀成功信息

    public SeckillResult(long seckillId, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.successKilled = successKilled;
    }

    public SeckillResult(long seckillId, SeckillStateEnum seckillStateEnum) {
        this.seckillId = seckillId;
        this.seckillStateEnum = seckillStateEnum;
    }

    public SeckillResult(long seckillId, SeckillStateEnum seckillStateEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.seckillStateEnum = seckillStateEnum;
        this.successKilled = successKilled;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    public SeckillStateEnum getSeckillStateEnum() {
        return seckillStateEnum;
    }

    public void setSeckillStateEnum(SeckillStateEnum seckillStateEnum) {
        this.seckillStateEnum = seckillStateEnum;
    }
}
