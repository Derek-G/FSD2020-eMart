package com.bjb.domain;

/**
 * 商品持久化类
 * 
 * @author jiangzy
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bjb.dao.ItemDao;

@Repository
public class ItemRepository implements ItemDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	HashMap<String, Object> hash = new HashMap<String, Object>();
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

	Date date = new Date();
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String time = format.format(date);
	boolean flag = false;
	String sql = null;

	// 获取首页商品数据
	@Override
	public List<Map<String, Object>> home_item() {
		sql = "SELECT * FROM deal_item left join deal_store on deal_item.store_id = deal_store.store_id where deal_item.del_flg = '0'";
		return list = jdbcTemplate.queryForList(sql);
	}

	// 获取店铺商品信息
	public List<Map<String, Object>> my_item(HttpSession httpSession) {
		int user_id = (Integer) httpSession.getAttribute("user_id");
		sql = "select * from deal_item where store_id = (select store_id FROM deal_user where user_id = '"
				+ user_id + "')  AND del_flg = '0'";
		return list = jdbcTemplate.queryForList(sql);
	}
	// 获取当前商品信息
	public List<Map<String, Object>> current_goods(int item_id) {
		sql = "SELECT * FROM deal_item WHERE item_id =" + item_id;
		return list = jdbcTemplate.queryForList(sql);
	}

	// 编辑商品
	public boolean edit_goods(Item item, HttpSession httpSession) {
		int user_id = (Integer) httpSession.getAttribute("user_id");
		int del_flg = 0; // 设置默认商品状态值为0（0为开启、1为关闭）
		System.out.println(item.getAct());
		System.out.println(item.getItem_id());
		System.out.println(item.getItem_name());
		System.out.println(item.getItem_price());
		if (item.getItem_id() == 0 && "edit".equals(item.getAct())) {
			// 添加商品
			System.out.println("进入添加");
			sql = "select store_id FROM deal_user where user_id = " + user_id;
			list = jdbcTemplate.queryForList(sql);
			int store_id = (Integer) ((Map<String, Object>) list.get(0))
					.get("store_id");
			sql = "insert into deal_item"
					+ "(item_name, item_price, store_id, del_flg,create_time,create_id,update_time,update_id) "
					+ "values ('" + item.getItem_name() + "','"
					+ item.getItem_price() + "'," + store_id + "," + del_flg
					+ ",'" + time + "'," + user_id + ",'" + time + "',"
					+ user_id + ")";
		} else if(item.getItem_id() != 0 && "edit".equals(item.getAct())){
			// 修改商品
			System.out.println("进入修改");
			sql = "update deal_item set item_name ='" + item.getItem_name()
					+ "' ,item_price ='" + item.getItem_price()
					+ "',update_time ='" + time + "',update_id =" + user_id
					+ " where item_id =" + item.getItem_id();
		}else {
			// 删除商品
			System.out.println("进入删除");
			del_flg = 1;
			sql = "update deal_item set del_flg =" + del_flg
					+ ",update_time ='" + time + "',update_id =" + user_id
					+ " where item_id =" + item.getItem_id();
			System.out.println(sql);
		}
		
		int result = jdbcTemplate.update(sql);
		if (result == 1) {
			flag = true;
		}
		return flag;
	}

	/*
	 * 删除商品
	 */
	public HashMap<String, Object> del_goods(int item_id, int user_id) {
		int del_flg = 1;
		sql = "update deal_item set del_flg =" + del_flg + ",update_time ='"
				+ time + "',update_id =" + user_id + " where item_id ="
				+ item_id;
		int result = jdbcTemplate.update(sql);
		if (result == 1) {
			hash.put("status", "1");
			hash.put("msg", "删除成功！");
		} else {
			hash.put("status", "1");
			hash.put("msg", "删除失败！");
		}
		return hash;
	}

}
