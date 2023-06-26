import com.learn.aop.config.AopConfig;
import com.learn.aop.service.IUserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lints
 * @Date 2023/6/23
 * @Descirption
 */
public class ApplicationContextText {

    // 单纯使用xml配置的方式
    @Test
    public void testXml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService = applicationContext.getBean(IUserService.class);
        userService.show();
    }

    // 使用xml配置和注解的方式
    @Test
    public void testXmlAndAnnotation() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        IUserService userService = applicationContext.getBean(IUserService.class);
        userService.show();
    }

    @Test
    public void testAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        IUserService bean = applicationContext.getBean(IUserService.class);
        bean.show();
    }


}
