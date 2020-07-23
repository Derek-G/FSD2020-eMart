package com.bjb.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjb.dao.StoreDao;

/**
 * 店铺持久化类
 * 
 * @author AUQFzy
 * 
 */
@Repository
public class StoreRepository implements StoreDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	HashMap<String, Object> hash = new HashMap<String, Object>();
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	String sql = null;

	//获取店铺信息
	public List<Map<String, Object>> my_store(HttpSession httpSession) {
		int user_id = (Integer) httpSession.getAttribute("user_id");
		sql = "SELECT store_id FROM deal_user WHERE user_id = " + user_id;
		int store_id = (Integer) jdbcTemplate.queryForList(sql).get(0)
				.get("store_id");
		sql = "SELECT * FROM deal_store WHERE store_id = " + store_id;
		return list = jdbcTemplate.queryForList(sql);
	}
	
}
