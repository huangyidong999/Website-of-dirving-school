package com.tool;

import java.sql.Connection;
/**
 * 
 * @author Lucifer
 * 本类对获取连接类的方法进行抽象
 *
 */
interface GetConnectionInterface {
	
	/**
	 * 获得数据库连接
	 * @return
	 */
	Connection getConnection();
	/**
	 * 关闭数据库连接相关参数
	 */
	void close();
}
