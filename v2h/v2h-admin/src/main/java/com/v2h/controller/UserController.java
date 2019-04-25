package com.v2h.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: UserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2019年3月20日 上午10:55:15
 * @author dlz
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Value("${login.loginName}")
	private String loginNameFile;

	@Value("${login.loginPass}")
	private String loginPassFile;

	@ApiOperation(value = "用户登录", notes = "根据传入的用户名和密码登入系统")
	@ApiImplicitParams({ @ApiImplicitParam(name = "loginName", value = "登录名", paramType = "query"),
			@ApiImplicitParam(name = "loginPass", value = "登录密码", paramType = "query") })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONObject userLogin(String loginName,String loginPass) {
		JSONObject json = new JSONObject();
		
		if (loginName != null && !loginName.equals("")) {
			if (loginPass != null && !loginPass.equals("")) {
				if (loginName.equals(loginNameFile) && loginNameFile.equals(loginPass)) {
					json.put("loginMessager", "success");
					return json;
				}
			}
		}
		json.put("loginMessager", "fault");
		
		return json;
	}

}
