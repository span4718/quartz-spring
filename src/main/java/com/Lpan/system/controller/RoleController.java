package com.Lpan.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Lpan.system.model.Role;
import com.Lpan.system.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("addRole")
	@ResponseBody
	public String addRole(HttpServletRequest request,@RequestBody Role role) {
		int insert = roleService.insert(role);
		
		return "Success";
	}
	
	@RequestMapping("/updateRole")
	@ResponseBody
	public String updateRole(HttpServletRequest request,@RequestBody Role role) {
		int key = roleService.updateByPrimaryKey(role);
		return "Success";
	}

}
