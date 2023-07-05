import com.learn.beans.OtherBean;
import com.learn.beans.RegisteryBean;
import com.learn.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lints
 * @Date 2023/7/5
 * @Descirption
 */
public class ApplicationContextTest {

    // XML配置方式，注入IOC容器
    @Test
    public void testXmlBean() {
        // 通过xml配置，扫描@Component注解，内部会将存在@Bean的方法，实例化Bean注入到IOC容器中。
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        OtherBean bean = applicationContext.getBean(OtherBean.class);
        System.out.println(bean);
    }

    // 全注解方式，注入IOC容器
    @Test
    public void testAnnotationBean() {
        // 通过注解扫描Bean配置
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        OtherBean bean = applicationContext.getBean(OtherBean.class);
        System.out.println("ApplicationContextTest >>> "+bean);

        RegisteryBean bean1 = applicationContext.getBean(RegisteryBean.class);
        System.out.println("ApplicationContextTest >>> "+bean1);
    }

}
