package com.toolkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBtoolkit {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1:3306/test_db";
	private static String user="root";
	private static String password="123456";
	private static Connection con = null;
	private static PreparedStatement ps  = null;
	private static ResultSet rs = null;
	
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static void closeAll(ResultSet rs,PreparedStatement ps,Connection con){
		
		try {
			if(rs!=null){
			rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
}

}
