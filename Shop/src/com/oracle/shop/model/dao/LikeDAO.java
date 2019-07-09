package com.oracle.shop.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.oracle.shop.model.javabean.Goods;
import com.oracle.shop.model.javabean.Likes;

@Mapper
public interface LikeDAO {
	
	
	//添加一条新纪录
	@Insert("insert into likes(likestime,classname,userid,goodsid) values(#{likestime},#{classname},#{userid},#{goodsid})")
	public int addProduct(@Param("likestime")String likestime,@Param("classname")String classname,@Param("userid")int userid,@Param("goodsid")int goodsid); 
	
	
	@Select("select * from goods where goodsid in(select goodsid from likes where userid=#{userid})")
	public List<Goods> listGoodsByUserid(@Param("userid")int userid);

	@Delete("delete from likes where goodsid=#{productid} and userid=#{userid}")
	public int deleteGoodsFromLikes(@Param("userid")int userid,@Param("productid")int productid);
}

