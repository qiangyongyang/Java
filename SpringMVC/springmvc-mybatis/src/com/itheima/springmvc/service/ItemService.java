package com.itheima.springmvc.service;

import java.util.List;

import com.itheima.springmvc.pojo.Items;

public interface ItemService {
	
	//查询商品列表
	public List<Items> selectItemsList();
	
	public Items findById(Integer id);
	
	public void itemUpdate(Items items);

}
