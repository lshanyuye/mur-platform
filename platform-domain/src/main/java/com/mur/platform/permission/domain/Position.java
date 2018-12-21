package com.mur.platform.permission.domain;

import com.mur.domain.Domain;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <p>
 * 岗位
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-17
 */
public class Position extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位编码
     */
    @TableField("POS_CODE")
    private String posCode;

    /**
     * 岗位名称
     */
    @TableField("POS_NAME")
    private String posName;

    /**
     * 是否有效
     */
    @TableField("ENABLED")
    private Boolean enabled;


    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Position{" +
        "posCode=" + posCode +
        ", posName=" + posName +
        ", enabled=" + enabled +
        "}";
    }
}
