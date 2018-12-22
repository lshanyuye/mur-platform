package com.mur.platform.permission.service;

import com.mur.platform.permission.domain.User;
import com.mur.service.base.BaseService;

/**
 * <p>
 * 帐号 服务类
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-15
 */
public interface UserService extends BaseService<User> {

    void save(User user, String operator);

    User findByUsername(String username);
}
