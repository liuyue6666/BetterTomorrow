package com.example.login.service;

import com.example.login.dto.BaseResponse;
import com.example.login.dto.User;

import java.util.List;


public interface UserService {


    BaseResponse insert(User user);

    List<User> selectlist();

    BaseResponse updateById(User user, String id);

    User selectOne(User user);
}
