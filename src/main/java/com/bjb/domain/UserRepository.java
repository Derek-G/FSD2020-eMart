package com.bjb.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bjb.dao.UserDao;

/**
 * 用户持久化类
 * 
 * @author jiangzy
 *
 */
@Repository
public class UserRepository implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	boolean flag = false;
	String sql = null;

	// 获取头部信息
	public List<Map<String, Object>> header(HttpSession httpSession) {
		int user_id = (Integer) httpSession.getAttribute("user_id");
		sql = "select * from deal_user where user_id = " + user_id;
		return list = jdbcTemplate.queryForList(sql);
	}

	// 校样用户名是否存在
	public boolean proof(User user) {
		sql = "select * from deal_user where user_name = '"
				+ user.getUser_name() + "'";
		list = jdbcTemplate.queryForList(sql);
		if (!list.isEmpty()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	// 用户登录
	public boolean login(User user, HttpSession httpSession) {
		if ("login".equals(user.getAct())) {
			sql = "select * from deal_user where user_name = '"
					+ user.getUser_name() + "' and password = '"
					+ user.getPassword() + "'";
			list = jdbcTemplate.queryForList(sql);
			if (!list.isEmpty()) {
				httpSession.setAttribute("LOGIN_INFO", list);
				httpSession.setAttribute("user_id", list.get(0).get("user_id"));
				flag = true;
			} else {
				flag = false;
			}
		} else if ("signup".equals(user.getAct())) {
			sql = "insert into deal_user (user_name ,password) values ('"
					+ user.getUser_name() + "','" + user.getPassword() + "')";
			int result = jdbcTemplate.update(sql);
			if (result == 1) {
				flag = true;
			}
		}
		return flag;
	}

}
