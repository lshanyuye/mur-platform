package com.mur.platform.permission.service.impl;

import com.mur.platform.permission.domain.Role;
import com.mur.platform.permission.mapper.RoleMapper;
import com.mur.platform.permission.service.RoleService;
import com.mur.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-17
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;
}
