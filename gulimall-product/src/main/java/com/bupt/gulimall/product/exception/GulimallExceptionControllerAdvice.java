package com.bupt.gulimall.product.exception;

import com.bupt.common.exception.BizCodeEnume;
import com.bupt.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


/**
 * 集中处理所有异常
 *     @ResponseBody注解表示以json方式写出去
 */

//@ResponseBody
@Slf4j
//@ControllerAdvice(basePackages = "com.bupt.gulimall.product.controller")
@RestControllerAdvice(basePackages = "com.bupt.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    // 指定能处理什么异常:MethodArgumentNotValidException
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题{},异常类型：{}",e.getMessage(), e.getClass());
        Map<String,String> errorMap = new HashMap<>();
        // 拿到数据校验的错误结果
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getFieldErrors().forEach((item)->{
            errorMap.put(item.getField(),item.getDefaultMessage());
        });
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(),BizCodeEnume.VAILD_EXCEPTION.getMessage()).put("data",errorMap);
    }

    // 能处理任意类型的异常
    @ExceptionHandler(value = Throwable.class)
    public R handlerException(Throwable throwable){
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(), BizCodeEnume.UNKNOW_EXCEPTION.getMessage());
    }
}
