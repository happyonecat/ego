package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.pojo.TbItemParam;

public interface TbItemParamDubboService {
	/**
	 * 查询规格参数,分页显示
	 * @param page
	 * @param row数,分页显示
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDatagrid showPage(int page,int rows);
	
	/**
	 * 根据类目id查询规格参数
	 * @param itemCatId
	 * @return
	 */
	TbItemParam selByItemcatid(long itemCatId);
	
	/**
	 * 新增,主键自增
	 * @param param
	 * @return
	 */
	int insParamSelective(TbItemParam param);
	/**
	 * 根据主键删除
	 * @return
	 */
	int delById(long id);
}
