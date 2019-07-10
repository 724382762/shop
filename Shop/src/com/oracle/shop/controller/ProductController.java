package com.oracle.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.shop.model.dao.ProductDAO;
import com.oracle.shop.model.javabean.Goods;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	
	@RequestMapping("/list")
	public String listProduct(Model  m,int page){
		
		int count=12;//后台规定的每页分的条数
		List<Goods> gs = dao.listGoodsByPage((page-1)*count,count);
		m.addAttribute("gs", gs);
		
		
		int allCount=dao.getAllCountOfGoods();//查询数据库获取总行数
		int allPage=allCount%count==0?allCount/count:allCount/count+1;//总页数
		int perviousPage=page-1==0?1:page-1;  //上一页
		int nextPage=page==allPage?allPage:page+1; //下一页
		m.addAttribute("perviousPage", perviousPage);
		m.addAttribute("nextPage", nextPage);
		m.addAttribute("allPage", allPage);
		m.addAttribute("nowPage", page);
		m.addAttribute("allCount", allCount);
		m.addAttribute("count", count);
		
		return "index";
	}
	
	
	@RequestMapping("/sale")
	public String listSaleProduct(Model  m,int page){
			
			int count=12;//后台规定的每页分的条数
			List<Goods> gs = dao.listSaleGoodsByPage((page-1)*count,count);
			m.addAttribute("gs", gs);
			
			
			int allCount=dao.getAllCountOfSaleGoods();//查询数据库获取总行数
			int allPage=allCount%count==0?allCount/count:allCount/count+1;//总页数
			int perviousPage=page-1==0?1:page-1;  //上一页
			int nextPage=page==allPage?allPage:page+1; //下一页
			m.addAttribute("perviousPage", perviousPage);
			m.addAttribute("nextPage", nextPage);
			m.addAttribute("allPage", allPage);
			m.addAttribute("nowPage", page);
			m.addAttribute("allCount", allCount);
			m.addAttribute("count", count);
			
			return "saleindex";
		}
	
	
	@RequestMapping("/jump")
	public String listProductByPageNumber(int pagenumber,Model m){
		
		int count=12;//后台规定的每页分的条数
		
		
		
		int allCount=dao.getAllCountOfGoods();//查询数据库获取总行数
		int allPage=allCount%count==0?allCount/count:allCount/count+1;//总页数
		if (pagenumber >=allPage) {
			pagenumber = allPage;
			List<Goods> gs = dao.listGoodsByPage((allPage-1)*count,count);
			m.addAttribute("gs", gs);
		}else if(pagenumber <= 0){
			pagenumber = 1;
			List<Goods> gs = dao.listGoodsByPage(0,count);
			m.addAttribute("gs", gs);
		}
		System.out.println("pagenumber:" + pagenumber);
		List<Goods> gs = dao.listGoodsByPage((pagenumber-1)*count,count);
		m.addAttribute("gs", gs);
		int perviousPage=pagenumber-1==0?1:pagenumber-1;  //上一页
		int nextPage=pagenumber==allPage?allPage:pagenumber+1; //下一页
		m.addAttribute("perviousPage", perviousPage);
		m.addAttribute("nextPage", nextPage);
		m.addAttribute("allPage", allPage);
		m.addAttribute("nowPage", pagenumber);
		m.addAttribute("allCount", allCount);
		m.addAttribute("count", count);
		return "index";
	}
	
	
	@RequestMapping("/jumpsale")
	public String listSaleProductByPageNumber(int pagenumber,Model m){
		
		int count=12;//后台规定的每页分的条数
		
		
		
		int allCount=dao.getAllCountOfGoods();//查询数据库获取总行数
		int allPage=allCount%count==0?allCount/count:allCount/count+1;//总页数
		if (pagenumber >=allPage) {
			pagenumber = allPage;
			List<Goods> gs = dao.listSaleGoodsByPage((allPage-1)*count,count);
			m.addAttribute("gs", gs);
		}else if(pagenumber <= 0){
			pagenumber = 1;
			List<Goods> gs = dao.listSaleGoodsByPage(0,count);
			m.addAttribute("gs", gs);
		}
		System.out.println("pagenumber:" + pagenumber);
		List<Goods> gs = dao.listSaleGoodsByPage((pagenumber-1)*count,count);
		m.addAttribute("gs", gs);
		int perviousPage=pagenumber-1==0?1:pagenumber-1;  //上一页
		int nextPage=pagenumber==allPage?allPage:pagenumber+1; //下一页
		m.addAttribute("perviousPage", perviousPage);
		m.addAttribute("nextPage", nextPage);
		m.addAttribute("allPage", allPage);
		m.addAttribute("nowPage", pagenumber);
		m.addAttribute("allCount", allCount);
		m.addAttribute("count", count);
		return "index";
	}
	
	

}
