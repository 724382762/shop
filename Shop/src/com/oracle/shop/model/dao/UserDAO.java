package com.oracle.shop.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.oracle.shop.model.javabean.Users;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;


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
	
	//ÅĞ¶Ï¼ÇÂ¼ÊÇ·ñ´æÔÚ
	@Select("select * from users where username=#{username}")
	public Users checkExit(@Param("username")String username);
	
	
	//×¢²á
	@Insert("insert into users(username,password,phone,image,findcode) values(#{username},#{password},#{phone},'images/timg.jpg',#{findcode})")
	public int Register(@Param("username")String username,@Param("password")String password,@Param("phone")String phone,@Param("findcode")int findcode);
	
	//ÅĞ¶ÏÕÒ»ØÂë
	@Select("select count(*) from users where username=#{username} and findcode=#{findcode}")
	public int checkCode(@Param("username")String username,@Param("findcode")int findcode);
	
	//ÖØÖÃÃÜÂë
	@Update("update users set password=#{password} where username=#{username}")
	public int resetPassword(@Param("password")String password,@Param("username")String username);
	
}
