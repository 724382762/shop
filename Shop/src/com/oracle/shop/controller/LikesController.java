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
		//判断用户是否登录
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
			
			//如果在购物车界面进行加入收藏夹，跳转回到购物车界面
			if(name.equals("like")){
				request.getRequestDispatcher("/car/list").forward(request, response);
			}
			//否则就是在主页，跳转回主页
			else{
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		}	
	}
	
	@RequestMapping("/delete")
	public String deleteProductFormLike(int pid,HttpSession session){
		//1.获取用户在网页上要删除的商品id
		//2.调用dao方法将这个id的商品从收藏表中删除
		//从session中获取登录的用户编号
		int userid=((Users)session.getAttribute("logineduser")).getUserid();
		
		int result=dao.deleteGoodsFromLikes(userid, pid);
		System.out.println(result>0?"删除成功":"删除失败");
		return "redirect:list";
	}


}
