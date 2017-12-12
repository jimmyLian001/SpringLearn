package com.jimmy.controller;

import com.jimmy.controller.form.DataOperateForm;
import com.jimmy.entity.UserInfo;
import com.jimmy.service.DataOperateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.MDC;
import org.slf4j.helpers.SystemMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/data/")
public class DateOperateController {


    @Autowired
    private DataOperateService dataOperateService;

    @ResponseBody
    @RequestMapping("formSearch.do")
    public ModelAndView queryDataByForm(HttpServletRequest request,
                                        HttpServletResponse response , DataOperateForm dataOperateForm) throws Exception {
        MDC.put(SystemMarker.TRACE_LOG_ID, UUID.randomUUID().toString());
        ModelAndView mv =new ModelAndView("redirect:/view/jsp/searchA.jsp");
        try{
            log.info("数据查询开始");
            List<UserInfo> list = dataOperateService.getPageList(dataOperateForm);
            log.info("数据查询结果长度："+list.size());
            mv.addObject("pageInfo",list);
        }catch(Exception e){
            log.error("数据查询失败哦");
        }
        mv.addObject("searchForm",dataOperateForm);
        return mv;
    }

//    @ResponseBody
//    @RequestMapping("formSearch.do")
//    public Map<String, Object> queryDataByForm(HttpServletRequest request,
//                                               HttpServletResponse response , DataOperateForm dataOperateForm) throws Exception {
//
//        Map<String, Object> re = new HashMap<String, Object>(1);
//        try{
//            log.info("数据查询开始");
//            List<UserInfo> list = dataOperateService.getPageList(dataOperateForm);
//            log.info("数据查询结果长度："+list.size());
//            re.put("success", list);
//        }catch(Exception e){
//            re.put("error",false);
//        }
//
//        return re;
//    }
}
