package com.mur.platform.permission.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mur.domain.Domain;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-22
 */
@TableName("plat_role")
public class Role extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编码
     */
    @TableField("ROLE_CODE")
    private String roleCode;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;


    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
        "roleCode=" + roleCode +
        ", roleName=" + roleName +
        "}";
    }
}
