package com.ego.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUITree;
import com.ego.dubbo.service.TbItemCatDubboService;
import com.ego.manage.service.TbItemCatService;
import com.ego.pojo.TbItemCat;

@Service
public class TbItemCatServiceImpl implements TbItemCatService {
	@Reference
	private TbItemCatDubboService tbItemCatDubboService;
	@Override
	public List<EasyUITree> show(long pid) {
		List<TbItemCat> list = tbItemCatDubboService.selByPid(pid);
		List<EasyUITree> listTree = new ArrayList<EasyUITree>();
		for (TbItemCat cat : list) {
			EasyUITree tree = new EasyUITree();
			
			tree.setId(cat.getId());
			tree.setText(cat.getName());
			tree.setState(cat.getIsParent()?"closed":"open");
			
			
			listTree.add(tree);
		}
		return listTree;
	}
}
