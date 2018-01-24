package com.front.config.exception;

import com.alibaba.fastjson.JSONObject;
import com.front.common.Resuful.ResufulObj;
import com.front.common.Resuful.StateEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/** 统一异常处理
 * Created by XKR on 2017/7/5.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResufulObj constraintViolationException(ConstraintViolationException ex) {
        return new ResufulObj(StateEnum.EXCEPTION, ex.getMessage(), null);
    }

    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResufulObj IllegalArgumentException(IllegalArgumentException ex) {
        return new ResufulObj(StateEnum.EXCEPTION, ex.getMessage(), null);
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResufulObj noHandlerFoundException(Exception ex) {
        return new ResufulObj(StateEnum.EXCEPTION, ex.getMessage(), null);
    }


    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResufulObj unknownException(Exception ex) {
        return new ResufulObj(StateEnum.EXCEPTION, ex.getMessage(), null);
    }
}
