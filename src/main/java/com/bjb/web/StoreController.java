package com.bjb.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.service.StoreService;

/**
 * 店铺控制器类
 * @author jiangzy
 *
 */
@RestController
@RequestMapping("stores")
public class StoreController {
	@Autowired
	private StoreService storeService;
//	HashMap<String, Object> hash = new HashMap<String, Object>();
	List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	//获取登入者店铺信息
	@RequestMapping("my_store")
	public List<Map<String, Object>> my_store(HttpSession httpSession){
		return list = storeService.my_store(httpSession);
	}
}
