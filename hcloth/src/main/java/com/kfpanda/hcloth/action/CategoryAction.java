package com.kfpanda.hcloth.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfpanda.hcloth.biz.CategoryBiz;

@Controller("categoryAction")
@RequestMapping("/category")
public class CategoryAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(CategoryAction.class);
	
	@Resource(name="categoryBiz")
	private CategoryBiz categoryBiz;
	
	@RequestMapping(value = "/list")
	public @ResponseBody Object list(@RequestParam(value = "keywords", required = false)String keywords) {
		if(StringUtils.isBlank(keywords)) {
			return this.getResult(categoryBiz.findAll());
		}
		return this.getResult(categoryBiz.findByCategory(keywords));
	}
	
}