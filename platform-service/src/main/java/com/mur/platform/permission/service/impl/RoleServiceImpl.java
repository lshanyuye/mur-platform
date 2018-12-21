package com.mur.platform.permission.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mur.exception.BusinessException;
import com.mur.platform.permission.domain.Role;
import com.mur.platform.permission.mapper.RoleMapper;
import com.mur.platform.permission.service.RoleService;
import com.mur.service.base.impl.BaseServiceImpl;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 角色 服务实现类
 *
 * @author Mu.R
 * @since 2018-12-17
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
  @Resource private RoleMapper roleMapper;

  @Override
  public void save(Role role, String operator) {
    if (StringUtils.isBlank(role.getRoleCode())) {
      throw new BusinessException("角色编码不能为空");
    }
    if (StringUtils.isBlank(role.getRoleName())) {
      throw new BusinessException("角色名称不能为空");
    }
    Role existed = findByCode(role.getRoleCode());
    if (existed != null && !existed.getId().equals(role.getId())) {
      throw new BusinessException("角色编码%s已存在", role.getRoleCode());
    }
    saveOrUpdate(role, operator);
  }

  @Override
  public Role findByCode(String roleCode) {
    QueryWrapper<Role> qw = new QueryWrapper<>();
    qw.eq("role_code", roleCode);
    return getOne(qw);
  }
}
