package com.bjb.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjb.dao.OrderDao;
import com.bjb.domain.Item;
import com.bjb.domain.Order;
import com.bjb.domain.OrderRepository;

/**
 * 订单服务类
 * @author jiangzy
 *
 */
@Service
public class OrderService {
	@Autowired
	OrderDao orderDao = new OrderRepository();
	//获取登录者订单信息
	public List<Map<String, Object>> my_order(HttpSession httpSession){
		return orderDao.my_order(httpSession);
	}
	//获取卖家出售订单信息
	public List<Map<String, Object>> sell_orders(HttpSession httpSession){
		return orderDao.sell_orders(httpSession);
	}
	//添加订单
	public boolean add_order(Item item, HttpSession httpSession){
		return orderDao.add_order(item, httpSession);
	}
	//支付订单
	public boolean pay_order(Order order, HttpSession httpSession){
		return orderDao.pay_order(order, httpSession);
	}
	//取消订单
	public boolean cancel_order(Order order){
		return orderDao.cancel_order(order);
	}
	//删除订单
	public boolean del_order(Order order){
		return orderDao.del_order(order);
	}
	//确认收货
	public boolean affirm_goods(Order order){
		return orderDao.affirm_goods(order);
	}
	//发货
	public boolean send_goods(Order order,HttpSession httpSession){
		return orderDao.send_goods(order,httpSession);
	}
}
