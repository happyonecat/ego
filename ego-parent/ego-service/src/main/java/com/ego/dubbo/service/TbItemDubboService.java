package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.pojo.TbItem;

public interface TbItemDubboService {
	/**
	 * 分页显示商品信息
	 * @param page 第几页
	 * @param rows 显示几个
	 * @return
	 */
	EasyUIDatagrid showPage(int page,int rows);
	/**
	 * 根据id修改status的内容
	 * @param id
	 * @param status
	 * @return
	 */
	int updStatusById(long id,byte status);
	/**
	 * 新增
	 * @param item
	 * @return
	 */
	int insItem(TbItem item);
}
