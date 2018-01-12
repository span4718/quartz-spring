package com.Lpan.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Lpan.system.dao.ResourceMapper;
import com.Lpan.system.model.Resource;

@Service
@Transactional
public class ResourceService {
	
	@Autowired
	private ResourceMapper resourceMapper;
   public int deleteByPrimaryKey(Integer id) {
    	return resourceMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Resource record) {
    	return resourceMapper.insert(record);
    }

   
    public Resource selectByPrimaryKey(Integer id) {
    	return resourceMapper.selectByPrimaryKey(id);
    }

    
    public List<Resource> selectAll(){
    	return resourceMapper.selectAll();
    }

    
    public int updateByPrimaryKey(Resource record) {
    	return resourceMapper.updateByPrimaryKey(record);
    }


	public int setResourceForRole(Map<String, Object> resourcemap) {
		return resourceMapper.setResourceMapper(resourcemap);
	}

}
