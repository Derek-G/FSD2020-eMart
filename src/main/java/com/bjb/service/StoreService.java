package com.bjb.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjb.dao.StoreDao;
import com.bjb.domain.StoreRepository;

/**
 * 店铺服务类
 * @author jiangzy
 *
 */
@Service
public class StoreService {
	@Autowired
	StoreDao storeDao = new StoreRepository();
	//获取登录者店铺信息
	public List<Map<String, Object>> my_store(HttpSession httpSession){
		return storeDao.my_store(httpSession);
	}
}
