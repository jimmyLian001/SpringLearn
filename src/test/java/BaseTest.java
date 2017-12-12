import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * 添加spring-context.xml 里注册的bean 在Junit才能建立依赖
 * User: lian zd Date:2017/10/12 ProjectName: spring_learn1 Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class BaseTest {
}
