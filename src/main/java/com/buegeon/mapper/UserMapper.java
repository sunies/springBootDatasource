package com.buegeon.mapper;

import com.buegeon.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper{
    @Select("SELECT * FROM user WHERE id = 1")
    User selectByPrimaryKey();
    
}