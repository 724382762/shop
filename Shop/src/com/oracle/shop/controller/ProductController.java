package com.oracle.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.shop.model.dao.ProductDAO;
import com.oracle.shop.model.javabean.Goods;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	
	@RequestMapping("/list")
	public String listProduct(Model  m){
		System.out.println("进入后台");
		List<Goods> gs = dao.listGoods();
		System.out.println(gs);
		m.addAttribute("gs", gs);
		return "index";
	}

}
