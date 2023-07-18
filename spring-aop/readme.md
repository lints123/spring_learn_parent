# AOP配置的三种情况
## 全XML配置
主要配置:
- applicationContext.xml
- MyAdvice
- ApplicationContextText >> testXml

## XML配置和注解方式配置
- applicationContext2.xml
- MyActive2
- ApplicationContextTest >> testXmlAndAnnotation

## 全注解方式配置 - MyActive3
- AopConfig
- MyActive3
- ApplicationContextTest >> testAnnotation

> 学习网址: https://www.bilibili.com/video/BV1rt4y1u7q5?p=102&spm_id_from=pageDriver&vd_source=84ffac2d3bf7e4396096fc5d76a666b8

# 源码解析
- 入口
- 图片