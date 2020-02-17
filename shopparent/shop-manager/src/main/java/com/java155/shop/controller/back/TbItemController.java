package com.java155.shop.controller.back;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.java155.shop.pojo.TbItem;
import com.java155.shop.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class TbItemController {

	@Autowired
	private TbItemService tbItemService;

	@RequestMapping(value = "/list.json",produces = "application/json;charset=utf-8")
	public String list(@RequestParam(defaultValue = "1",required = false) int pageNum, @RequestParam(defaultValue = "10",required = false) int pageSize){
		PageInfo<TbItem> list = tbItemService.list(pageNum, pageSize);
		String jsonString = JSON.toJSONString(list.getList());
		return jsonString;
	}
	@RequestMapping(value = "/item.list")
	public Map findByTitle(String keyword, @RequestParam(defaultValue = "1",required = false) int pageNum, @RequestParam(defaultValue = "10",required = false) int pageSize){
		PageInfo<TbItem> list = tbItemService.findByTitle(keyword,pageNum, pageSize);
		Map<String,Object> map = new HashMap<>();
		map.put("total", list.getTotal());
		map.put("rows", list.getList());
		return map;
	}
}
