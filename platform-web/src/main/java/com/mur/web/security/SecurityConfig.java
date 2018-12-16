package com.mur.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/15 14:02
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginService loginService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
            }

            /**
             * @param charSequence 明文
             * @param s 密文
             * @return
             */
            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
            }
        });
    }

    /**
     * 忽略静态文件
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs","*/swagger-resources/**","/swagger-ui.html","/webjars/**","/ajaxLogin","/page/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint(new UnAuthenticationEntryPoint())
                .and()
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/ajaxLogin", "/page/**", "/swagger-ui.html","/webjars/**").permitAll()
//                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/ajaxLogin")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new AuthSuccessHandler())
                .failureHandler(new AuthFailHandler())
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll();
    }
}
