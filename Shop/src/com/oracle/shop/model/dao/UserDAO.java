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
	
	@Select("select * from users where username=#{username} and password=#{password}")
	public Users login(@Param("username")String username,@Param("password")String password);
	
	@Insert("insert into users(username,password,sex,age,phone) values(#{username},#{password})")
	public int register(@Param("username")String username,@Param("password")String password,@Param("sex")String sex,@Param("age")String age,@Param("phone")String phone);
}
