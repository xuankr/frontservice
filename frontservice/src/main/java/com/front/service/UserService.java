package com.front.service;

import com.front.entity.IUser;

import java.util.List;

/**
 * Created by XKR on 2017/7/5.
 */
public interface UserService {
   IUser findName(String name);
   List<IUser> getAll();
    Integer login(String name,String password);
    Integer regiest(String name,String password,Integer sex,Integer phone,String address);
}
