package com.mur.platform.permission.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mur.exception.BusinessException;
import com.mur.platform.permission.domain.User;
import com.mur.platform.permission.mapper.UserMapper;
import com.mur.platform.permission.service.UserService;
import com.mur.service.base.impl.BaseServiceImpl;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * <p> 帐号 服务实现类 </p>
 *
 * @author Mu.R
 * @since 2018-12-15
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void save(User user, String operator) {
        if (StringUtils.isBlank(user.getUsername())) {
            throw new BusinessException("帐号不能为空");
        }
        if (StringUtils.isBlank(user.getName())) {
            throw new BusinessException("姓名不能为空");
        }
        User existed = this.findByUsername(user.getUsername());
        if (existed != null && !existed.getId().equals(user.getId())) {
            throw new BusinessException("账号%s已存在，不允许重复添加", user.getUsername());
        }
        if (user.isNew()) {
            user.setPassword(DigestUtils.md5DigestAsHex("111111".toString().getBytes()));
            if (user.getEnabled() == null) {
                user.setEnabled("1");
            }
        }
        saveOrUpdate(user, operator);
    }

    @Override
    public User findByUsername(String username) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", username);
        return getOne(qw);
    }
}
