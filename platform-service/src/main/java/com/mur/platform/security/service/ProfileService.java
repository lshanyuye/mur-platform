package com.mur.platform.security.service;

import com.mur.domain.web.UserProfile;

public interface ProfileService {

    UserProfile buildUserProfileByUsername(String username);
}
