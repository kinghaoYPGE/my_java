package com.ssm.seckill.exception;

/**
 * 秒杀结束异常
 */
public class SeckillClosedException extends SeckillException {
    private int code; // 标识关闭原因；0：秒杀结束 1：库存不足

    public SeckillClosedException() {
        super();
    }

    public SeckillClosedException(String message) {
        super(message);
    }

    public SeckillClosedException(int code, String message) {
        super(message);
        this.code = code;
    }

    public SeckillClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}
