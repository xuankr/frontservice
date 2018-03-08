package com.front.config.security;

import com.front.dao.UserDao;
import com.front.entity.security.User;
import com.front.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by XKR on 2017/7/5.
 */
@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) {
        String phoneNum = login.toLowerCase();
        //验证登录名
        User userFromDatabase = userDao.get(phoneNum);
        if (userFromDatabase == null) {
            logger.info("AppUserVo " + phoneNum + " was not exist");
            throw new NullPointerException("AppUserVo " + phoneNum + " was not found in the database");
        }
       /* userFromDatabase.setLastLoginDate(DateUtil.getCurrentLongDateTime());
        //更新最后一次登录时间
        this.dao.updateUser(userFromDatabase);*/
        //获取用户的所有权限并且SpringSecurity需要的集合
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        grantedAuthorities.add(grantedAuthority);
        //返回一个SpringSecurity需要的用户对象
        return new org.springframework.security.core.userdetails.User(
                userFromDatabase.getUsername(),
                userFromDatabase.getPassword(),
                grantedAuthorities);
    }
}
