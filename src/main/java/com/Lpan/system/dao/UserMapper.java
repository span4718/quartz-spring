package com.Lpan.system.dao;

import java.util.List;

import com.Lpan.system.model.Role;
import com.Lpan.system.model.User;


public interface UserMapper {	
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    
    int setRoleForUser(Role role);
    
    int deleteRoleForUser(Role role);

}
