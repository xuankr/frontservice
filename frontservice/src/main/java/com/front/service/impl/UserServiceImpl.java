package com.front.service.impl;

import com.front.dao.UserDao;
import com.front.entity.IUser;
import com.front.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by XKR on 2017/7/5.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public IUser findName(String name) {
        return null;
    }

    @Override
    @Transactional
    public List<IUser> getAll() {
        System.out.println("你好");
        /*IUser iuser = new IUser();
        iuser.setId(1);
        iuser.setName("i7");
        userDao.insert(iuser);*/
        return userDao.getAll();
    }

    @Override
    public Integer login(String name, String password) {
        return 1;
    }

    @Override
    public Integer regiest(String name, String password, Integer sex, Integer phone, String address) {
        return 1;
    }
}
