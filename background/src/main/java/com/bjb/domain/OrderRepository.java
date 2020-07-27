package com.bjb.domain;

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

import com.bjb.dao.OrderDao;

/**
 * 订单持久化类
 * 
 * @author jiangzy
 *
 */
@Repository
public class OrderRepository implements OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	HashMap<String, Object> hash = new HashMap<String, Object>();
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	boolean flag = false;
	Date date = new Date();
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String time = format.format(date);
	String sql = null;

	// 获取登录者订单信息
	public List<Map<String, Object>> my_order(HttpSession httpSession) {
		int create_id = (Integer) httpSession.getAttribute("user_id");
		sql = "SELECT * FROM deal_order WHERE del_flg = '0' and create_id="
				+ create_id + " ORDER BY order_id DESC";
		return list = jdbcTemplate.queryForList(sql);
	}

	// 获取卖家出售订单信息
	public List<Map<String, Object>> sell_orders(HttpSession httpSession) {
		int user_id = (Integer) httpSession.getAttribute("user_id");
		sql = "SELECT * FROM deal_order WHERE store_id = (select store_id FROM deal_user where user_id = '"
				+ user_id + "') AND del_flg = '0' ORDER BY order_id DESC";
		return list = jdbcTemplate.queryForList(sql);
	}

	// 添加订单
	public boolean add_order(Item item, HttpSession httpSession) {
		sql = "SELECT * FROM deal_item left join deal_store on deal_item.store_id = deal_store.store_id WHERE item_id = "
				+ item.getItem_id();
		list = jdbcTemplate.queryForList(sql);

		int item_id = (Integer) list.get(0).get("item_id");
		String item_name = (String) list.get(0).get("item_name");
		String item_price = (String) list.get(0).get("item_price");
		int store_id = (Integer) list.get(0).get("store_id");
		String store_name = (String) list.get(0).get("store_name");

		int payment_state = 0;
		int send_state = 0;
		int save_state = 0;
		int order_state = 0;
		int del_flg = 0;
		String create_time = time;
		int user_id = (Integer) httpSession.getAttribute("user_id");
		String update_time = time;

		sql = "insert into deal_order"
				+ "(item_id, item_name, item_price, store_id, store_name, payment_state, send_state,save_state,order_state,del_flg,create_time,create_id,update_time,update_id) "
				+ "values ("
				+ item_id
				+ ",'"
				+ item_name
				+ "','"
				+ item_price
				+ "',"
				+ store_id
				+ ",'"
				+ store_name
				+ "',"
				+ payment_state
				+ ","
				+ send_state
				+ ","
				+ save_state
				+ ","
				+ order_state
				+ ","
				+ del_flg
				+ ",'"
				+ create_time
				+ "',"
				+ user_id
				+ ",'"
				+ update_time + "'," + user_id + ")";

		int result = jdbcTemplate.update(sql);
		if (result == 1) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	// 支付订单
	public boolean pay_order(Order order, HttpSession httpSession) {
		sql = "SELECT item_price,store_id FROM deal_order WHERE order_id = "
				+ order.getOrder_id();
		list = jdbcTemplate.queryForList(sql);
		int price = Integer.parseInt((String) list.get(0).get("item_price"));
		int store_id = (Integer) ((Map<String, Object>) list.get(0))
				.get("store_id");
		String user_name = ((Map<String, String>) ((List) httpSession
				.getAttribute("LOGIN_INFO")).get(0)).get("user_name");
		sql = "SELECT money FROM deal_user WHERE user_name = '" + user_name
				+ "'";
		list = jdbcTemplate.queryForList(sql);
		int money = Integer.parseInt((String) (list.get(0)).get("money"));
		if (money < price) {
			flag = false;
		} else {
			sql = "UPDATE deal_user SET money = money - " + price
					+ " WHERE user_name = '" + user_name + "'";
			// 更新买家的余额，（用户余额减商品价格）
			jdbcTemplate.update(sql);
			// 更新卖家的余额，（用户未到账余额加商品价格）
			sql = "UPDATE deal_store SET road_money = road_money + " + price
					+ " WHERE store_id = " + store_id;
			jdbcTemplate.update(sql);

			int payment_state = 1;
			sql = "update deal_order set payment_state =" + payment_state
					+ " where order_id =" + order.getOrder_id();
			// 更新支付状态
			int res = jdbcTemplate.update(sql);
			if (res == 1) {
				flag = true;
			}
		}
		return flag;
	}

	// 取消订单
	public boolean cancel_order(Order order) {
		int order_state = 2;
		sql = "update deal_order set order_state =" + order_state
				+ " where order_id =" + order.getOrder_id();
		int result = jdbcTemplate.update(sql);
		if (result == 1) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	// 删除订单
	public boolean del_order(Order order) {
		int del_flg = 1;
		sql = "update deal_order set del_flg =" + del_flg + " where order_id ="
				+ order.getOrder_id();
		int result = jdbcTemplate.update(sql);
		if (result == 1) {
			hash.put("status", "1");
			hash.put("msg", "删除成功！");
			flag = true;
		} else {
			flag = false;
			hash.put("status", "1");
			hash.put("msg", "删除失败！");
		}
		return flag;
	}

	// 确认收货
	public boolean affirm_goods(Order order) {
		sql = "SELECT item_price,store_id FROM deal_order WHERE order_id = "
				+ order.getOrder_id();
		list = jdbcTemplate.queryForList(sql);
		int price = Integer.parseInt((String) list.get(0).get("item_price"));
		int store_id = (Integer) ((Map<String, Object>) list.get(0))
				.get("store_id");
		sql = "UPDATE deal_store SET money = money +" + price
				+ ",road_money = road_money -" + price + " WHERE store_id = "
				+ store_id;
		// 将未到账余额转入余额
		jdbcTemplate.update(sql);

		int save_state = 1;
		int order_state = 1;
		sql = "update deal_order set save_state =" + save_state
				+ ", order_state = " + order_state + "  where order_id ="
				+ order.getOrder_id();
		// 更新订单状态
		int res = jdbcTemplate.update(sql);
		if (res == 1) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	// 发货
	public boolean send_goods(Order order, HttpSession httpSession) {
		int user_id = (Integer) httpSession.getAttribute("user_id");
		int send_state = 1;
		sql = "update deal_order set send_state =" + send_state
				+ ",update_time ='" + time + "',update_id =" + user_id
				+ " where order_id =" + order.getOrder_id();
		int result = jdbcTemplate.update(sql);
		if (result == 1) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

}
