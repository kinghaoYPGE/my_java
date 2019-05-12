package com.ssm.seckill.enums;

public enum SeckillStateEnum {
    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    UNEXIST(-1, "秒杀不存在"),
    UNSTARTED(-2, "秒杀未开始"),
    REPEATED(-3, "重复秒杀"),
    ILLEGAL(-4, "非法数据");
    private int state;

    private String stateInfo;

    SeckillStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
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

    public static SeckillStateEnum stateOf(int index) {
        for (SeckillStateEnum state: values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
