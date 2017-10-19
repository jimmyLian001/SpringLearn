package com.jimmy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * <p>
 * User: lian zd Date:2017/9/21 ProjectName: spring_learn1 Version: 1.0
 */
@Getter
@Setter
@ToString
public class UserInfo {
    private String userName;
    private String passWord;
    private Date createAt;
    private int classLevel;
    private Long id;
    private String sex;
    private String idNo;
}
