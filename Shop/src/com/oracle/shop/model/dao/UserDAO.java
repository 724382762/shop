package com.oracle.shop.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.oracle.shop.model.javabean.Users;


/**
 * 
 * @author Administrator
 *
 */

@Mapper
public interface UserDAO {
	
	//µÇÂ¼
	@Select("select * from users where username=#{username} and password=#{password}")
	public Users login(@Param("username")String username,@Param("password")String password);
	
	//ÅÐ¶Ï¼ÇÂ¼ÊÇ·ñ´æÔÚ
	@Select("select * from users where username=#{username}")
	public Users checkExit(@Param("username")String username);
	
	
	//×¢²á
	@Insert("insert into users(username,password,phone) values(#{username},#{password},#{phone})")
	public int Register(@Param("username")String username,@Param("password")String password,@Param("phone")String phone);
}
