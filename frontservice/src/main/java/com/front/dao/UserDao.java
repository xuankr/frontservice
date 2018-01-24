package com.front.dao;

import com.front.entity.IUser;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by XKR on 2017/7/4.
 */
@Component
public interface UserDao {
    List<IUser> getAll();
    void insert(IUser user);
}
