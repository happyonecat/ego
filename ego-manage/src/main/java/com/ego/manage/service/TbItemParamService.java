package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.pojo.TbItemParam;

public interface TbItemParamService {
	/**
	 * 显示规格参数信息
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDatagrid  showPage(int page,int rows);
	
	/**
	 * 根据catid查询规格参数
	 * @return
	 */
	TbItemParam selParamByCatId(long catid);
	
	/**
	 * 新增规格参数
	 * @param catid
	 * @param paramData
	 * @return
	 */
	int insParam(long catid,String paramData);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	int delByIds(String ids);
}
