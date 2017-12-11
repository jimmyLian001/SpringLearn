package com.jimmy.controller;

import com.jimmy.model.AdminRevealResultModel;
import com.jimmy.model.BaseModel;
import com.jimmy.model.SmallChartPluginEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * <p>
 * User: lian zd Date:2017/9/28 ProjectName: spring_learn1 Version: 1.0
 */
@Controller
@Slf4j
@RequestMapping("/fileOs/")
public class FileProcessController {


    @RequestMapping("upload.do")
    public ModelAndView fileUpload(@RequestParam("uploadFile") CommonsMultipartFile[] files, HttpServletRequest request) {

        for (int i = 0; i < files.length; i++) {
            log.info("fileName---------->" + files[i].getOriginalFilename());
            //添加了.gitignore
            if (!files[i].isEmpty()) {
                int pre = (int) System.currentTimeMillis();
                try {
                    //拿到输出流，同时重命名上传的文件
                    FileOutputStream os = new FileOutputStream("E:/jimmyFile/" + new Date().getTime() + files[i].getOriginalFilename());
                    //拿到上传文件的输入流
                    FileInputStream in = (FileInputStream) files[i].getInputStream();

                    //以写字节的方式写文件
                    int b = 0;
                    while ((b = in.read()) != -1) {
                        os.write(b);
                    }
                    os.flush();
                    os.close();
                    in.close();
                    int finalTime = (int) System.currentTimeMillis();
                    log.info("文件上传时间" + (finalTime - pre));

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

    /**
     * 通过流的方式上传文件
     *
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @RequestMapping("uploadStream.do")
    public ModelAndView fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        //用来检测程序运行时间
        long startTime = System.currentTimeMillis();
        log.info("fileName：" + file.getOriginalFilename());

        try {
            //获取输出流
            OutputStream os = new FileOutputStream("E:/jimmyFile/" + new Date().getTime() + file.getOriginalFilename());
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is = file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while ((temp = is.read()) != (-1)) {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        log.info("方法一的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        ModelAndView mv = new ModelAndView("redirect:/view/jsp/mcidInfoAdd.jsp");//默认为forward模式
        mv.addObject("message", "文件上传成功！");
        return mv;
    }

    /**
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("uploadMultipart.do")
    public ModelAndView fileUpload2(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        long startTime = System.currentTimeMillis();
        log.info("fileName：" + file.getOriginalFilename());
        String path = "E:/jimmyFile/" + new Date().getTime() + file.getOriginalFilename();

        File newFile = new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long endTime = System.currentTimeMillis();
        log.info("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        ModelAndView mv = new ModelAndView("redirect:/view/jsp/mcidInfoAdd.jsp");//默认为forward模式
        mv.addObject("message", "文件上传成功！");
        return mv;
    }


    /**
     * 采用spring提供的上传文件的方法
     */
    @RequestMapping("uploadSpring.do")
    public ModelAndView springUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String path = "E:/jimmyFile/springUpload/" + file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
            }
        }
        long endTime = System.currentTimeMillis();
        log.info("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        ModelAndView modelAndView = new ModelAndView("forward:/view/jsp/mcidInfoAdd.jsp");
        modelAndView.addObject("message", "文件上传成功！");
        return modelAndView;
    }

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("getColumnChart.do")
    public AdminRevealResultModel getColumnChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AdminRevealResultModel model = new AdminRevealResultModel();
        SmallChartPluginEntity smallChartResult=new SmallChartPluginEntity();
        List<Map<String, Object>> retList = new ArrayList<>();
        Map<String, Object> map =new HashMap<>();
        map.put("1","hello");
        map.put("2","world");
        retList.add(map);
        smallChartResult.setSmallResultList(retList);
        model.setSmallChartResult(smallChartResult);
        log.info("请求进入后台");
//        JFreeChart chart = kLineCombineChart.getChart();
//        String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400, null, request.getSession());
//        String chartURL=request.getContextPath() + "/chart?filename="+fileName;
//        modelMap.put("chartURL", chartURL);
        model.setRetCode(BaseModel.OK);
        return  model;
    }
    //这里是我的第一次提交（1）
    //这里是我的第二次提交（2）
    //这里是我的第三次提交

}
