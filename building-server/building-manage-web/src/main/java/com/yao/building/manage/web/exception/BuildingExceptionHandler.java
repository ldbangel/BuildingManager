package com.yao.building.manage.web.exception;

import com.yao.building.manage.exception.BuildingException;
import com.yao.building.manage.response.ResultBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一运行时异常处理
 */
@ControllerAdvice
public class BuildingExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BuildingException.class)
    public Object handleException(BuildingException e) {
        e.printStackTrace();
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }
}
