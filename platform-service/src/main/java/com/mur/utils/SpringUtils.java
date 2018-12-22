package com.mur.utils;

import java.io.IOException;
import javafx.application.Application;
import javax.swing.Spring;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/** @ClassName SpringUtils @Description TODO @Author Administrator @Date 2018/12/20 15:28 */
@Component
public class SpringUtils implements ApplicationContextAware {
  private static ApplicationContext acx;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    acx = applicationContext;
  }

  public static Object getObject(String id) {
    Object object = null;
    object = acx.getBean(id);
    return object;
  }

  public static <T> T getObject(Class<T> tClass) {
    return acx.getBean(tClass);
  }

  public static Object getBean(String tClass) {
    return acx.getBean(tClass);
  }

  public <T> T getBean(Class<T> tClass) {
    return acx.getBean(tClass);
  }

  public static Resource getResource(String path) {
    return acx.getResource(path);
  }

  public static Resource[] getResources(String path) throws IOException {
    return acx.getResources(path);
  }
}
