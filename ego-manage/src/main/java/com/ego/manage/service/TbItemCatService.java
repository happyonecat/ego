package com.ego.manage.service;

import java.util.List;

import com.ego.commons.pojo.EasyUITree;

public interface TbItemCatService {
	/**
	 * ���ݸ���Ŀid��ѯ��������Ŀ��Ϣ,��ת��Ϊeasyuitree�ڵ�����
	 * @param pid
	 * @return
	 */
	List<EasyUITree> show(long pid);
}
