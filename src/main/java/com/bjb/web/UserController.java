package com.bjb.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.domain.User;
import com.bjb.service.UserService;

/**
 * 用户控制类
 * 
 * @author jiangzy
 *
 */
@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService userService;
	HashMap<String, Object> hash = new HashMap<String, Object>();
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

	// 获取头部显示
	@RequestMapping("header")
	public Map<String, Object> header(HttpSession httpSession) {
		if (httpSession.getAttribute("LOGIN_INFO") == null) {
			hash.put("status", "failure");
			hash.put("msg", "not_login");
		} else {
			hash.put("status", "success");
			hash.put("msg", userService.header(httpSession));
		}
		return hash;
	}
	// 校样用户名是否存在
	@RequestMapping("proof")
	public HashMap<String, Object> proof(User user) {
		if (userService.proof(user)) {
			hash.put("status", "success");
			hash.put("msg", "用户存在");
		} else{
			hash.put("status", "failure");
			hash.put("msg", "用户不存在");
		}
		return hash;
	}

	// 用户登录
	@RequestMapping("login")
	public HashMap<String, Object> login(User user,
			HttpSession httpSession) {
		System.out.println(user.getUser_name());
		System.out.println(user.getPassword());

		if (userService.login(user, httpSession)) {
			hash.put("status", "success");
			hash.put("msg", "校样成功！");
		} else {
			hash.put("status", "failure");
			hash.put("msg", "登录失败！用户名或密码错误，请重新输入！");
		}
		return hash;
	}

	// 安全退出
	@RequestMapping("out")
	public boolean out(HttpSession httpSession) {
		httpSession.invalidate();
		return true;
	}

}
