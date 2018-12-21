package com.mur.platform.security.service.impl;

import com.mur.domain.web.UserProfile;
import com.mur.platform.security.domain.User;
import com.mur.platform.security.service.ProfileService;
import com.mur.platform.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProfileServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/21 11:25
 **/
@Service(value = "profileService")
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private UserService userService;

    @Override
    public UserProfile buildUserProfileByUsername(String username) {
        User user = userService.findByUsername(username);
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(user.getUsername());
        userProfile.setName(user.getName());
        return userProfile;
    }
}
