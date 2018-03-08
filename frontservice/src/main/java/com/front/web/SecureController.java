package com.front.web;

import com.front.common.Resuful.ResufulObj;
import com.front.common.Resuful.StateEnum;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by XKR on 2017/6/19.
 */
@Api(value = "测试服务类",description = "测试功能",tags={"测试接口"})
@RestController
@RequestMapping("/secure")
public class SecureController {
    private final static Logger logger = LoggerFactory.getLogger(SecureController.class);
    /*@Autowired
    UserService userService;*/

    @GetMapping(value = "index")
    public String index(){
        return "redirect:/index";
    }


   /* @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }*/
    @ApiOperation(value = "无参数类型")
    @GetMapping(value = "t1")
    public ResufulObj t1(){
        Page objects = PageHelper.startPage(1, 2);
        //Integer login = userService.login("admin", "b8f57d6d6ec0a60dfe2e20182d4615b12e321cad9e2979e0b9f81e0d6eda78ad9b6dcfe53e4e22d1");
        PageInfo pageInfo = new PageInfo();
        return new ResufulObj(StateEnum.SUCCESS,null,pageInfo);
    }

}
