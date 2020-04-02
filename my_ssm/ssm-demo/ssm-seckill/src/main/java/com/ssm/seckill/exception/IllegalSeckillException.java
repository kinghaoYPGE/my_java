package com.ssm.seckill.exception;

public class IllegalSeckillException extends SeckillException {
    public IllegalSeckillException() {
        super();
    }

    public IllegalSeckillException(String message) {
        super(message);
    }

    public IllegalSeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
