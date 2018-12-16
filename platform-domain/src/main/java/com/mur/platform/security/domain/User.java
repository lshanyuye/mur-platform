package com.mur.platform.security.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mur.domain.Domain;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <p>
 * 帐号
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-15
 */
public class User extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 登录名
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 名字
     */
    @TableField("NAME")
    private String name;

    /**
     * 关联类型
     */
    @TableField("RELATION_TYPE")
    private String relationType;

    /**
     * 是否有效
     */
    @TableField("ENABLED")
    private Boolean enabled;

    /**
     * 失效日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("EXPIRED_DATE")
    private Date expiredDate;

    /**
     * 密码失效日期
     */
    @TableField("CREDENTIAL_EXPIRED_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date credentialExpiredDate;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getCredentialExpiredDate() {
        return credentialExpiredDate;
    }

    public void setCredentialExpiredDate(Date credentialExpiredDate) {
        this.credentialExpiredDate = credentialExpiredDate;
    }

    @Override
    public String toString() {
        return "User{" +
        "username=" + username +
        ", password=" + password +
        ", name=" + name +
        ", relationType=" + relationType +
        ", enabled=" + enabled +
        ", expiredDate=" + expiredDate +
        ", credentialExpiredDate=" + credentialExpiredDate +
        "}";
    }
}
