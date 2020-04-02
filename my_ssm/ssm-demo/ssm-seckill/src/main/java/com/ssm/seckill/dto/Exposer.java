package com.ssm.seckill.dto;


/**
 * isExpose=true时，返回秒杀地址
 * 否则返回相关时间
 */
public class Exposer {
    private boolean isExpose; // 是否开始秒杀；true：开启中 false：未开始或已结束
    private String md5; // 秒杀地址，采用md5摘要算法加密
    private long now; // 当前时间，可用于计算距开启秒杀时间间隔
    private long start; // 秒杀开启时间
    private long end; // 秒杀结束时间
    private long seckillId; // 当前秒杀ID
    private int state; // 当前秒杀状态

    public Exposer(boolean isExpose, String md5, long seckillId) {
        this.isExpose = isExpose;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposer(boolean isExpose, long seckillId, long now, long start, long end) {
        this.isExpose = isExpose;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean isExpose, long seckillId) {
        this.isExpose = isExpose;
        this.seckillId = seckillId;
    }

    public boolean isExpose() {
        return isExpose;
    }

    public void setExpose(boolean expose) {
        isExpose = expose;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
