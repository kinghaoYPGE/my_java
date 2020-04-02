package com.ssm.seckill.exception;

/**
 * 秒杀未开启异常
 */
public class SeckillUnstartedException extends SeckillException {
    public SeckillUnstartedException() {
        super();
    }

    public SeckillUnstartedException(String message) {
        super(message);
    }

    public SeckillUnstartedException(String message, Throwable cause) {
        super(message, cause);
    }
}
