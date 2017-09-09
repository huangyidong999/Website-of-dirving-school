package com.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author Lucifer
 * 本类可通过 getConnection方法 获取SQLServer数据库连接
 * 可通过 close方法关闭相关
 */
public class GetSQLServerConnection implements GetConnectionInterface{
	public static  Connection connection = null;
	public static  PreparedStatement perparedStatement = null;
	public static  ResultSet resultSet = null;
	 GetSQLServerConnection() {
		
	}
	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			connection = DriverManager.getConnection("jdbc:sqlserver://"+GetConnection.databaseparameters.getUrl());
			return connection;
		} catch (Exception e) {
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
