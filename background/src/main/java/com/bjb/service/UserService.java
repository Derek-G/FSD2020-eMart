package com.bjb.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjb.dao.UserDao;
import com.bjb.domain.User;
import com.bjb.domain.UserRepository;
/**
 * 用户服务类
 * @author jiangzy
 *
 */
@Service
public class UserService {
	@Autowired
	UserDao userDao = new UserRepository();
	
	//获取头部信息
	public List<Map<String, Object>> header(HttpSession httpSession){
		return userDao.header(httpSession);
	}
	//校样用户名是否存在
	public boolean proof(User user){
		return userDao.proof(user);
	}
	//用户登录
	public boolean login(User user,HttpSession httpSession){
		return userDao.login(user,httpSession);
	}
	
}
