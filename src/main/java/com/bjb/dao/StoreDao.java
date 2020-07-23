package com.bjb.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * 店铺接口类
 * @author jiangzy
 *
 */
public interface StoreDao {
	// 获取登录者店铺信息
	public List<Map<String, Object>> my_store(HttpSession httpSession);
}
