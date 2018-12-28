package com.mur.platform.menus.builder;

import com.mur.platform.menus.dto.ButtonDTO;
import com.mur.platform.menus.dto.MenuDTO;
import com.mur.platform.menus.dto.MenuItemDTO;
import com.mur.platform.permission.domain.Resources;
import com.mur.platform.permission.service.ResourceService;
import com.mur.utils.XStreamUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @className MenuBuilder
 * @description 解析菜单XML
 * @date 2018/12/22 11:06
 */
@Component
public class MenuBuilder implements InitializingBean, ApplicationContextAware {
  private static Logger logger = LoggerFactory.getLogger(MenuBuilder.class);

  @Value("${application.refreshMenu}")
  private Boolean refreshMenu;

  private ApplicationContext applicationContext;

  @Autowired
  private ResourceService resourceService;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    if (refreshMenu) {
      logger.info("refresh menu item started");
      buildResourceByMenuConfig();
      logger.info("refresh menu item finished.....");
    }
  }

  public void buildResourceByMenuConfig() {
    if (logger.isDebugEnabled()) {
      logger.debug("start build resource by menu config file");
    }
    try {
      Resource[] resources = applicationContext.getResources("classpath*:menu/menuConfig-*.xml");
      List<Resources> list = new ArrayList<>();
      for (Resource resource : resources) {
        String context = IOUtils.toString(resource.getInputStream(), "utf-8");
        MenuDTO menu = XStreamUtils.xmlToBean(context, MenuDTO.class);
        list = buildResource(menu);
      }
      resourceService.resetResources(list);
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }

  private List<Resources> buildResource(MenuDTO menuDTO) {
    List<Resources> resources = new ArrayList<>();
    Integer sequence = 0;
    for (MenuItemDTO menuItem : menuDTO.getMenuItems()) {
      menuItemHandle("", menuItem, resources, sequence);
      sequence++;
    }
    return resources;
  }

  private void menuItemHandle(String pCode, MenuItemDTO menuItem, List<Resources> resources, Integer sequence) {
    Resources resource = genResources(menuItem, pCode, sequence);
    resources.add(resource);
    if (menuItem.getButtons() != null && !menuItem.getButtons().isEmpty()) {
      Integer seq = 0;
      for (ButtonDTO button : menuItem.getButtons()) {
        Resources bRes = genResources(button, menuItem.getId(), seq);
        resources.add(bRes);
        seq++;
      }
    }

    if (menuItem.getMenuItems() != null && !menuItem.getMenuItems().isEmpty()) {
      Integer seq = 0;
      for (MenuItemDTO subMenuItem : menuItem.getMenuItems()) {
        menuItemHandle(menuItem.getId(), subMenuItem, resources, seq);
        seq++;
      }
    }
  }

  private Resources genResources(Object obj, String pCode, Integer sequence) {
    Resources resource = new Resources();
    resource.setpResourceCode(pCode);
    resource.fillOperator("admin");
    if (obj instanceof MenuItemDTO) {
      MenuItemDTO menuItem = (MenuItemDTO) obj;
      resource.setIcon(StringUtils.isBlank(menuItem.getIcon()) ? "fa fa-bars" : menuItem.getIcon());
      resource.setResourceCode(menuItem.getId());
      resource.setResourceName(menuItem.getTitle());
      resource.setUrl(menuItem.getPath());
      resource.setType("PAGE");
      resource.setEnabled(Boolean.TRUE);
      resource.setOrderBy(sequence);
    } else if (obj instanceof ButtonDTO) {
      ButtonDTO button = (ButtonDTO) obj;
      resource.setResourceCode(button.getId());
      resource.setResourceName(button.getTitle());
      resource.setType("BUTTON");
      resource.setEnabled(Boolean.TRUE);
      resource.setOrderBy(sequence);
    }
    return resource;
  }


}
