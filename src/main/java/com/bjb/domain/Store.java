package com.bjb.domain;

/**
 * 店铺实体类
 * @author jiangzy
 *
 */
public class Store {
	private int store_id;		//店铺ID
	private String store_name;	//店铺名称
	private String money;		//余额
	private String road_money;	//未到账余额
	private int del_flg;		//删除FLG
	private String create_time;	//创建时间
	private int create_id;		//创建者ID
	private String updatd_time;	//更新时间
	private int update_id;		//更新者ID
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
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getRoad_money() {
		return road_money;
	}
	public void setRoad_money(String road_money) {
		this.road_money = road_money;
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
	public String getUpdatd_time() {
		return updatd_time;
	}
	public void setUpdatd_time(String updatd_time) {
		this.updatd_time = updatd_time;
	}
	public int getUpdate_id() {
		return update_id;
	}
	public void setUpdate_id(int update_id) {
		this.update_id = update_id;
	}
	
}
