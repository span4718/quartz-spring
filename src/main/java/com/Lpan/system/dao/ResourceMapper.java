package com.Lpan.system.dao;

import java.util.List;
import java.util.Map;

import com.Lpan.system.model.Resource;


public interface ResourceMapper {
	
    int deleteByPrimaryKey(Integer id);

  
    int insert(Resource record);

   
    Resource selectByPrimaryKey(Integer id);

    
    List<Resource> selectAll();

    
    int updateByPrimaryKey(Resource record);


	int setResourceMapper(Map<String, Object> resourcemap);
}
