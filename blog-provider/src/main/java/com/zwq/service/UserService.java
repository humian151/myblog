package com.zwq.service;

import com.zwq.entity.UserInf;

/**
 * Created by DELL on 2018/4/12.
 */
public interface UserService {
    public UserInf findByLoginname(String loginname);
}
