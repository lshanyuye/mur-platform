package com.mur.platform.security.service.impl;

import com.mur.exception.BusinessException;
import com.mur.platform.security.domain.User;
import com.mur.platform.security.mapper.UserMapper;
import com.mur.platform.security.service.UserService;
import com.mur.service.base.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
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
        if (user.isNew()) {
            user.setPassword(DigestUtils.md5DigestAsHex("111111".toString().getBytes()));
            if (user.getEnabled() == null) {
                user.setEnabled(Boolean.FALSE);
            }
        }
    }
}
