package com.jimmy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * <p>
 * User: lian zd Date:2017/9/28 ProjectName: spring_learn1 Version: 1.0
 */
@Controller
@Slf4j
@RequestMapping("/fileOs/")
public class FileProcessController {

    @RequestMapping("upload.do")
    public ModelAndView fileUpload(@RequestParam("uploadFile") CommonsMultipartFile[] files, HttpServletRequest request){

        for(int i = 0;i<files.length;i++){
            log.info("fileName---------->" + files[i].getOriginalFilename());

            if(!files[i].isEmpty()){
                int pre = (int) System.currentTimeMillis();
                try {
                    //拿到输出流，同时重命名上传的文件
                    FileOutputStream os = new FileOutputStream("E:/" + new Date().getTime() + files[i].getOriginalFilename());
                    //拿到上传文件的输入流
                    FileInputStream in = (FileInputStream) files[i].getInputStream();

                    //以写字节的方式写文件
                    int b = 0;
                    while((b=in.read()) != -1){
                        os.write(b);
                    }
                    os.flush();
                    os.close();
                    in.close();
                    int finalTime = (int) System.currentTimeMillis();
                    log.info("文件上传时间"+(finalTime - pre));

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("上传出错");
                }
            }
        }
        ModelAndView mv = new ModelAndView("redirect:/view/jsp/mcidInfoAdd.jsp");//默认为forward模式
        mv.addObject("message", "文件上传成功！");
        return mv;
    }
    }
