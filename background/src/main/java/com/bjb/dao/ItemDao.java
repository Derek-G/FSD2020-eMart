package com.bjb.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.bjb.domain.Item;

/**
 * 商品接口类
 * @author jiangzy
 *
 */
public interface ItemDao {
	//获取首页商品信息
	public List<Map<String, Object>> home_item();
	//获取首页商品信息
	public List<Map<String, Object>> my_item(HttpSession httpSession);
	// 获取需要修改的商品信息
	public List<Map<String, Object>> current_goods(int item_id);
	//编辑商品信息
	public boolean edit_goods(Item item,HttpSession httpSession);
}
