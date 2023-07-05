# spring ioc 注解配置方式

# xml配置扫描注解
涉及到的类
- applicationContext.xml
- OtherBean
- 操作方法：ApplicationContextTest.testXmlBean()
- 总结：主要通过扫描@Component注解，将需要的Bean注入到IOC容器中使用

# 注解配置
- SpringConfig: 配置扫描路径，配置文件注入，Mapper文件注入，实现类注入... 替代applicationContext.xml
- MyImportBeanDefinitionRegisteryBean, 实现BeanDefinitionRegistery注册类，将Bean进行注册操作。
- MyImportSelector：获取Import注解上类的信息。
- 操作方法：ApplicationContext.textAnnotationBean();
- 总结：通过注解配置的方式，将Bean注入到IOC容器上。

# 总结
两者都是大同小异，都是将需要的Bean注入到IOC容器，不同的只是xml配置和注解配置的区分。