import com.jimmy.controller.form.DataOperateForm;
import com.jimmy.entity.UserInfo;
import com.jimmy.job.EmailTask;
import com.jimmy.service.DataOperateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.MDC;
import org.slf4j.helpers.SystemMarker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * extends  TestCase
 * User: lian zd Date:2017/10/12 ProjectName: spring_learn1 Version: 1.0
 */
@Slf4j
public class EmailTaskTest extends BaseTest {

    @Autowired
    private EmailTask emailTask;
    @Autowired
    private DataOperateService dataOperateService;
    @Test
    public void emailTaskTest(){
        MDC.put(SystemMarker.TRACE_LOG_ID, UUID.randomUUID().toString());
        log.info("现在开始测试Junit");
        emailTask.sendEmailByScheduled();
    }
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
    @Test
    public void testString(){
        System.out.print("just do it!\r你好，这里是下一行");
        System.out.println();
        System.out.println(replaceBlank("just do it!\r你好，这里是下一行"));
    }
    @Test
    public void queryPageTest(){
        DataOperateForm dataOperateForm=new DataOperateForm();
        dataOperateForm.setIdNo("4123281990161252u");
        List<UserInfo> list = dataOperateService.getPageList(dataOperateForm);
        log.info("查询结果条数"+list.size());
//        log.info("查询结果条数"+list.size()+"；查询内容："+list.get(0));
    }
}
