package com.ego.manage.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.utils.FtpUtil;
import com.ego.commons.utils.IDUtils;
import com.ego.dubbo.service.TbItemDescDubboService;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.dubbo.service.TbItemParamItemDubboService;
import com.ego.manage.service.TbItemService;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;
import com.ego.pojo.TbItemParamItem;

@Service
public class TbItemServiceImpl implements TbItemService {
	// 去注册中心获取对象代理对象.
	@Reference
	private TbItemDubboService tbItemDubboService;
	@Reference
	private TbItemDescDubboService	tbItemDescDubboService;
	@Reference
	private TbItemParamItemDubboService tbItemParamItemDubboService;
	
	@Value("${vsftpd.host}")
	private String host;
	@Value("${vsftpd.port}")
	private int port;
	@Value("${vsftpd.username}")
	private String username;
	@Value("${vsftpd.password}")
	private String password;
	@Value("${vsftpd.basePath}")
	private String basePath;
	@Value("${vsftpd.filePath}")
	private String filePath;
	@Value("${nginx.url}")
	private String nginxUrl;

	@Override
	public Map<String, Object> upload(MultipartFile file) {
		Map<String, Object> map = new HashMap<>();
		String fileName = IDUtils.genImageName()
				+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		try {
			boolean result = FtpUtil.uploadFile(host, port, username, password, basePath, filePath, fileName,
					file.getInputStream());
			if (result) {
				map.put("error", 0);
				map.put("url", nginxUrl + fileName);
			} else {
				map.put("error", 1);
				map.put("message", "上传图片失败");
			}
		} catch (IOException e) {
			e.printStackTrace();
			map.put("error", 1);
			map.put("message", "上传图片失败");
		}
		return map;
	}

	@Override
	public EasyUIDatagrid show(int page, int rows) {
		return tbItemDubboService.showPage(page, rows);
	}

	@Override
	public int updStatusById(String ids, byte status) {
		String[] str = ids.split(",");
		int index = 0;
		for (String string : str) {
			index += tbItemDubboService.updStatusById(Long.parseLong(string), status);
		}
		if (index == str.length) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int insItem(TbItem item, String desc,String itemParams) {
		long id = IDUtils.genItemId();
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		item.setId(id);
		item.setStatus((byte)1);
		//新增商品
		int index = tbItemDubboService.insItem(item);
		
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setCreated(date);
		tbItemDesc.setUpdated(date);
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setItemId(id);
		//新增描述
		index +=tbItemDescDubboService.insDesc(tbItemDesc);
		//新增商品规格
		TbItemParamItem paramItem = new TbItemParamItem();
		paramItem.setCreated(date);
		paramItem.setItemId(id);
		paramItem.setUpdated(date);
		paramItem.setParamData(itemParams);
		index += tbItemParamItemDubboService.insParamItemSelective(paramItem);
		
		if(index==3){
			return 1;
		}
		return 0;
	}

}
