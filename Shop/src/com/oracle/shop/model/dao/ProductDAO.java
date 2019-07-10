package com.oracle.shop.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.oracle.shop.model.javabean.Goods;


@Mapper
public interface ProductDAO {

	@Select("select *  from goods")
	public List<Goods> listGoods();
	
	@Select("select *  from goods limit #{startindex},#{count}")
	public List<Goods> listGoodsByPage(@Param("startindex")int startIndex,@Param("count")int count);
	
	@Select("select *  from goods where sale='yes' limit #{startindex},#{count}")
	public List<Goods> listSaleGoodsByPage(@Param("startindex")int startIndex,@Param("count")int count);
	
	@Select("select count(*) from goods")
	public int getAllCountOfGoods();
	
	@Select("select count(*) from goods where sale='yes'")
	public int getAllCountOfSaleGoods();
}
