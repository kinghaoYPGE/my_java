package com.myspringboot.ajax.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice
/**
 * 增加callback切面，支持jsonp请求
 */
public class JsonAdvice extends AbstractJsonpResponseBodyAdvice {
    protected JsonAdvice() {
        super("callback");
    }
}
