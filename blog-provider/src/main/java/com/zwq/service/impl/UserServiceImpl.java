package com.zwq.service.impl;

import com.zwq.dao.UserInfDao;
import com.zwq.entity.UserInf;
import com.zwq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DELL on 2018/4/12.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserInfDao userInfDao;
    @Override
    public UserInf findByLoginname(String loginname) {
        return userInfDao.findByLoginname(loginname);
    }
}
