package com.front.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * Created by XKR on 2017/7/5.
 */
public interface UserService extends UserDetailsService {

    Integer login(String name, String password);

    Integer regiest(String name, String password, Integer sex, Integer phone, String address);
}
