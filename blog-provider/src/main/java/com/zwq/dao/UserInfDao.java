package com.zwq.dao;

import com.zwq.entity.UserInf;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DELL on 2018/4/12.
 */
public interface UserInfDao extends JpaRepository<UserInf,Integer>{
    public UserInf findByLoginname(String loginname);
}
