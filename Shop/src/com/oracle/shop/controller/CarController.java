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
		
		//�ж��û��Ƿ��¼
		if (session.getAttribute("logineduser") != null) {
			//1.���Ҫ��ӵ����ﳵ����Ʒ����Ϣ
			int userid = ((Users)session.getAttribute("logineduser")).getUserid();
		}
		
		return "car";
	}
}
