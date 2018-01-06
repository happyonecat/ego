package com.ego.manage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.dubbo.service.TbItemCatDubboService;
import com.ego.dubbo.service.TbItemParamDubboService;
import com.ego.manage.pojo.TbItemParamChild;
import com.ego.manage.service.TbItemParamService;
import com.ego.pojo.TbItemParam;

/*
 * 如果使用dubbo的@Service,程序任务这个一个服务实现.
 * 
 * 如果启动manage时,报异常一人里面某个类是是一个服务.一定是注解包导错.
 * 
 * 使用spring的@Service表示把类交给spring容器.为了在controller能注入这个类的对象.
 */
@Service
public class TbItemParamServiceImpl implements TbItemParamService{
	@Reference
	private TbItemParamDubboService tbItemParamDubboService;
	@Reference
	private TbItemCatDubboService tbItemCatDubboService;
	@Override
	public EasyUIDatagrid showPage(int page, int rows) {
		EasyUIDatagrid datagrid = tbItemParamDubboService.showPage(page, rows);
		List<TbItemParam> list = (List<TbItemParam>) datagrid.getRows();
		List<TbItemParamChild> listChild = new ArrayList<>();
		for (TbItemParam param : list) {
			TbItemParamChild child = new TbItemParamChild();
			child.setCreated(param.getCreated());
			child.setId(param.getId());
			child.setItemCatId(param.getItemCatId());
			child.setParamData(param.getParamData());
			child.setUpdated(param.getUpdated());
			child.setItemCatName(tbItemCatDubboService.selById(child.getItemCatId()).getName());
			listChild.add(child);
		}
		datagrid.setRows(listChild);
		return datagrid;
	}
	@Override
	public TbItemParam selParamByCatId(long catid) {
		return tbItemParamDubboService.selByItemcatid(catid);
	}
	@Override
	public int insParam(long catid, String paramData) {
		TbItemParam param = new TbItemParam();
		param.setItemCatId(catid);
		param.setParamData(paramData);
		Date date = new Date();
		param.setUpdated(date);
		param.setCreated(date);
		return tbItemParamDubboService.insParamSelective(param);
	}
	@Override
	public int delByIds(String ids) {
		int index = 0 ;
		String[] strs = ids.split(",");
		for (String string : strs) {
			index +=tbItemParamDubboService.delById(Long.parseLong(string));
		}
		if(index==strs.length){
			return 1;
		}
		return 0;
	}
}
