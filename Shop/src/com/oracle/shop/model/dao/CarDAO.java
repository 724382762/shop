package com.oracle.shop.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.oracle.shop.model.javabean.Cart;
import com.oracle.shop.model.javabean.Goods;
import com.sun.org.apache.bcel.internal.generic.RETURN;


@Mapper
public interface CarDAO {

	
	//添加一条新纪录
	@Insert("insert into cart(quantity,userid,goodsid) values(1,#{user},#{goodsid})")
	public int addProduct(@Param("user")int userid,@Param("goodsid")int goodsid); 
	
	//增加商品数量
	@Update("update cart set quantity=quantity+1 where userid=#{user} and goodsid=#{goodsid}")
	public int updateProduct(@Param("user")int userid,@Param("goodsid")int goodsid);
	
	//判断记录是否存在
	@Select("select count(*) from cart where userid=#{user} and goodsid=#{goodsid} limit 1")
	public int checkExit(@Param("user")int userid,@Param("goodsid")int goodsid);
	
	//根据用户id查用户购物车
	@Select("select * from cart where userid=#{user}")
	public List<Cart> listProductCar(@Param("user")int userid);
	
	//根据goodsid查询商品详细信息
	@Select("select * from goods where goodsid=#{goodsid}")
	public Goods getGoodsByGoodsId(int goodsid);
	
	//删除商品
	@Delete("delete from cart where goodsid=#{goodsid} and userid=#{userid}")
	public int deleteProductByGoodsid(@Param("goodsid")int goodsid,@Param("userid")int userid);
	
}

