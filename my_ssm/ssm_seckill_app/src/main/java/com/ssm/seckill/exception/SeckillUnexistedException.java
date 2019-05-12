package com.ssm.seckill.exception;

public class SeckillUnexistedException extends SeckillException {
    public SeckillUnexistedException() {
        super();
    }

    public SeckillUnexistedException(String message) {
        super(message);
    }

    public SeckillUnexistedException(String message, Throwable cause) {
        super(message, cause);
    }
}
