package com.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author Lucifer
 * 本类可通过 getConnection方法 获取Oracle数据库连接
 * 可通过 close方法关闭相关
 */
public class GetOracleConnection implements GetConnectionInterface{

	public static  Connection connection = null;
	public static  PreparedStatement perparedStatement = null;
	public static  ResultSet resultSet = null;
	GetOracleConnection() {
		
	}
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:"+GetConnection.databaseparameters.getUrl());
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void close() {
		try {
			connection.close();
			perparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
