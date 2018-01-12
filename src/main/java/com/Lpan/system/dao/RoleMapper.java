package com.Lpan.system.dao;

import java.util.List;
import java.util.Map;

import com.Lpan.system.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);
    
    int insert(Role record);

    Role selectByPrimaryKey(Integer id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
    
    int setRoleForUser(Map<String,Object> rolemap);
}