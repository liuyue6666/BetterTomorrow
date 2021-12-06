package com.example.login.controller;

import com.example.login.dto.BaseResponse;
import com.example.login.dto.User;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping(value = "/test", produces = "application/json;charset=UTF-8")
    public String save() {
        return "11111";
    }

    @ResponseBody
    @PostMapping(value = "/user", produces = "application/json;charset=UTF-8")
    public BaseResponse save(@RequestBody User user) {
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        return userService.insert(user);
    }

    @ResponseBody
    @GetMapping(value = "/userList", produces = "application/json;charset=UTF-8")
    public BaseResponse select() {
        List<User> selectlist = userService.selectlist();
        return !CollectionUtils.isEmpty(selectlist) ? BaseResponse.ok(selectlist) : BaseResponse.fail("没好");
    }

    @ResponseBody
    @PutMapping(value = "/user/{id}", produces = "application/json;charset=UTF-8")
    public BaseResponse updateById(@RequestBody User user, @PathVariable("id") String id) {
        return userService.updateById(user, id);
    }


    @ResponseBody
    @GetMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public BaseResponse login(@RequestBody User user) {
        User res = userService.selectOne(user);
        // 登录次数加1
        res.setLoginTimes( res.getLoginTimes() + 1);
        userService.updateById(res,res.getId());
        return res != null ? BaseResponse.ok() : BaseResponse.fail("用户名或密码不对");
    }


}
