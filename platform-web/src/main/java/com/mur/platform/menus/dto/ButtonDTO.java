package com.mur.platform.menus.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @ClassName ButtonDTO
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/22 10:24
 **/
@XStreamAlias("button")
public class ButtonDTO {

    @XStreamAsAttribute
    private String id;

    @XStreamAsAttribute
    private String title;

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
}
