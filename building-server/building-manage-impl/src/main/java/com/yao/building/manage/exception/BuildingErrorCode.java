package com.yao.building.manage.exception;

public enum BuildingErrorCode {
    SYSTEM_ERROR("1001", "系统异常"),
    INVALID_TOKEN("1002", "token无效，请重新登录"),
    INVALID_PARAMS("2001", "无效参数"),
    ;

    private String code;
    private String message;

    BuildingErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return code;
    }

    public String getMessage(){
       return message;
    }
}
