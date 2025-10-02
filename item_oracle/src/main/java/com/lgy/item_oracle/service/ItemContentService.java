package com.lgy.item_oracle.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.lgy.item_oracle.dao.ItemDAO;
import com.lgy.item_oracle.dto.ItemDTO;

public class ItemContentService implements ItemService{

	@Override
	public void excute(Model model) {
		ItemDAO itemdao = new ItemDAO();
		ArrayList<ItemDTO> idto = itemdao.content_view();
		model.addAttribute("content_view",idto);
		
	}

}
