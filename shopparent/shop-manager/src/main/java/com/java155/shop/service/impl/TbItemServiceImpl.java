package com.java155.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java155.shop.mapper.TbItemMapper;
import com.java155.shop.pojo.TbItem;
import com.java155.shop.pojo.TbItemExample;
import com.java155.shop.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbItemServiceImpl implements TbItemService {

	@Autowired
	private	TbItemMapper mapper;

	//分页查询
	public PageInfo<TbItem> list(int pageNum,int pageSize){

		Page<TbItem> page = PageHelper.startPage(pageNum, pageSize);
		List<TbItem> tbItems = mapper.selectByExample(null);

		return new PageInfo<>(page);

	}

	//模糊查询
	public PageInfo<TbItem> findByTitle(String title,int pageNum, int pageSize){
		TbItemExample tbItemExample=new TbItemExample();
		tbItemExample.createCriteria().andTitleLike("%"+title+"%");

		Page<TbItem> page = PageHelper.startPage(pageNum, pageSize);
		List<TbItem> tbItems = mapper.selectByExample(tbItemExample);

		return new PageInfo<>(page);
	}


}
