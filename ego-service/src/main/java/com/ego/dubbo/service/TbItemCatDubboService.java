package com.ego.dubbo.service;

import java.util.List;

import com.ego.pojo.TbItemCat;

public interface TbItemCatDubboService {
	/**
	 * ���ݸ���Ŀid��ѯ��������Ŀ
	 * @param pid
	 * @return
	 */
	List<TbItemCat> selByPid(long pid);
	/**
	 * ����id��ѯ��Ʒ��Ŀ
	 * @param id
	 * @return
	 */
	TbItemCat selById(long id);
}
