package com.oracle.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.shop.model.dao.UserDAO;
import com.oracle.shop.model.javabean.Users;

@Controller
@RequestMapping("/user")
public class UserControl {
	
	
	@Autowired
	private UserDAO dao;

	@RequestMapping("/login")
	/**
	 * 
	 * @param username	��ǰ�˵��ύ��input��ǩ��name����һ��
	 * @param password	��ǰ�˵��ύ��input��ǩ��name����һ��
	 * @return
	 */
	public String login(String username,String password,HttpSession session) {
		
		//1.��ȡ�û��ڱ��ϵ��˻�������
		
		//2.��Ѷ���ݿ��Ƿ���������Ӧ���˻�������
		Users u = dao.login(username, password);
		//3.�ж��û��Ƿ���ڣ�������ת����ҳ�����򱣳��ڵ�¼����
		if(u == null){
			return "login";
		}else{
			session.setAttribute("logineduser", u);
			return "index";
		}
		
	}

	@RequestMapping("/register")
	public String register() {
		System.out.println("user -register");
		return "index";
	}
}
