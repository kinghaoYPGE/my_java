package com.ssm.seckill.dto;

import com.ssm.seckill.entity.SuccessKilled;
import com.ssm.seckill.enums.SeckillStateEnum;

/**
 * 封装秒杀执行结果
 */
public class SeckillExecution {
    private long seckillId; // 秒杀ID

    private int state;

    private String stateInfo;

    private SuccessKilled successKilled; // 秒杀成功信息

    public SeckillExecution(long seckillId, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.successKilled = successKilled;
    }

    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
    }

    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
