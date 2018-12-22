package com.mur.platform.menus.builder;

import com.mur.platform.menus.dto.ButtonDTO;
import com.mur.platform.menus.dto.MenuDTO;
import com.mur.platform.menus.dto.MenuItemDTO;
import com.mur.platform.permission.domain.Resources;
import com.mur.platform.permission.service.ResourceService;
import com.mur.utils.SpringUtils;
import com.mur.utils.XStreamUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/** @ClassName MenuBuilder @Description TODO @Author Administrator @Date 2018/12/22 11:06 */
@Component
public class MenuBuilder {
  private static Logger logger = LoggerFactory.getLogger(MenuBuilder.class);

  @Autowired
  private ResourceService resourceService;
  public void buildResourceByMenuConfig() {
    if (logger.isDebugEnabled()) {
      logger.debug("start build resource by menu config file");
    }
    try {
      Resource r = SpringUtils.getResource("classpath: menu/menuConfig-platform.xml");
      Resource[] resources = SpringUtils.getResources("classpath*:menu/menuConfig-*.xml");
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
    for (MenuItemDTO menuItem : menuDTO.getMenuItems()) {
      menuItemHandle(menuItem.getId(), menuItem, resources);
    }
    return resources;
  }

  private void menuItemHandle(String pCode, MenuItemDTO menuItem, List<Resources> resources) {
    Resources resource = genResources(menuItem, pCode);
    resources.add(resource);
    if (menuItem.getButtons() != null && !menuItem.getButtons().isEmpty()) {
      for (ButtonDTO button : menuItem.getButtons()) {
        Resources bRes = genResources(button, menuItem.getId());
        resources.add(bRes);
      }
    }

    if (menuItem.getMenuItems() != null && !menuItem.getMenuItems().isEmpty()) {
      for (MenuItemDTO subMenuItem : menuItem.getMenuItems()) {
        menuItemHandle(menuItem.getId(), subMenuItem, resources);
      }
    }
  }

  private Resources genResources(Object obj, String pCode) {
    Resources resource = new Resources();
    resource.setpResourceCode(pCode);
    if (obj instanceof MenuItemDTO) {
      MenuItemDTO menuItem = (MenuItemDTO) obj;
      resource.setIcon(menuItem.getIcon());
      resource.setResourceCode(menuItem.getId());
      resource.setResourceName(menuItem.getTitle());
      resource.setUrl(menuItem.getPath());
      resource.setType("PAGE");
      resource.setEnabled("1");
    } else if (obj instanceof ButtonDTO) {
      ButtonDTO button = (ButtonDTO) obj;
      resource.setResourceCode(button.getId());
      resource.setResourceName(button.getTitle());
      resource.setType("BUTTON");
      resource.setEnabled("1");
    }
    return resource;
  }
}
