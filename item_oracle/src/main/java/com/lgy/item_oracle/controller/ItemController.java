package com.lgy.item_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.item_oracle.service.ItemContentService;
import com.lgy.item_oracle.service.ItemService;
import com.lgy.item_oracle.service.ItemWriteService;

@Controller
public class ItemController {
	ItemService service;
	@RequestMapping("/item_write")
	public String item_write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		service = new ItemWriteService();
		service.excute(model);
		return "write_result";
	}
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		service = new ItemContentService();
		service.excute(model);
		return "content_view";
	}

}
