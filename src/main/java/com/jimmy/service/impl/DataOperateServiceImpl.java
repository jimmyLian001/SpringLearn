package com.jimmy.service.impl;

import com.jimmy.controller.form.DataOperateForm;
import com.jimmy.dao.UserCheckMapper;
import com.jimmy.entity.UserInfo;
import com.jimmy.service.DataOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述
 * <p>
 * User: lian zd Date:2017/10/19 ProjectName: spring_learn1 Version:1.0
 */
@Service
public class DataOperateServiceImpl implements DataOperateService {

    @Autowired(required = false)
    private UserCheckMapper userCheckMapper;

    /**
     * 获取数据查询结果
     *
     * @return
     */
    @Override
    public List<UserInfo> getPageList(DataOperateForm dataOperateForm) {
        List<UserInfo> user = userCheckMapper.queryUserInfo(dataOperateForm);
        return user;
    }
}
