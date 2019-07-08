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
	 * @param username	和前端的提交的input标签的name属性一致
	 * @param password	和前端的提交的input标签的name属性一致
	 * @return
	 */
	public String login(String username,String password,HttpSession session) {
		
		//1.获取用户在表单上的账户和密码
		
		//2.判断数据库是否存在这个对应的账户和密码
		Users u = dao.login(username, password);
		//3.判断用户是否存在，存在跳转到主页，否则保持在登录界面
		if(u == null){
			return "login";
		}else{
			session.setAttribute("logineduser", u);
			return "index";
		}
		
	}
	
	
	//注销
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		if (session.getAttribute("logineduser") != null) {
			session.setAttribute("logineduser", null);
		}
		return "index";
	}
	

	//注册
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
