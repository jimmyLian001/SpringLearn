package com.jimmy.service.impl;

import com.jimmy.dao.UserCheckMapper;
import com.jimmy.entity.UserInfo;
import com.jimmy.service.UserCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * User: lian zd Date:2017/9/21 ProjectName: spring_learn1 Version: 1.0
 */
@Service
public class UserCheckImpl implements UserCheck {

    @Autowired(required = false)
    private UserCheckMapper userCheckMapper;

    /**
     * 登录验证
     *
     * @param userName 登录名
     * @param passWord 密码
     * @return 账户信息
     */
    @Override
    public UserInfo checkUser(String userName, String passWord) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassWord(passWord);
        UserInfo userInfoResult = userCheckMapper.getUserInfo(userInfo);
        return userInfoResult;
    }
}
