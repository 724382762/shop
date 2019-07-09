package com.oracle.shop.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.oracle.shop.model.javabean.Goods;
import com.oracle.shop.model.javabean.OrderDetail;
import com.oracle.shop.model.javabean.Orders;



@Mapper
public interface OrderDAO {
	
	//插入数据到订单表
	@Insert("insert into orders(orderid,time,status,address,note,userid,name) values(#{orderid},#{time},#{status},#{address},#{note},#{userid},#{name})")
	public int  addOrder(@Param("orderid")String orderid,@Param("time")String time,@Param("status")String status,@Param("address")String address,@Param("note")String note,@Param("userid")int userid,@Param("name")String name);
	
	//插入数据到订单详情表
	@Insert("insert into order_detail(goodsid,orderid,number) values(#{goodsid},#{orderid},#{number})")
	public int addProduct(@Param("goodsid")int goodsid,@Param("orderid")String orderid,@Param("number")int number);
	
	@Select("select * from  orders where userid=#{0}")
	public List<Orders> listOrders(int userid);
	
	@Select("select *  from order_detail where orderid=#{0}")
	public List<OrderDetail>  listItemsByOrderId(String orderid);
	
	@Select("select * from goods where goodsid=#{0}")
	public Goods getGoodsByGoodsid(int goodsid);

}
