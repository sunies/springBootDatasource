package com.buegeon.service;

import com.buegeon.config.DataSourceTarget;
import com.buegeon.mapper.UserMapper;
import com.buegeon.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;

    @Override
    @DataSourceTarget("db1")
    public User selectByPrimaryKey() {
        return userMapper.selectByPrimaryKey();
    }

    @Override
    @DataSourceTarget("db2")
    public User selectAllUser() {
        return userMapper.selectByPrimaryKey();
    }
    
}