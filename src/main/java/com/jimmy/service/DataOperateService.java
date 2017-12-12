package com.jimmy.service;

import com.jimmy.controller.form.DataOperateForm;
import com.jimmy.entity.UserInfo;

import java.util.List;

/**
 * 描述
 * <p>
 * User: lian zd Date:2017/10/19 ProjectName: spring_learn1 Version:1.0
 */
public interface DataOperateService {

    /**
     * 获取数据查询结果
     * @return
     */
    List<UserInfo> getPageList(DataOperateForm dataOperateForm);

}
