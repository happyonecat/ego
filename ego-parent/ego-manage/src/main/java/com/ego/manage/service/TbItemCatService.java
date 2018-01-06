package com.ego.manage.service;

import java.util.List;

import com.ego.commons.pojo.EasyUITree;

public interface TbItemCatService {
	/**
	 * 根据父类目id查询所有子类目信息,并转换为easyuitree节点类型
	 * @param pid
	 * @return
	 */
	List<EasyUITree> show(long pid);
}
