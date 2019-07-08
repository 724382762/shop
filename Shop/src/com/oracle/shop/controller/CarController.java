package com.oracle.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.shop.model.javabean.Users;


@Controller
@RequestMapping("/car")
public class CarController {

	@RequestMapping("/add")
	public String addProduct(int pid,HttpSession session){
		
		//判断用户是否登录
		if (session.getAttribute("logineduser") != null) {
			//1.获得要添加到购物车的商品的信息
			int userid = ((Users)session.getAttribute("logineduser")).getUserid();
		}
		
		return "car";
	}
}
