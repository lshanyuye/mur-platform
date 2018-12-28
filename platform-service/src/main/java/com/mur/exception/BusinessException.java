package com.mur.exception;

/**
 * @ClassName BusinessException
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/14 14:10
 **/
public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Object... params) {
    super(String.format(message, params));
  }
}
