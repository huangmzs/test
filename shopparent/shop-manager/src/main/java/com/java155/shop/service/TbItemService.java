package com.java155.shop.service;

import com.github.pagehelper.PageInfo;
import com.java155.shop.pojo.TbItem;

import javax.management.NotCompliantMBeanException;

public interface TbItemService {
	PageInfo<TbItem> list(int pageNum, int pageSize);

	PageInfo<TbItem> findByTitle(String title,int pageNum, int pageSize);
	
}
