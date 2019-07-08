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
		
		//2.�ж����ݿ��Ƿ���������Ӧ���˻�������
		Users u = dao.login(username, password);
		//3.�ж��û��Ƿ���ڣ�������ת����ҳ�����򱣳��ڵ�¼����
		if(u == null){
			return "login";
		}else{
			session.setAttribute("logineduser", u);
			return "index";
		}
		
	}
	
	
	//ע��
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		if (session.getAttribute("logineduser") != null) {
			session.setAttribute("logineduser", null);
		}
		return "index";
	}
	

	//ע��
	@RequestMapping("/register")
	public String register(String username,String password,String phone,HttpSession session) {
		
		
		Users u = dao.checkExit(username);
		if(u == null){
			dao.Register(username, password, phone);
			u = dao.login(username, password);
			session.setAttribute("logineduser", u);
			return "index";
		}
		return "register";
		
	}
}
