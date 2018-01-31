package com.LinkToDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 这个类主要是介绍如何连接到数据库 需要：： 驱动 数据库URL 用户名 密码
 * @author Lucifer
 *
 */
public class LinkToDatabase {
	public static void main(String[] args) {
		try {
			runTest();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void runTest() throws SQLException, IOException
	{
		Connection conn = getConnection(); 
		 Statement stat = conn.createStatement();
		 
		 stat.executeUpdate("CREATE TABLE Greetings(Message CHAR(20))");
		 stat.executeUpdate("INSERT INTO Greetings VALUES('hello world!')");
		 
		 ResultSet result = stat.executeQuery("SELECT * FROM Greetings");
		 	if(result.next()){
		 		System.out.println(result.getString(1));
		 	}
		 	stat.executeUpdate("DROP TABLE Greetings");
	}
	
	public static Connection getConnection() throws SQLException,IOException
	{
		// 设置选择数据库驱动的参数
		String drivers = "com.mysql.jdbc.Driver";
		// 设置数据库的URL 用户名 和 密码
		String url="jdbc:mysql://127.0.0.1:3306/test_db";
		String user="root";
		String password="123456";
		
		return DriverManager.getConnection(url, user, password);
	}
}
