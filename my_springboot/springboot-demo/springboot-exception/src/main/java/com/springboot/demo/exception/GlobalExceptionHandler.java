package com.springboot.demo.exception;

import com.springboot.demo.util.ResultBody;
import com.springboot.demo.util.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e) {
        if(e instanceof BizException) {
            BizException be = (BizException) e;
            logger.error("业务异常：{}", be);
            return ResultBody.error(be.getErrorCode(), be.getErrorMsg());
        } else {
            logger.error("系统异常：{}", e);
            return ResultBody.error(ResultEnum.INTERNAL_SERVER_ERROR);
        }

    }

}
