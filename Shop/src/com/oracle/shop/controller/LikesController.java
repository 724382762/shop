package com.oracle.shop.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.shop.model.dao.LikeDAO;
import com.oracle.shop.model.javabean.Goods;
import com.oracle.shop.model.javabean.Likes;
import com.oracle.shop.model.javabean.Users;



@Controller
@RequestMapping("/likes")
public class LikesController {
	
	@Autowired
	private LikeDAO dao;
	
	@RequestMapping("/list")
	public String listLikes(HttpSession session,Model m){
		//�ж��û��Ƿ��¼
		if (session.getAttribute("logineduser") == null) {
			return "login";
		}else{
			int userid=((Users)session.getAttribute("logineduser")).getUserid();
			List<Goods> goods = dao.listGoodsByUserid(userid);
			m.addAttribute("goodinfo", goods);
			return "likes";
		}
	}
	
	@RequestMapping("/add")
	public void addLike(String name,HttpSession session,int goodsid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		if (session.getAttribute("logineduser") == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			dao.addProduct(new Date().toLocaleString(), "1", ((Users)session.getAttribute("logineduser")).getUserid(), goodsid);
			
			//����ڹ��ﳵ������м����ղؼУ���ת�ص����ﳵ����
			if(name.equals("like")){
				request.getRequestDispatcher("/car/list").forward(request, response);
			}
			//�����������ҳ����ת����ҳ
			else{
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		}	
	}
	
	@RequestMapping("/delete")
	public String deleteProductFormLike(int pid,HttpSession session){
		//1.��ȡ�û�����ҳ��Ҫɾ������Ʒid
		//2.����dao���������id����Ʒ���ղر���ɾ��
		//��session�л�ȡ��¼���û����
		int userid=((Users)session.getAttribute("logineduser")).getUserid();
		
		int result=dao.deleteGoodsFromLikes(userid, pid);
		System.out.println(result>0?"ɾ���ɹ�":"ɾ��ʧ��");
		return "redirect:list";
	}


}
