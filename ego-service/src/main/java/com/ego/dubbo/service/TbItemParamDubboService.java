package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.pojo.TbItemParam;

public interface TbItemParamDubboService {
	/**
	 * ��ѯ������,��ҳ��ʾ
	 * @param page
	 * @param row��,��ҳ��ʾ
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDatagrid showPage(int page,int rows);
	
	/**
	 * ������Ŀid��ѯ������
	 * @param itemCatId
	 * @return
	 */
	TbItemParam selByItemcatid(long itemCatId);
	
	/**
	 * ����,��������
	 * @param param
	 * @return
	 */
	int insParamSelective(TbItemParam param);
	/**
	 * ��������ɾ��
	 * @return
	 */
	int delById(long id);
}
