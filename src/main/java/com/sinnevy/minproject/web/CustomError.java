package com.sinnevy.minproject.web;

public interface CustomError {

    /**
     * 错误码
     * @return code
     */
    String getCode();

    /**
     * 错误信息
     * @return error
     */
    String getError();

    void setError(String message);

}
