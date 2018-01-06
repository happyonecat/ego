package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.dubbo.service.TbItemParamDubboService;
import com.ego.mapper.TbItemParamMapper;
import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemParamExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TbItemParamDubboServiceImpl implements TbItemParamDubboService {
	@Resource
	private TbItemParamMapper tbItemParamMapper;
	@Override
	public EasyUIDatagrid showPage(int page, int rows) {
		PageHelper.startPage(page,rows);
		//只要数据库中列有text类型,逆向工程在生成时都会有withblobs的方法
		//带有withBLOBs表示查询时text列也被查询出来.
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(new TbItemParamExample());
		PageInfo<TbItemParam> pi = new PageInfo<>(list);
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(pi.getList());
		datagrid.setTotal(pi.getTotal());
		return datagrid;
	}
	@Override
	public TbItemParam selByItemcatid(long itemCatId) {
		TbItemParamExample example = new TbItemParamExample();
		example.createCriteria().andItemCatIdEqualTo(itemCatId);
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null; 
	}
	@Override
	public int insParamSelective(TbItemParam param) {
		return tbItemParamMapper.insertSelective(param);
	}
	@Override
	public int delById(long id) {
		return tbItemParamMapper.deleteByPrimaryKey(id);
	}
}
