package com.jimmy.job.Impl;

import com.jimmy.job.EmailTask;
import com.jimmy.service.EmailSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * <p>
 * User: lian zd Date:2017/10/12 ProjectName: spring_learn1 Version: 1.0
 */
@Service
@Slf4j
public class EmailTaskImpl implements EmailTask {

    @Autowired
    private EmailSendService emailSendService;

    /**
     * 定时发送邮件 每天下午1:30 发送 corn：0 30 13 * * ?
     */
    @Override
    @Scheduled(cron = "0 09 13 * * ?")
    public void sendEmailByScheduled() {
        String content = "你好，我在使用定时任务发送邮件";
        String subject = "默认主题";
        String emailTo = "tieshou@baofoo.com";
        log.info("定时任务启动");
        try {
            Boolean resultBB = emailSendService.sendHtmlEmail(content, subject, emailTo, null);
            log.info("邮件成功发送成功：" + resultBB);
        } catch (Exception e) {
            log.error("邮件发送失败");
        }
    }
}
