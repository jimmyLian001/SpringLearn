package com.jimmy.service;

import com.jimmy.entity.UserInfo;

/**
 * <p>
 * User: lian zd Date:2017/9/21 ProjectName: spring_learn1 Version: 1.0
 */
public interface UserCheck {
    /**
     * 登录验证
     * @param userName 登录名
     * @param passWord 密码
     * @return 账户信息
     */
    UserInfo checkUser(String userName, String passWord);
}
