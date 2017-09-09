package com.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Lucifer
 * 本类可通过 getConnection方法 获取MySQL数据库连接
 * 可通过 close方法关闭相关
 */
public  class GetMySQLConnection implements GetConnectionInterface {

	public Connection connection = null;
	public PreparedStatement perparedStatement = null;
	public ResultSet resultSet = null;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			connection = DriverManager.getConnection("jdbc:mysql://"+GetConnection.databaseparameters.getUrl());
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
