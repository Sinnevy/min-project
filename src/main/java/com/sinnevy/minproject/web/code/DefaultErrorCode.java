package com.sinnevy.minproject.web.code;

import com.sinnevy.minproject.web.CustomError;

public enum  DefaultErrorCode implements CustomError {

    SYS_ERROR(DefaultCode.SYS_ERROR, "系统错误"),
    INVALID_PARAM(DefaultCode.INVALID_PARAM, "参数校验失败"),
    AUTHC_PARAM(DefaultCode.AUTHC_ERROR, "用户登录/认证失败"),
    ACCESS_DENIED(DefaultCode.ACCESS_DENIED, "没有访问权限"),

    NO_SAME("00000010", "同名对象已存在"),
    MISSING_PATIENT_ID("00000011", "缺少参数patientID"),
    ;

    private String code;

    private String error;

    DefaultErrorCode(String code, String error) {
        this.code = code;
        this.error = error;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public void setError(String message) {
        this.error = message;
    }
}
