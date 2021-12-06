package com.example.login.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.login.dao.UserDao;
import com.example.login.dto.BaseResponse;
import com.example.login.dto.User;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {


    @Override
    @LoadBalanced
    public BaseResponse insert(User user) {
        List<User> list = this.list(getWrapper(User.builder().username(user.getUsername()).build()));
        if (CollectionUtils.isEmpty(list)) {
            this.save(user);
            return BaseResponse.ok("好了");
        } else {
            return BaseResponse.fail("用户名已存在");

        }
    }

    @Override
    public User selectOne(User user) {
        List<User> list = this.list(getWrapper(user));
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public List<User> selectlist() {
        return this.list(getWrapper(new User()));
    }

    @Override
    public BaseResponse updateById(User user, String id) {
        user.setId(id);
        this.updateById(user);
        return BaseResponse.ok("好了");
    }

    public QueryWrapper<User> getWrapper(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq(!StringUtils.isEmpty(user.getUsername()), "user_name", user.getUsername());
        wrapper.eq(!StringUtils.isEmpty(user.getPassword()), "password", user.getPassword());
        return wrapper;

    }

}
