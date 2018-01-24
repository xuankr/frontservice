package com.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.front.dao.UserDao;
import com.front.entity.IUser;
import com.front.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by XKR on 2017/7/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybitsConnect {
        @Autowired
        private UserService userService;
        @Autowired
        private UserDao userdao;
        @Test
        public void testUserMapper() throws Exception {

            /*IUser user = new IUser();
            user.setId(6);
            user.setName("xiaoming");
            userMapper.insert(user);
            System.out.println("添加iuser类成功");
            */
            System.out.println(userdao.getAll());
            PageHelper.startPage(2,2);
            PageInfo infopage = new PageInfo<IUser>(userService.getAll());
            System.out.println("********    "+infopage);
        }

    }