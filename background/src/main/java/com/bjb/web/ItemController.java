package com.bjb.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.domain.Item;
import com.bjb.service.ItemService;

/**
 * 商品控制器类
 * 
 * @author jiangzy
 *
 */
@RestController
@RequestMapping("items")
public class ItemController {
	@Autowired
	private ItemService itemService;
	HashMap<String, Object> hash = new HashMap<String, Object>();
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

	// 获取首页商品数据
	@RequestMapping("home_item")
	public List<Map<String, Object>> home_item() {
		return list = itemService.home_item();
	}

	// 获取我的商品数据
	@RequestMapping("my_item")
	public List<Map<String, Object>> my_item(HttpSession httpSession) {
		return list = itemService.my_item(httpSession);
	}

	// 获取需要修改的商品信息
	@RequestMapping("current_goods")
	public List<Map<String, Object>> current_goods_modify(@RequestBody int item_id) {
		list = itemService.current_goods(item_id);
		return list;
	}

	// 编辑商品
	@RequestMapping("edit_goods")
	public HashMap<String, Object> edit_goods(@RequestBody Item item,
			HttpSession httpSession) {
		System.out.println(item.getItem_name());
		System.out.println(item.getItem_price());
		if (itemService.edit_goods(item, httpSession)) {
			hash.put("status", "success");
			hash.put("msg", "商品编辑成功！");
		} else {
			hash.put("status", "failure");
			hash.put("msg", "商品编辑失败！");
		}
		return hash;
	}

}
