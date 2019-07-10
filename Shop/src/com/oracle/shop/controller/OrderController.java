package com.oracle.shop.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.shop.model.dao.OrderDAO;
import com.oracle.shop.model.javabean.Goods;
import com.oracle.shop.model.javabean.OrderDetail;
import com.oracle.shop.model.javabean.Orders;
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
		return "redirect:detail";
	}
	
	
	@RequestMapping("/detail")
	public String listDetailOfOrder(HttpSession session,Model m){
		if(session.getAttribute("logineduser")==null){
			//如果未登陆，跳转到登录页面
			return "login";
		}else{
			//如果登陆了，则查询数据库将订单详情查询好封装到一个map集合中
			Map<Orders, Map<Goods, String>> orderDtails= new HashMap();
			
			 List<Orders>  orders=dao.listOrders(((Users)session.getAttribute("logineduser")).getUserid());
			 
			for(Orders  o:orders){
				List<OrderDetail> items=dao.listItemsByOrderId(o.getOrderid());
				Map<Goods, String> itemDetails=new HashMap();
				for(OrderDetail  i:items){
					Goods g=dao.getGoodsByGoodsid(i.getGoodsid());
					itemDetails.put(g, i.getOrderid());
				}
				orderDtails.put(o, itemDetails);
			}
			m.addAttribute("orderDetail", orderDtails);
			return "test";
		}
	}
	
	
	@RequestMapping("/delete")
	public String deleteOrder(String orderid){
		
		System.out.println(orderid);
		dao.deleteOrderByOrderidFromOrderdetail(orderid);
		dao.deleteOrderByOrderidFromOrder(orderid);
		
		return "redirect:detail";
	}
	
}
