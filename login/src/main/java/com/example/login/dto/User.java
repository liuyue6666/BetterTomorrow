package com.example.login.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> {

    @TableField("id")
    private String id;

    @TableField("user_name")
    private String username;

    @TableField("password")
    private String password;

    @TableField("login_times")
    private int loginTimes;

    @TableField("last_login_time")
    private Date lastLoginTime;

    @TableField("localtion")
    private String localtion;

    @TableField("state")
    private String state;

}
