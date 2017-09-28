package com.jimmy.controller;

import com.jimmy.common.EmailService;
import com.jimmy.service.EmailSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/email/")
public class EmailSendController {


    @Autowired
    private EmailSendService emailSendService;

    @ResponseBody
    @RequestMapping("sendEmail.do")
    public Map<String, Boolean> emailSend(HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
        log.info("邮件发送已经请求到后台");
        Map<String, Boolean> re = new HashMap<String, Boolean>(1);
        String content = request.getParameter("content");
        String subject = request.getParameter("subject");
        String emailTo = request.getParameter("emailTo");
        String emailCc = request.getParameter("emailCc");
        try{
            Boolean resultBB=emailSendService.sendHtmlEmail(content,subject,emailTo,emailCc);
            Boolean result = resultBB.booleanValue();
            re.put("success", result);
        }catch(Exception e){
            re.put("error",false);
        }

        return re;
    }
}
