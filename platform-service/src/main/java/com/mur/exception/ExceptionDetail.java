package com.mur.exception;

import static com.mur.exception.ExceptionCode.BUSINESS_EXCEPTION;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import javax.security.auth.login.AccountExpiredException;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName ExceptionDetail
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/14 14:20
 **/
public class ExceptionDetail implements Serializable{

    private String code;

    private String stackMessage;

    private String message;

    private String path;

    private String exception;

    public String getCode() {
        return code;
    }

    public void setCode(String coode) {
        this.code = coode;
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

    public static ExceptionDetail constructExceptionDetail(String code, String uri, Exception e) {
        ExceptionDetail exceptionDetail = new ExceptionDetail();
        exceptionDetail.setCode(code);
        String message = null != e.getMessage() ? e.getMessage() : "";
        if (StringUtils.isBlank(message)) {
            message = e.getClass().getName();
        }
        switch (code) {
            case BUSINESS_EXCEPTION:
                break;
            default:
                message="未知异常【"+ message +"】";
        }
        exceptionDetail.setStackMessage(getStackTrace(e));
        exceptionDetail.setMessage(message);
        exceptionDetail.setPath(uri);
        exceptionDetail.setException(e.getClass().getName());
        return exceptionDetail;
    }

    private static String getStackTrace(Throwable t) {
        if (null == t) {
            return "";
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
            try {
                sw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
