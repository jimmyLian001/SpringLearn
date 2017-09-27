package com.jimmy.service;

/**
 * 对外提供发送邮件服务Service接口
 * <p>
 * User: lian zd Date:2017/9/27 ProjectName: spring_learn1 Version: 1.0
 */
public interface EmailSendService {

    /**
     * 发送包含格式的html邮件
     * @param emailTo 收件人
     * @param emailCc 抄送人
     */
    Boolean sendHtmlEmail(String emailTo, String emailCc);
}
