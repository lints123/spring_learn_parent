package com.learn.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    //+钱
    @Update("update user set money=money+#{money} where name=#{name}")
    void incrMoney(@Param("name") String name,@Param("money") Integer money);
    //-钱
    @Update("update user set money=money-#{money} where name=#{name}")
    void decrMoney(@Param("name") String name,@Param("money") Integer money);

}
