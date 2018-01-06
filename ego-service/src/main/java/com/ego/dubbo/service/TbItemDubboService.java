package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.pojo.TbItem;

public interface TbItemDubboService {
	/**
	 * ��ҳ��ʾ��Ʒ��Ϣ
	 * @param page �ڼ�ҳ
	 * @param rows ��ʾ����
	 * @return
	 */
	EasyUIDatagrid showPage(int page,int rows);
	/**
	 * ����id�޸�status������
	 * @param id
	 * @param status
	 * @return
	 */
	int updStatusById(long id,byte status);
	/**
	 * ����
	 * @param item
	 * @return
	 */
	int insItem(TbItem item);
}
