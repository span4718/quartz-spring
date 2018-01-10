package com.Lpan.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Lpan.system.model.Role;
import com.Lpan.system.model.User;
import com.Lpan.system.service.RoleService;
import com.Lpan.system.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(HttpServletRequest request,@RequestBody User user) {
		int insert = userService.insert(user);
		
		return "Success";
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(HttpServletRequest request,@RequestBody User user) {
		int key = userService.updateByPrimaryKey(user);
		return "Success";
	}
	
	@RequestMapping("/setRoleForUser")
	@ResponseBody
	public String addRoleToUser(HttpServletRequest request,@RequestBody Role role){
		int key = roleService.updateByPrimaryKey(role);
		return "Success";
	}
	
	
	

}
