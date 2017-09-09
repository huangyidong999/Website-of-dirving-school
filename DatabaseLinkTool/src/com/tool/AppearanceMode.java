package com.tool;

import java.sql.Connection;

import com.bean.DatabaseParameters;

public class AppearanceMode {
	/**
	 * 本类采用单例模式
	 * 本类可通过 实例化调用不同方法输入参数直接返回Connection
	 */
	private AppearanceMode(){
	}
	private static Connection connection = null;
	private static DatabaseParameters user = null;
	public static Connection MySQLinit(String username,String password,String drviertype,String url){
		if(connection == null){
			user = new DatabaseParameters(username,password,drviertype,url);
			connection = GetConnection.getconnection((GetConnectionInterface)new GetMySQLConnection());
		}
		return connection;
	}
	public static Connection Oracleinit(String username,String password,String drviertype,String url){
		user = new DatabaseParameters(username,password,drviertype,url);
		connection = GetConnection.getconnection((GetConnectionInterface)new GetOracleConnection());
		return connection;
	}
	public static Connection SQLServerinit(String username,String password,String drviertype,String url){
		user = new DatabaseParameters(username,password,drviertype,url);
		connection = GetConnection.getconnection((GetConnectionInterface)new GetSQLServerConnection());
		return connection;
	}
}
