# 学习Spring IOC

Bean的创建、BeanFactory的使用、Bean内部参数的定义

# BeanFactoryProcessor（Bean工厂后处理器）

## BeanFactoryPostProcessor
作用：主要是在Bean实例化之前，对已经存储到BeanDefinitionMap中的Bean做操作，可以修改属性，删除、新增BeanDefinition。
还可以操作一些其他逻辑

## BeanDefinitionRegstoryPostProcessor
作用：该类的方法会比上面的先执行，主要作用注册，修改，删除，BeanDefinition

## 实操
applicationContext.xml 声明两个Bean的位置，交由IOC容器处理，容器会自动调用方法。

# BeanPostProcessor（Bean后处理器）
- 主要是对Bean对象的操作、存储到singleObjectMap中，再对Bean对象进行修改。
- 每一个Bean对象执行一次Before、After方法

# Bean的生命周期
简单总结：初始化、实例化、销毁
实际执行流程
0. 如果是xml配置，通过命名空间,spring-context/META/INF/spring.handlers, 获取到配置ContextNamespaceHandler/SpringConfiguredBeanDefinitionParser类
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