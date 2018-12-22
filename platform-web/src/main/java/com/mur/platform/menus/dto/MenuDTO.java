package com.mur.platform.menus.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;

/**
 * @ClassName MenuDTO
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/22 10:23
 **/
@XStreamAlias("menus")
public class MenuDTO {
    @XStreamImplicit(itemFieldName = "menuItem")
    private List<MenuItemDTO> menuItems;

    public List<MenuItemDTO> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemDTO> menuItems) {
        this.menuItems = menuItems;
    }
}
