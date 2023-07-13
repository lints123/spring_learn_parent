
# spring 事务管理器
- 主要用于学习spring集成mybatis，以及如何将事务交给spring管理。例子：银行转账

## 全局方法进行事务管理
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans>
    <!--6、配置事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--7、配置Advice，指定方法通过切面进行事务管理-->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <!--所有方法进行切面事务管理-->
            
            <tx:method name="*"/>
        </tx:attributes>
    </tx:advice>

    <!--8、配置AOP切面，指定具体哪些类来进行事务管理-->
    <aop:config>
        <!--切点表达式-->
        <aop:pointcut id="txPointcut" expression="execution(* com.learn.service.*.*(..))"/>
        <!--织入关系逻辑-->
        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointcut"/>
    </aop:config>
</beans>
```
**该xml的配置，是对所有方法起效果，可以指定方法前缀，后续不需要再进行其他配置。**

## 指定某些方法进行事务管理
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans>
    <!--4、配置SqlSessionFactoryBean，作用将SqlSessionFactory存储到spring容器-->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--6、配置事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--7、注解配置，事务自动代理-->
    <tx:annotation-driven transaction-manager="transactionManager"/>
</beans>
```
**该xml的配置，只声明了事务管理器，而具体哪些方法开启事务，需要什么样的事务传播机制，由方法本身决定，如：**

```java
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void opt() {
        userMapper.decrMoney("zhangsan", 500);
        int i = 1/0;
        userMapper.incrMoney("lisi", 500);
        System.out.println("转账成功");
    }
```

## 全注解配置进行事务管理
操作:
1. 通过SpringConfig，全注解配置
2. 整合web环境，通过启动web，自动加载SpringConfig，实现类MyAnnotationConfigApplicationContext, 继承 AnnotationConfigWebApplicationContext。
3. 访问链接：http://127.0.0.1:8080/spring-tx/userServlet, 进行转账操作。

踩坑：
1. ApplicationContextTest文件默认会将所有的test方法进行加载，导致服务启动会加载applicationContext1.xml文件，提示SqlSessionFactory重复
2. web.xml中，监听器没有打开，无法加载到SpringConfig


# 源码解析