package com.jimmy.dao;

import com.jimmy.controller.form.DataOperateForm;
import com.jimmy.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * User: lian zd Date:2017/9/21 ProjectName: spring_learn1 Version: 1.0
 */
public interface UserCheckMapper {
    UserInfo getUserInfo(UserInfo userInfo);

    List<UserInfo> queryUserInfo(@Param("en") DataOperateForm dataOperateForm);
}
