package com.oracle.shop.controller;

import java.util.Date;
import java.util.UUID;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.shop.model.dao.OrderDAO;
import com.oracle.shop.model.javabean.Users;
import com.sun.org.apache.bcel.internal.generic.NEW;


@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderDAO dao;
	@RequestMapping("/add")
	public String addOrder(int[] pid,int[] count,String name,String address,String remark,HttpSession session){
		
		System.out.println("进入订单！！！！");
		UUID uuid = UUID.randomUUID();
		//new Date().toLocaleString()
		int result = dao.addOrder(uuid.toString(),new Date().toLocaleString(), "已付款", address, remark, ((Users)session.getAttribute("logineduser")).getUserid(), name);
		
		for(int i = 0 ; i < pid.length;i++){
			int result2 = dao.addProduct(pid[i], uuid.toString(), count[i]);
		}
		return "orders";
	}
	
	
	@RequestMapping("/detail")
	public String listDetailOfOrder(){
		
		
		return "orders";
	}
}
