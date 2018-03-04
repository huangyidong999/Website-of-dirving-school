package com.bean;

public class User {
	private String userId;
	private String userName;
	private String email;
	private String profession;
	private String address;
	private String tel;
	private String remark;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUserId() {
		return userId;
	}
	public User(){
		
	}
	public User( String userName, String email,
			String profession, String address, String tel, String remark) {
		super();
		this.userName = userName;
		this.email = email;
		this.profession = profession;
		this.address = address;
		this.tel = tel;
		this.remark = remark;
	}
	

}
