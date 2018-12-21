package com.mur.web.security;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import com.mur.platform.security.domain.User;
import com.mur.platform.security.service.UserService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/15 14:45
 **/
@Service
public class LoginService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("帐号不存在");
        }
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                if (user.getExpiredDate() != null) {
                    return DateUtils.truncatedCompareTo(user.getExpiredDate(), new Date(), Calendar.DATE) < 1;
                }
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                if (user.getCredentialExpiredDate() != null) {
                    return DateUtils.truncatedCompareTo(user.getCredentialExpiredDate(), new Date(), Calendar.DATE) < 1;
                }
                return true;
            }

            @Override
            public boolean isEnabled() {
                return user.getEnabled();
            }
        };
    }
}
