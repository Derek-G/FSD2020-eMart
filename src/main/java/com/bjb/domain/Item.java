package com.bjb.domain;

/**
 * 商品实体类
 * 
 * @author jiangzy
 *
 */
public class Item {
	private String act;//操作
	private int item_id; // 商品ID
	private String item_name; // 商品名称
	private String item_price; // 商品价格
	private int store_id; // 店铺ID
	private int del_flg; // 删除FLG
	private String create_time; // 创建时间
	private int create_id; // 创建者ID
	private String update_time; // 更新时间
	private int update_id; // 更新者ID

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
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

	public String getItem_price() {
		return item_price;
	}

	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
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
