package com.blackface.seckill.exception;

import com.blackface.seckill.result.CodeMsg;
import com.blackface.seckill.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author:lwenm
 * Description: 全局异常处理器
 * Date:2019/5/15
 * Time:22:49
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionhandler(HttpServletRequest request, Exception e){

        if(e instanceof BindException){

            BindException ex = (BindException)e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }
         e.printStackTrace();

        return Result.error(CodeMsg.SERVER_ERROR);
    }

}
