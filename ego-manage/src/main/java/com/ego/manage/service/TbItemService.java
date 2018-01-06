package com.ego.manage.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.pojo.TbItem;

public interface TbItemService {
	/**
	 * ��ʾ��Ʒ����.
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDatagrid show(int page,int rows);
	/**
	 * ����id�޸�status
	 * @param ids
	 * @param status
	 * @return
	 */
	int updStatusById(String ids,byte status);
	
	/**
	 * ͼƬ�ϴ�
	 * @param file
	 * @return
	 */
	Map<String,Object> upload(MultipartFile file);
	/**
	 * ������Ʒ����Ʒ����(�������)
	 * @param item
	 * @param desc
	 * @return
	 */
	int insItem(TbItem item,String desc,String itemParams);
}
