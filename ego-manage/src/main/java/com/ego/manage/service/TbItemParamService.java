package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.pojo.TbItemParam;

public interface TbItemParamService {
	/**
	 * ��ʾ��������Ϣ
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDatagrid  showPage(int page,int rows);
	
	/**
	 * ����catid��ѯ������
	 * @return
	 */
	TbItemParam selParamByCatId(long catid);
	
	/**
	 * ����������
	 * @param catid
	 * @param paramData
	 * @return
	 */
	int insParam(long catid,String paramData);
	
	/**
	 * ����ɾ��
	 * @param ids
	 * @return
	 */
	int delByIds(String ids);
}
