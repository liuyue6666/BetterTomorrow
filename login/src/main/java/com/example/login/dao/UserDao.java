package com.example.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.login.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends BaseMapper<User> {

}
