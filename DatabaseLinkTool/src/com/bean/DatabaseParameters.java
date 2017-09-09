package com.bean;
/**
 * 
 * @author Lucifer
 * 本类可通过实例化存储数据库相关参数 
 * @param userName 用户名
 * @param password 数据库密码
 * @param drivertype 数据库类型
 * @param url 数据库地址
 */
public class DatabaseParameters {
	@Override
	public String toString() {
		return "DatabaseParameters [userName=" + userName + ", passWord="
				+ passWord + ", drviertype=" + drviertype + ", url=" + url + "]";
	}
	//缺少关于命名规则的判断
	private String userName;
	private String passWord;
	private String drviertype;
	private String url;
	public DatabaseParameters(){
		
	}
	public DatabaseParameters(String username,String password,String drviertype,String url){
		this.userName = username; this.passWord = password; this.drviertype = drviertype;
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getDrvierType() {
		return drviertype;
	}
	public void setDrvierType(String drvier) {
		this.drviertype = drvier;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
