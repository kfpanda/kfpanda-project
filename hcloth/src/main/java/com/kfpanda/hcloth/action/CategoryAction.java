package com.kfpanda.hcloth.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfpanda.hcloth.biz.CategoryBiz;

@Controller("categoryAction")
@RequestMapping("/category")
public class CategoryAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(CategoryAction.class);
	
	@Resource(name="categoryBiz")
	private CategoryBiz categoryBiz;
	
	@RequestMapping(value = "/list")
	public @ResponseBody Object list() {
		return this.getResult(categoryBiz.findAll());
	}
	
}