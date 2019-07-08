package com.oracle.shop.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


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
	
}
