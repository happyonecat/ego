package com.ego.dubbo.service.impl;

import javax.annotation.Resource;

import com.ego.dubbo.service.TbItemParamItemDubboService;
import com.ego.mapper.TbItemParamItemMapper;
import com.ego.pojo.TbItemParamItem;

public class TbItemParamItemDubboServiceImpl implements TbItemParamItemDubboService {
	@Resource
	private TbItemParamItemMapper tbItemParamItemMapper;
	@Override
	public int insParamItemSelective(TbItemParamItem item) {
		return tbItemParamItemMapper.insertSelective(item);
	}
}
