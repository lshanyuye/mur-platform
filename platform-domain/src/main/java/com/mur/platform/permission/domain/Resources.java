package com.mur.platform.permission.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mur.domain.Domain;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <p>
 * 资源管理
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-22
 */
@TableName("plat_resource")
public class Resources extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 资源编码
     */
    @TableField("RESOURCE_CODE")
    private String resourceCode;

    /**
     * 资源名称
     */
    @TableField("RESOURCE_NAME")
    private String resourceName;

    /**
     * 资源地址
     */
    @TableField("URL")
    private String url;

    /**
     * 是否有效
     */
    @TableField("ENABLED")
    private String enabled;

    /**
     * 资源类型
     */
    @TableField("TYPE")
    private String type;

    /**
     * 图标
     */
    @TableField("ICON")
    private String icon;

    /**
     * 上级资源编码
     */
    @TableField("P_RESOURCE_CODE")
    private String pResourceCode;


    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getpResourceCode() {
        return pResourceCode;
    }

    public void setpResourceCode(String pResourceCode) {
        this.pResourceCode = pResourceCode;
    }
}
