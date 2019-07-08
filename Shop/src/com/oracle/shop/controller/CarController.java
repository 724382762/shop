package com.oracle.shop.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.shop.model.dao.CarDAO;
import com.oracle.shop.model.dao.UserDAO;
import com.oracle.shop.model.javabean.Users;


@Controller
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarDAO dao;

	@RequestMapping("/add")
	public String addProduct(int pid,HttpSession session){
		
		//判断用户是否登录
		if (session.getAttribute("logineduser") != null) {
			//1.获得要添加到购物车的商品的信息
			//获取用户id
			int userid = ((Users)session.getAttribute("logineduser")).getUserid();
			
			//判断记录是否存在
			int exit = dao.checkExit(userid, pid);
			if(exit == 0){
				//记录不存在，添加一条新纪录
				int result = dao.addProduct(userid, pid);
			}else{
				//记录已存在，商品数量+1
				dao.updateProduct(userid, pid);
			}
			return "cart";
		}
		return "login";
	}
}
