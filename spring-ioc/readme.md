# 学习Spring IOC

## Bean字段的定义
定义Bean字段的赋值。
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans>
<!--将Bean注入到spring IOC容器中处理
1. 构造方法创建Bean对象（无参构造或者有参构造）
2. Bean对象内部，多参数配置 -->
 <bean id="userService" class="com.learn.service.impl.UserServiceImpl">
     <!--注释，则默认无参构造-->
     <!--<constructor-arg name="userName" value="测试"/>
     <constructor-arg name="userDao" ref="userDao1"/>-->
    
    <!--字段为List<String>-->
     <property name="stringList">
         <list>
             <value>aaa</value>
             <value>bbb</value>
             <value>ccc</value>
         </list>
     </property>

    <!--字段为Set<String>-->
     <property name="strSet">
         <set>
             <value>xxx</value>
             <value>yyy</value>
         </set>
     </property>

    <!--字段为List<UserDao>-->
     <property name="userDaoList">
         <list>
             <ref bean="userDao1"/>
             <ref bean="userDao2"/>
             <ref bean="userDao3"/>
         </list>
     </property>

    <!--字段为Map<String,UserDao>-->
     <property name="userDaoMap">
         <map>
             <entry key="userKey1" value-ref="userDao1"/>
             <entry key="userKey2" value-ref="userDao2"/>
         </map>
     </property>

    <!--字段为Properties-->
     <property name="properties">
         <props>
             <prop key="p1">aaaa</prop>
             <prop key="p2">bbbb</prop>
         </props>
     </property>
 </bean>
</beans>
```

## Bean的创建
### 静态工厂方法创建Bean
XML配置
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans>
   <!--静态工厂方法创建对象，这里定义的是静态的方法  getUserServiceToStatic-->
       <bean id="myBeanFactory" class="com.learn.factorys.MyBeanFactory" factory-method="getUserServiceToStatic">
           <constructor-arg name="userName" value="zhangsan"/>
       </bean>
</beans>
```
Java代码
```java
public class MyBeanFactory {
   public static IUserService getUserServiceToStatic(String userName) {
      System.out.println("MyBeanFactory >>> getUserServiceToStatic >>> 通过BeanFactory创建对象");
      return new UserServiceImpl();
   }
}
```

### 实例工厂方法创建Bean
XML配置
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans>
   <!--实例工厂方法创建对象，这里定义的是非静态方法，Bean的创建交给BeanFactory-->
   <bean id="myBeanFactory1" class="com.learn.factorys.MyBeanFactory"/>
   <bean id="userServiceFactory" factory-bean="myBeanFactory1" factory-method="getUserService">
      <constructor-arg name="userName" value="zhangsan"/>
   </bean>

</beans>
```
Java配置
```java
public class MyBeanFactory {
   public static IUserService getUserServiceToStatic(String userName) {
      System.out.println("MyBeanFactory >>> getUserServiceToStatic >>> 通过BeanFactory创建对象");
      return new UserServiceImpl();
   }
}
```
### 通过FactoryBean创建对象
Spring容器会调用getObject方法，获取到Bean
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans>
   <!-- >>>> 通过FactoryBean创建对象开始 <<<< -->
   <bean id="userService" class="com.learn.factorys.MyFactoryBean"/>
</beans>
```
# 源码解析
1. 通过解析Bean的定义，存储到BeanDefinition对象中，再存储到`BeanDefinitionMap`中。
2. 通过循环遍历BeanDefinitionMap，实例化Bean，再将Bean存储到`singleObjectMap`中。 

# 常用接口
## BeanFactoryPostProcessor (Bean工厂后置处理器)
作用: 
1. 主要是在Bean实例化之前，对已经存储到BeanDefinitionMap中的Bean做操作，可以修改属性，删除、新增BeanDefinition、还可以操作一些其他逻辑.
2. `BeanFactoryPostProcessor`在应用程序上下文创建期间只会被调用一次，通常在应用程序启动时执行

### BeanDefinitionRegstoryPostProcessor
作用：该类是`BeanFactoryPostProcessor`的子类，方法会比上面的先执行，主要作用注册，修改，删除，BeanDefinition

## BeanPostProcessor（Bean后处理器）
作用：
1. 主要是对Bean对象的操作、存储到`singleObjectMap`中，再对Bean对象进行修改。 
2. 每一个Bean对象的创建都会执行一次Before、After方法

## Aware
ApplicationContextAware

## 执行顺序
1. BeanDefinitionRegstoryPostProcessor >> postProcessBeanDefinitionRegistry
2. BeanFactoryPostProcessor >> postProcessBeanFactory
3. BeanPostProcessor >> postProcessBeforeInitialization
4. BeanPostProcessor >> postProcessAfterInitialization

# Bean的生命周期
简单总结：初始化、实例化、销毁
实际执行流程
0. 如果是xml配置，通过命名空间,spring-context/META/INF/spring.handlers, 获取到配置`ContextNamespaceHandler/SpringConfiguredBeanDefinitionParser`类
   内部就是注册BeanDefinition的操作。
0. 如果是xml配置，但是是扫描的操作，同上，只是处理器是：ComponentScanBeanDefinitionParser
0. 如果是注解操作，待确认？？？
1. 暴露BeanDefinitionRegistryPostProcessor来将BeanDefinition存储到BeanDefinitionMap中。
2. 暴露BeanFactoryProcessor，可以操作BeanDefinition
3. 属性填充populate
4. Aware方法回调
5. BeanPostProcessor >>> before方法执行
6. InitializingBean接口初始化
7. BeanPostProcessor >>> after方法执行

# 总结
其实说白了，就是扫描Bean的位置 >> 获取Bean的基本信息 >> 创建BeanDefinition >> 存储到BeanDefinitionMap >> 实例化为Bean >> 存储到SingletonObject的Map中。