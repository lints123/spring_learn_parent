# Spring框架和Spring mvc

# 强化点
1. AOP源码，如何进行拦截，画图
2. 注解如何扫描Bean进行处理？
3. 事务管理器，统一事务切面问题
```xml
<!--applicationContext.xml配置-->
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


<!--web.xml配置-->
<!--定义全局参数-->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
<!--配置Listener-->
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

<!--问题: web.xml中，这两个配置，具体是哪里进行扫描的？-->
```