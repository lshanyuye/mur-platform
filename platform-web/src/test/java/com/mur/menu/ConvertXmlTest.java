package com.mur.menu;

import com.mur.platform.menus.dto.ButtonDTO;
import com.mur.platform.menus.dto.MenuDTO;
import com.mur.platform.menus.dto.MenuItemDTO;
import com.mur.utils.XStreamUtils;
import java.util.ArrayList;
import java.util.List;

/** @ClassName ConvertXmlTest @Description TODO @Author Administrator @Date 2018/12/22 10:46 */
public class ConvertXmlTest {

  public static void main(String[] args) {
      MenuDTO menu = new MenuDTO();
//      menu.setAppCode("test");
//      menu.setAppName("测试");
      MenuItemDTO menuItemDTO = new MenuItemDTO();
      menuItemDTO.setId("permission");
      menuItemDTO.setTitle("权限管理");
      menuItemDTO.setIcon("fa fa-xx");
      List<MenuItemDTO> menuItemDTOS = new ArrayList<>();
      menuItemDTOS.add(menuItemDTO);
      menu.setMenuItems(menuItemDTOS);
      MenuItemDTO subMenuItem = new MenuItemDTO();
      subMenuItem.setId("user");
      subMenuItem.setTitle("帐号管理");
      subMenuItem.setPath("/user");
      List<MenuItemDTO> subMenuItems = new ArrayList<>();
      subMenuItems.add(subMenuItem);
      menuItemDTO.setMenuItems(subMenuItems);
      ButtonDTO addUser = new ButtonDTO();
      addUser.setId("addUser");
      addUser.setTitle("新增");
      ButtonDTO editUser = new ButtonDTO();
      editUser.setId("editUser");
      editUser.setTitle("新增");
      List<ButtonDTO> userButtons = new ArrayList<>();
      userButtons.add(addUser);
      userButtons.add(editUser);
      subMenuItem.setButtons(userButtons);
      System.out.println(XStreamUtils.beanToXml(menu));
  }
}
