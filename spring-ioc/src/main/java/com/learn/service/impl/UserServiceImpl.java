package com.learn.service.impl;

import com.learn.dao.IUserDao;
import com.learn.service.IUserService;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author lints
 * @Date 2023/6/27
 * @Descirption  使用XML配置的方式
 */
public class UserServiceImpl implements IUserService {

    // 模拟循环依赖
//    private UserDao userDao;
//    public void setUserDao(UserDao userDao) {
//        System.out.println("IUserService执行注入userDao的操作：setUserDao方法执行");
//        this.userDao = userDao;
//    }

    private String userName;
    private IUserDao userDao;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl >>> 无参构造实例化Bean");
    }
    public UserServiceImpl(String userName, IUserDao userDao) {
        System.out.println("UserServiceImpl >>> 有参构造实例化Bean");
        this.userName = userName;
        this.userDao = userDao;
    }

    public void show() {
        System.out.println("UserServiceImpl >>> show");

        // [aaa, bbb, ccc]
        System.out.println(stringList);

        // [xxx, yyy]
        System.out.println(strSet);

        // [com.learn.dao.impl.UserDaoImpl@2eda0940, com.learn.dao.impl.UserDaoImpl@3578436e, com.learn.dao.impl.UserDaoImpl@706a04ae]
        System.out.println(userDaoList);

        // {userDao1=com.learn.dao.impl.UserDaoImpl@10a035a0, userDao2=com.learn.dao.impl.UserDaoImpl@67b467e9}
        System.out.println(userDaoMap);

        // {p2=bbbb, p1=aaaa}
        System.out.println(properties);
    }

    // 多参数配置
    private List<String> stringList;
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
    private Set<String> strSet;
    public void setStrSet(Set<String> strSet) {
        this.strSet = strSet;
    }
    private List<IUserDao> userDaoList;
    public void setUserDaoList(List<IUserDao> userDaoList) {
        this.userDaoList = userDaoList;
    }
    private Map<String, IUserDao> userDaoMap;
    public void setUserDaoMap(Map<String, IUserDao> userDaoMap) { this.userDaoMap = userDaoMap; }
    private Properties properties;
    public void setProperties(Properties properties) { this.properties = properties; }


}
