package com.front.dao;

import com.front.entity.security.User;
import org.springframework.stereotype.Component;

/**
 * Created by XKR on 2017/7/4.
 */
@Component
public interface UserDao {
    User get(String username);
}
