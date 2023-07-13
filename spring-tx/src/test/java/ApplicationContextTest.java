import com.learn.config.SpringConfig;
import com.learn.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

    /**
     * 全部方法使用事务，不注释使用SpringConfig，会扫描applicationContext1.xml，导致重复注册SqlSessionFactory
     */
    @Test
    public void testTx() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext1.xml");
//        IUserService bean = app.getBean(IUserService.class);
//        bean.opt();
    }

    /**
     * 指定方法使用事务，不注释使用SpringConfig，会扫描applicationContext1.xml，导致重复注册SqlSessionFactory
     */
    @Test
    public void testTx1() {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
//        IUserService bean = context.getBean(IUserService.class);
//        bean.opt();
    }

    /**
     * 全注解使用事务
     */
    @Test
    public void testTxConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        IUserService bean = context.getBean(IUserService.class);
        bean.opt();
    }

}
