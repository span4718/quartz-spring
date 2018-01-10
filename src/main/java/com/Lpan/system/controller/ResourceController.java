package com.Lpan.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Lpan.system.model.Resource;
import com.Lpan.system.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/addResource")
	@ResponseBody
	public String addResource(HttpServletRequest request,@RequestBody Resource resource) {
		int insert = resourceService.insert(resource);	
		return "Success";
	}
	
	@RequestMapping("/updateResource")
	@ResponseBody
	public String updateResource(HttpServletRequest request,@RequestBody Resource resource) {
		int key = resourceService.updateByPrimaryKey(resource);		
		return "Success";
	}

}
