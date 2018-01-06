package com.ego.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbItemParamService;
import com.ego.pojo.TbItemParam;

@Controller
public class TbItemParamController {
	@Resource
	private TbItemParamService tbItemParamService;
	/**
	 * 显示规格参数
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("item/param/list")
	@ResponseBody
	public EasyUIDatagrid showPage(int page,int rows){
		return tbItemParamService.showPage(page, rows);
	}
	/**
	 * 根据类目id查询类目详情
	 * @param catid
	 * @return
	 */
	@RequestMapping("item/param/query/itemcatid/{catid}")
	@ResponseBody
	public EgoResult selByCatId(@PathVariable long catid){
		EgoResult er = new EgoResult();
		TbItemParam param = tbItemParamService.selParamByCatId(catid);
		if(param==null){
			er.setStatus(400);
		}else{
			er.setStatus(200);
			er.setData(param);
		}
		return er;
	}
	/**
	 * 规格参数新增
	 * @param catid
	 * @param paramData
	 * @return
	 */
	@RequestMapping("item/param/save/{catid}")
	@ResponseBody
	public EgoResult save(@PathVariable long catid,String paramData){
		EgoResult er = new EgoResult();
		try {
			int index = tbItemParamService.insParam(catid, paramData);
			if(index>0){
				er.setStatus(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			er.setStatus(500);
		}
		return er;
	}
	/**
	 * 根据传递的ids删除对饮规格参数
	 * @param ids
	 * @return
	 */
	@RequestMapping("item/param/delete")
	@ResponseBody
	public EgoResult delete(String ids){
		EgoResult er = new EgoResult();
		try {
			int index = tbItemParamService.delByIds(ids);
			if(index>0){
				er.setStatus(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			er.setStatus(500);
		}
		return er;
	}
}
