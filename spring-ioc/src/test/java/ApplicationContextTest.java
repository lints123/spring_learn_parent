import com.learn.service.IUserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lints
 * @Date 2023/6/27
 * @Descirption  Bean的测试。
 */
public class ApplicationContextTest {

    /**
     * 注入Bean的配置
     */
    @Test
    public void testBean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService = applicationContext.getBean(IUserService.class);
        userService.show();
    }


}
