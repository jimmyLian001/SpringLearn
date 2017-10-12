import com.jimmy.job.EmailTask;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.MDC;
import org.slf4j.helpers.SystemMarker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * <p>
 * extends  TestCase
 * User: lian zd Date:2017/10/12 ProjectName: spring_learn1 Version: 1.0
 */
@Slf4j
public class EmailTaskTest extends BaseTest {

    @Autowired
    private EmailTask emailTask;

    @Test
    public void emailTaskTest(){
        MDC.put(SystemMarker.TRACE_LOG_ID, UUID.randomUUID().toString());
        log.info("现在开始测试Junit");
        emailTask.sendEmailByScheduled();
    }
}
