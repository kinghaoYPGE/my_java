package com.ssm.seckill.exception;

/**
 * 重复秒杀异常
 */
public class RepeatkillException extends SeckillException {
    public RepeatkillException() {
        super();
    }

    public RepeatkillException(String message) {
        super(message);
    }

    public RepeatkillException(String message, Throwable cause) {
        super(message, cause);
    }
}
