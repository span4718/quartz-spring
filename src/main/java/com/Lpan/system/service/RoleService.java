package com.Lpan.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Lpan.system.dao.RoleMapper;
import com.Lpan.system.model.Role;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	public int deleteByPrimaryKey(Integer id) {
		return roleMapper.deleteByPrimaryKey(id);
	}
    
   public int insert(Role record) {
    	return roleMapper.insert(record);
    }

    public Role selectByPrimaryKey(Integer id) {
    	return roleMapper.selectByPrimaryKey(id);
    }

    public List<Role> selectAll(){
    	return roleMapper.selectAll();
    }

    public int updateByPrimaryKey(Role record) {
    	return roleMapper.updateByPrimaryKey(record);
    }
    
    public int setRoleForUser(Map<String,Object> rolemap) {
    	return roleMapper.setRoleForUser(rolemap);
    }
}
