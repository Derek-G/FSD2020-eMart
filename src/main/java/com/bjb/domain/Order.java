package com.bjb.domain;

/**
 * 订单实体类
 * @author jiangzy
 *
 */
public class Order {
	private int order_id;		//订单ID
	private int item_id;		//商品ID
	private String item_name;	//商品名称
	private String item_prive;	//商品价格
	private int store_id;		//店铺ID
	private String store_name;	//店铺名
	private int payment_state;	//支付状态
	private int send_state;		//发货状态
	private int save_state;		//收货状态
	private int order_state;	//订单状态
	private int del_flg;		//删除FLG
	private String create_time;	//创建时间
	private int create_id;		//创建者ID
	private String update_time;	//更新时间
	private int update_id;		//更新ID
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_prive() {
		return item_prive;
	}
	public void setItem_prive(String item_prive) {
		this.item_prive = item_prive;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public int getPayment_state() {
		return payment_state;
	}
	public void setPayment_state(int payment_state) {
		this.payment_state = payment_state;
	}
	public int getSend_state() {
		return send_state;
	}
	public void setSend_state(int send_state) {
		this.send_state = send_state;
	}
	public int getSave_state() {
		return save_state;
	}
	public void setSave_state(int save_state) {
		this.save_state = save_state;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public int getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(int del_flg) {
		this.del_flg = del_flg;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getCreate_id() {
		return create_id;
	}
	public void setCreate_id(int create_id) {
		this.create_id = create_id;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public int getUpdate_id() {
		return update_id;
	}
	public void setUpdate_id(int update_id) {
		this.update_id = update_id;
	}

}
