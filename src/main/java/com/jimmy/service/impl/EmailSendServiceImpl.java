package com.jimmy.service.impl;

import com.jimmy.Util.StringUtil;
import com.jimmy.common.EmailService;
import com.jimmy.service.EmailSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * User: lian zd Date:2017/9/27 ProjectName: spring_learn1 Version: 1.0
 */
@Service
@Slf4j
public class EmailSendServiceImpl implements EmailSendService {

    @Autowired
    private EmailService emailService;

    String content = "默认邮件正文";
    String subject = "默认邮件主题";
    /**
     * 发送包含格式的html邮件
     *
     * @param emailTo 收件人
     * @param emailCc 抄送人
     */
    @Override
    public Boolean sendHtmlEmail(String content,String subject,String emailTo, String emailCc) {
        if(content!=null){
            this.content=content;
        }
        if(subject!=null){
            this.subject=subject;
        }
        List<String> emailToAddressList = emailAddressConvert(emailTo, ",");
        List<String> emailCcAddressList = emailAddressConvert(emailCc, ",");
        Boolean result = emailService.sendEmailHtml(content, emailToAddressList, emailCcAddressList, null, null, subject, null, null, null, "jimmyCompany");
        return result;
    }

    /**
     * 邮件地址转换
     *
     * @param emailAddress 邮件地址
     * @param regex        分隔符
     * @return 邮件地址集合
     */
    public static List<String> emailAddressConvert(String emailAddress, String regex) {
        List<String> emailAddressList = new ArrayList();
        if (StringUtil.isBlank(emailAddress)) {
            return emailAddressList;
        }
        String[] toAddress = emailAddress.split(regex);
        emailAddressList.addAll(Arrays.asList(toAddress));
        return emailAddressList;
    }
}
