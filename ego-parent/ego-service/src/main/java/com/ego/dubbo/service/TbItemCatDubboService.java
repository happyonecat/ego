package com.ego.dubbo.service;

import java.util.List;

import com.ego.pojo.TbItemCat;

public interface TbItemCatDubboService {
	/**
	 * 根据父类目id查询所有子类目
	 * @param pid
	 * @return
	 */
	List<TbItemCat> selByPid(long pid);
	/**
	 * 根据id查询商品类目
	 * @param id
	 * @return
	 */
	TbItemCat selById(long id);
}
