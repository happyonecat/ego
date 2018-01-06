package com.ego.manage.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.pojo.TbItem;

public interface TbItemService {
	/**
	 * 显示商品详情.
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDatagrid show(int page,int rows);
	/**
	 * 根据id修改status
	 * @param ids
	 * @param status
	 * @return
	 */
	int updStatusById(String ids,byte status);
	
	/**
	 * 图片上传
	 * @param file
	 * @return
	 */
	Map<String,Object> upload(MultipartFile file);
	/**
	 * 新增商品和商品描述(规格新增)
	 * @param item
	 * @param desc
	 * @return
	 */
	int insItem(TbItem item,String desc,String itemParams);
}
