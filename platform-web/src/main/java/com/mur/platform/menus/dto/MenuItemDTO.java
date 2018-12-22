package com.mur.platform.menus.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;

/**
 * @ClassName MenuItemDTO
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/22 10:24
 **/
@XStreamAlias("menuItem")
public class MenuItemDTO {

    @XStreamAsAttribute
    private String id;

    @XStreamAsAttribute
    private String title;

    @XStreamAsAttribute
    private String icon;

    @XStreamAsAttribute
    private String path;

    @XStreamImplicit(itemFieldName = "menuItem")
    private List<MenuItemDTO> menuItems;

    @XStreamImplicit(itemFieldName = "button")
    private List<ButtonDTO> buttons;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<MenuItemDTO> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemDTO> menuItems) {
        this.menuItems = menuItems;
    }

    public List<ButtonDTO> getButtons() {
        return buttons;
    }

    public void setButtons(List<ButtonDTO> buttons) {
        this.buttons = buttons;
    }
}
