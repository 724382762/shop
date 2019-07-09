package com.oracle.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/order")
public class OrderController {
	
	@RequestMapping("/add")
	public String addOrder(int[] pid,int[] count,String name,String address,String remark){
		
		System.out.println("½øÈë¶©µ¥£¡£¡£¡£¡");
		System.out.println(name);
		System.out.println(address);
		System.out.println(remark);
		return "orders";
	}

}
