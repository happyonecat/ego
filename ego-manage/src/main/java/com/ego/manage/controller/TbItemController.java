package com.ego.manage.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbItemService;
import com.ego.pojo.TbItem;

@Controller
public class TbItemController {
	@Resource
	private TbItemService tbItemServiceImpl;
	@RequestMapping("item/list")
	@ResponseBody
	public EasyUIDatagrid show(int page,int rows){
		return tbItemServiceImpl.show(page, rows);
	}
	/**
	 * ɾ��
	 * @param ids
	 * @return
	 */
	@RequestMapping("rest/item/delete")
	@ResponseBody
	public EgoResult delete(String ids){
		EgoResult er = new EgoResult();
		try {
			int index = tbItemServiceImpl.updStatusById(ids, (byte)3);
			if(index>0){
				er.setStatus(200);
			}else{
				er.setStatus(400);
			}
		} catch (Exception e) {
			e.printStackTrace();
			er.setStatus(500);
		}
		return er;
	}
	/**
	 * �ϼ�
	 * @param ids
	 * @return
	 */
	@RequestMapping("rest/item/reshelf")
	@ResponseBody
	public EgoResult reshelf(String ids){
		EgoResult er = new EgoResult();
		try {
			int index = tbItemServiceImpl.updStatusById(ids, (byte)1);
			if(index>0){
				er.setStatus(200);
			}else{
				er.setStatus(400);
			}
		} catch (Exception e) {
			e.printStackTrace();
			er.setStatus(500);
		}
		return er;
	}
	/**
	 * �¼�
	 * @param ids
	 * @return
	 */
	@RequestMapping("rest/item/instock")
	@ResponseBody
	public EgoResult instock(String ids){
		EgoResult er = new EgoResult();
		try {
			int index = tbItemServiceImpl.updStatusById(ids, (byte)2);
			if(index>0){
				er.setStatus(200);
			}else{
				er.setStatus(400);
			}
		} catch (Exception e) {
			e.printStackTrace();
			er.setStatus(500);
		}
		return er;
	}
	/**
	 * ͼƬ�ϴ�
	 * @param uploadFile
	 * @return
	 */
	@RequestMapping("pic/upload")
	@ResponseBody
	public Map<String,Object> upload(MultipartFile uploadFile){
		return tbItemServiceImpl.upload(uploadFile);
	}
	/**
	 * ������Ʒ
	 * @param item
	 * @param desc
	 * @param itemParams
	 * @return
	 */
	@RequestMapping("item/save")
	@ResponseBody
	public EgoResult save(TbItem item ,String desc,String itemParams){
		EgoResult er = new EgoResult();
		int index = tbItemServiceImpl.insItem(item, desc,itemParams);
		if(index>0){
			er.setStatus(200);
		}else{
			er.setStatus(400);
		}
		return er;
	}
}
