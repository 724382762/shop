package com.oracle.shop.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface OrderDAO {
	
	//�������ݵ�������
	@Insert("insert into orders(orderid,time,status,address,note,userid,name) values(#{orderid},#{time},#{status},#{address},#{note},#{userid},#{name})")
	public int  addOrder(@Param("orderid")String orderid,@Param("time")String time,@Param("status")String status,@Param("address")String address,@Param("note")String note,@Param("userid")int userid,@Param("name")String name);
	
	//�������ݵ����������
	@Insert("insert into order_detail(goodsid,orderid,number) values(#{goodsid},#{orderid},#{number})")
	public int addProduct(@Param("goodsid")int goodsid,@Param("orderid")String orderid,@Param("number")int number);

}
