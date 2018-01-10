package com.Lpan.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Lpan.system.dao.RoleMapper;
import com.Lpan.system.dao.UserMapper;
import com.Lpan.system.model.Role;
import com.Lpan.system.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
    public int deleteByPrimaryKey(String id) {
    	return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User record) {
    	return userMapper.insert(record);
    }

    public User selectByPrimaryKey(String id) {
    	return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectAll(){
    	return userMapper.selectAll();
    }

    public int updateByPrimaryKey(User record) {
    	return userMapper.updateByPrimaryKey(record);
    }
    
    public int setRoleForUser(Role role) {
    	return userMapper.setRoleForUser(role);
    }
    
    public int deleteRoleForUser(Role role) {
    	return userMapper.deleteRoleForUser(role);
    }
    
}
