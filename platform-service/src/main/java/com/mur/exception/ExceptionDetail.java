package com.mur.exception;

import java.io.Serializable;

/**
 * @ClassName ExceptionDetail
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/14 14:20
 **/
public class ExceptionDetail implements Serializable{

    private String coode;

    private String stackMessage;

    private String message;

    private String path;

    private String exception;

    public String getCoode() {
        return coode;
    }

    public void setCoode(String coode) {
        this.coode = coode;
    }

    public String getStackMessage() {
        return stackMessage;
    }

    public void setStackMessage(String stackMessage) {
        this.stackMessage = stackMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
