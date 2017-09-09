package com.tool;

import java.sql.Connection;

import com.bean.DatabaseParameters;
/** 
 * @author Lucifer
 * @version 1.0
 * @time 2017.9.8
 * 通过本类可保证其getconnection方法只能调用一次
 */
public class GetConnection {  
	private GetConnection(){
	}
	
	private static boolean valid = true;
	public static DatabaseParameters databaseparameters =  new DatabaseParameters();
	/**
	 * 
	 * @param par
	 * @return
	 * 获得数据集库连接
	 */
	public static Connection getconnection(GetConnectionInterface par){ 
		if(valid){
			valid = false;
			return par.getConnection();
		}
		return null;
	}
}
