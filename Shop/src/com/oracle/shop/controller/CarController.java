package com.oracle.shop.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.shop.model.dao.CarDAO;
import com.oracle.shop.model.dao.UserDAO;
import com.oracle.shop.model.javabean.Cart;
import com.oracle.shop.model.javabean.Goods;
import com.oracle.shop.model.javabean.Users;


@Controller
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarDAO dao;

	@RequestMapping("/add")
	public String addProduct(int pid,HttpSession session){
		
		//�ж��û��Ƿ��¼
		if (session.getAttribute("logineduser") != null) {
			//1.���Ҫ��ӵ����ﳵ����Ʒ����Ϣ
			//��ȡ�û�id
			int userid = ((Users)session.getAttribute("logineduser")).getUserid();
			
			//�жϼ�¼�Ƿ����
			int exit = dao.checkExit(userid, pid);
			if(exit == 0){
				//��¼�����ڣ����һ���¼�¼
				int result = dao.addProduct(userid, pid);
			}else{
				//��¼�Ѵ��ڣ���Ʒ����+1
				dao.updateProduct(userid, pid);
			}
			return "index";
		}
		return "login";
	}
	@RequestMapping("/list")
	public String listProductCars(HttpSession session,Model m){
		if(session.getAttribute("logineduser")==null){
			return "index";
		}
		
		Map<Goods, Integer> detailCars = new HashMap();
		
		//��session�л���û�id
		int userid=((Users)session.getAttribute("logineduser")).getUserid();
		
		List<Cart> carts = dao.listProductCar(userid);
		
		for(Cart cart : carts){
			detailCars.put(dao.getGoodsByGoodsId(cart.getGoodsid()), cart.getQuantity());
		}
		m.addAttribute("detail", detailCars);
		return "cart";
		
	}
	
	
	@RequestMapping("/delete")
	public String deleteProduct(int pid,HttpSession session){
		
		//��session�л���û�id
		int userid=((Users)session.getAttribute("logineduser")).getUserid();
		dao.deleteProductByGoodsid(pid, userid);
		return "redirect:list";
	}
	
	
}
