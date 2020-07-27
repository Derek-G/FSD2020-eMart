package com.bjb.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.bjb.domain.Item;
import com.bjb.domain.Order;

/**
 * 订单接口类
 * 
 * @author jiangzy
 *
 */
public interface OrderDao {
	// 获取登录者订单信息
	public List<Map<String, Object>> my_order(HttpSession httpSession);
	// 获取卖家出售订单信息
	public List<Map<String, Object>> sell_orders(HttpSession httpSession);
	// 添加订单
	public boolean add_order(Item item, HttpSession httpSession);
	// 支付订单
	public boolean pay_order(Order order, HttpSession httpSession);
	// 取消订单
	public boolean cancel_order(Order order);
	// 删除订单
	public boolean del_order(Order order);
	// 确认收货
	public boolean affirm_goods(Order order);
	// 发货
	public boolean send_goods(Order order,HttpSession httpSession);

}
