package com.Lpan.RequestJson;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/json")
public class JsonRequestController {
	
	private Logger logger = Logger.getLogger(JsonRequestController.class);
	
	@RequestMapping("/temp")
	public String temp(HttpServletRequest request) {
		String parameter = request.getParameter("temparam");
		String url = null;
		if(null != parameter && !"".equals(parameter)) {
			if("1".equals(parameter)) {
				url = "/requestJson/json_one";
			}
		}
		return url;
	}
	
	@RequestMapping(value = "/testOne")
	public String getRequestJson(@RequestBody(required=true) Map<String,Object> param) {
		String username = param.get("username").toString();
		String password = param.get("password").toString();
		//JSONObject jsonParams = BaseControllerRequest.getJSONParams(request);
		//logger.info(jsonParams);
		return null;
	}
	
	
	
	
}
