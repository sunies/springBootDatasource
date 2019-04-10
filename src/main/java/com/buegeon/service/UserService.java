package com.buegeon.service;

import com.buegeon.pojo.User;

public interface UserService {
    
     User selectByPrimaryKey();
    
     User selectAllUser();
}