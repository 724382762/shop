package com.oracle.shop.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CarDAO {

	@Insert("insert into cart(quantity,userid,goodsid) values(1,{user})")
	public int addProduct(int userid,int goodid); 
	
}
