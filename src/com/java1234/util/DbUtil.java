package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/db_book";
	private String dbUserName="root";
	private String dbPassword="123456";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * 数据库获取
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	/**
	 * 数据库关闭方法
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();		
			try {
				dbUtil.getCon();
				System.out.println("数据库连接成功");
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				System.out.println("数据库连接失败");
			}
			

	}

}
