package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.mapper.TbItemMapper;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TbItemDubboServiceImpl implements TbItemDubboService {
	@Resource
	private TbItemMapper tbItemMapper;
	@Override
	public EasyUIDatagrid showPage(int page, int rows) {
		//1. 设置分页条件
		PageHelper.startPage(page, rows);
		//2. 查询全部
		List<TbItem> list = tbItemMapper.selectByExample(new TbItemExample());
		//3. 把查询结果放入到PageInfo
		PageInfo<TbItem> pi = new PageInfo<>(list);
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setTotal(pi.getTotal());
		datagrid.setRows(pi.getList());
		return datagrid;
	}
	@Override
	public int updStatusById(long id, byte status) {
		TbItem item = new TbItem();
		item.setId(id);
		item.setStatus(status);
		return tbItemMapper.updateByPrimaryKeySelective(item);
	}
	@Override
	public int insItem(TbItem item) {
		return tbItemMapper.insertSelective(item);
	}
}
