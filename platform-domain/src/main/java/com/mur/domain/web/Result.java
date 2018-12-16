package com.mur.domain.web;

import java.io.Serializable;

public class Result implements Serializable {

    private String message;

    private Object data;

    private Result() {
    }

    public Result(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result ok() {
        return new Result("操作成功", null);
    }

    public static Result ok(String message) {
        return new Result(message, null);
    }

    public static Result ok(Object data) {
        return new Result("", data);
    }

    public static Result ok(String message, Object data) {
        return new Result(message, data);
    }


}
