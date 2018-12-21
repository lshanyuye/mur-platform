package com.mur.exception;

import static com.mur.exception.ExceptionCode.BUSINESS_EXCEPTION;
import static com.mur.exception.ExceptionCode.UNKNOW_EXCEPTION;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName ExceptionHandler
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/14 14:12
 **/
@ControllerAdvice
public class PlatformExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(PlatformExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionDetail> handleException(HttpServletRequest req, BusinessException e) {
        if (logger.isDebugEnabled()) {
            logger.debug("error occurred:" + e.getMessage());
        }
        return handleException(e, req, BUSINESS_EXCEPTION);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetail> handleException(HttpServletRequest req, Exception e) {
        if (logger.isDebugEnabled()) {
            logger.debug("error occurred:" + e.getMessage());
        }
        return handleException(e, req, UNKNOW_EXCEPTION);
    }

    private ResponseEntity<ExceptionDetail> handleException(Exception e, HttpServletRequest request, String code) {
        ExceptionDetail exceptionDetail = ExceptionDetail.constructExceptionDetail(code, request.getRequestURI(), e);
        return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
    }
}
