package com.java1234.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.User;

public class UserDao {
	
	/**
	 * µÇÂ¼ÑéÖ¤
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{
		User resultUser=null;
		String sql="select * from t_user where userName=? and password=?";
		
		PreparedStatement pstm=con.prepareStatement(sql);		
		pstm.setString(1, user.getUserName());
		pstm.setString(2, user.getPassword());
		
		ResultSet rSet=pstm.executeQuery();
		if(rSet.next()){
			resultUser=new User();
			resultUser.setId(rSet.getInt("id"));
			resultUser.setUserName(rSet.getString("userName"));
			resultUser.setPassword(rSet.getString("password"));
		}
		return resultUser;
	}

}
