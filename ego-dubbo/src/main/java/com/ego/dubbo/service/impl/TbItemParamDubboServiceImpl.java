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
		//ֻҪ���ݿ�������text����,���򹤳�������ʱ������withblobs�ķ���
		//����withBLOBs��ʾ��ѯʱtext��Ҳ����ѯ����.
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
