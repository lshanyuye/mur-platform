package com.mur.platform.permission.service;

import com.mur.domain.web.UserProfile;

public interface ProfileService {

    UserProfile buildUserProfileByUsername(String username);
}
