package com.sinnevy.minproject.web;


import com.sinnevy.minproject.web.code.DefaultCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 2190909922130158172L;

    private boolean success;

    private String errorCode;

    private String errorMessage;

    private T data;

    private Result(Builder<T> builder) {
        this.success = builder.success;
        this.errorCode = builder.errorCode;
        this.errorMessage = builder.errorMessage;
        this.data = builder.data;
    }

    public static Result success(Object data) {
        return new Builder<>(true).data(data).build();
    }

    public static Result failure(String errorCode, String errorMessage) {
        return new Builder<>(false).errorCode(errorCode).errorMessage(errorMessage).build();
    }

    public static Result failure(CustomError customError) {
        return new Builder<>(false).error(customError).build();
    }

    /**
     * 构建对象
     * @param <T> 构建参数
     */
    public static class Builder<T> {

        private boolean success;
        private String errorCode;
        private String errorMessage;
        private T data;

        public Builder(boolean success) {
            this.success = success;
            if (success) {
                this.errorCode = DefaultCode.SUCCESS;
            }
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public Builder error(CustomError customError) {
            this.errorCode = customError.getCode();
            this.errorMessage = customError.getError();
            return this;
        }

        public Builder errorCode (String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder errorMessage (String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public Result build() {
            return new Result<>(this);
        }

    }

}
