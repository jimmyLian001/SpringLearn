package com.jimmy.controller;

import com.jimmy.entity.UserInfo;
import com.jimmy.service.UserCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/login/")
public class UserCheckController {

    @Autowired
    private UserCheck userCheck;


    @RequestMapping("loginCheck.do")
    public ModelAndView loginCheck(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView("logincheck");//默认为forward模式
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ModelAndView mv;
        if (userCheck(username, password)) {
            log.info("用户登陆成功");
            mv = new ModelAndView("redirect:/view/jsp/mcidInfoAdd.jsp");//redirect模式
            mv.addObject("message", "用户登陆成功！");
        } else {
            log.info("用户登陆失败");
            mv = new ModelAndView("redirect:/view/loginError.jsp");//redirect模式
            mv.addObject("message", "用户登陆失败！");
        }
//        if ("jimmy".equals(username) & "123456".equals(password)) {
//            log.info("用户登陆成功");
//            mv = new ModelAndView("redirect:/view/jsp/mcidInfoAdd.jsp");//redirect模式
//            mv.addObject("message", "用户登陆成功！");
//        } else {
//            log.info("用户登陆失败");
//            mv = new ModelAndView("redirect:/view/loginError.jsp");//redirect模式
//            mv.addObject("message", "用户登陆失败！");
//        }

        return mv;
    }

    public Boolean userCheck(String userName, String passWord) {
        UserInfo UserInfo = userCheck.checkUser(userName, passWord);
        if (UserInfo != null) {
            return true;
        } else {
            return false;
        }
    }
}
