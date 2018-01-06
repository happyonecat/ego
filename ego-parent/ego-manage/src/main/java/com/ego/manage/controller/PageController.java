package com.ego.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	/**
	 * 欢迎页控制器
	 * @return
	 */
	@RequestMapping("/")
	public String welcome(){
		return "index";
	}
	/**
	 * 其他页面显示控制器
	 * @param page
	 * @return
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
