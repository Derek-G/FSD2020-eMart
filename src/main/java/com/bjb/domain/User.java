package com.bjb.domain;


/**
 * 用户实体类
 * @author jiangzy
 *
 */
//@EntityScan
public class User {
	private String act;//操作
	private int user_id;		//用户ID
	private String money;		//余额
	private String user_name;	//用户名
	private String password;	//密码
	private String nickname;	//昵称
	private int status;			//身份标识
	private int store_id;		//店铺ID
	private int del_flg;		//删除FLG
	private String create_time;	//创建时间
	private int create_id;		//创建者ID
	private String update_time;	//更新时间
	private int update_id;		//更新者ID
	
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
