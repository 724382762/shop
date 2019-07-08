package com.oracle.shop.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface CarDAO {

	
	//���һ���¼�¼
	@Insert("insert into cart(quantity,userid,goodsid) values(1,#{user},#{goodsid})")
	public int addProduct(@Param("user")int userid,@Param("goodsid")int goodsid); 
	
	//������Ʒ����
	@Update("update cart set quantity=quantity+1 where userid=#{user} and goodsid=#{goodsid}")
	public int updateProduct(@Param("user")int userid,@Param("goodsid")int goodsid);
	
	//�жϼ�¼�Ƿ����
	@Select("select count(*) from cart where userid=#{user} and goodsid=#{goodsid} limit 1")
	public int checkExit(@Param("user")int userid,@Param("goodsid")int goodsid);
	
}
