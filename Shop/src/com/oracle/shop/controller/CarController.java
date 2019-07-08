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
			return "cart";
		}
		return "login";
	}
}
