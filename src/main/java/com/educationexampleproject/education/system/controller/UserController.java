package com.educationexampleproject.education.system.controller;

import com.educationexampleproject.education.system.dao.UserDao;
import com.educationexampleproject.education.system.entity.User;
import com.educationexampleproject.education.system.service.UserService;
import com.educationexampleproject.education.utils.JsonUtil;
import com.educationexampleproject.education.utils.ResponseData;
import com.educationexampleproject.education.utils.StringHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @RequestMapping("/toUser.do")
    public String toUser() {
        return "thisUser";
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @RequestMapping("/queryUser.do")
    @ResponseBody
    public String queryUser(String name) {
        return JsonUtil.toJSon(new ResponseData("200", "成功获取数据!", userDao.queryUser(name)));
    }


    /**
     * 用户登陆
     *
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public String login(String name, String password) {
        try {
            if (StringHelper.isEmpty(name) || StringHelper.isEmpty(password)) {
                return JsonUtil.toJSon(new ResponseData("200", "用户名或密码错误!", null));
            }
            User user = userService.login(name, password);
            // 存入token
            String token = UUID.randomUUID().toString().replace("-", "");
            user.setToken(token);
            // 操作String类型的数据
            // ValueOperations<String, String> valueStr = redisTemplate.opsForValue();
            // valueStr.set(user.getId() + user.getName(), SerializeUtil.serialize(user) + "", 200000000);
            // System.out.println("redis: " + user.getId() + user.getName());
            // String goodsName = valueStr.get( user.getId() + user.getName());
            // System.out.println("redis: " + goodsName);
            return JsonUtil.toJSon(new ResponseData("200", "成功获取数据!", user));
        } catch (Exception e) {
            return JsonUtil.toJSon(new ResponseData("500", "查无此账号,需创建!", ""));
        }

    }

    @RequestMapping("/addUser.do")
    @ResponseBody
    public String addUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return JsonUtil.toJSon(new ResponseData("200", "新用户创建成功!", userService.addUser(user)));
    }


}
