package com.front.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.front.common.Resuful.ResufulObj;
import com.front.common.Resuful.StateEnum;
import com.front.entity.IUser;
import com.front.service.UserService;
import com.github.pagehelper.page.PageMethod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by XKR on 2017/6/19.
 */
@Api(value = "测试服务类",description = "测试功能",tags={"测试接口"})
@RestController
@RequestMapping("/test")
public class TestControl {
    private final static Logger logger = LoggerFactory.getLogger(TestControl.class);
    @Autowired
    UserService userService;

    @GetMapping(value = "index")
    public String index(){
        return "/index";
    }


   /* @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }*/
    @ApiOperation(value = "无参数类型")
    @GetMapping(value = "t1")
    public ResufulObj t1(){
        PageHelper.startPage(1,2);
        PageInfo page = new PageInfo(userService.getAll());
        return new ResufulObj(StateEnum.SUCCESS,null,page);
    }

}
