package com.neitui;

import java.time.LocalDate;

public class User implements Comparable<User>{
	private int userId;
	private String orderTime;
	private Space space;
	private boolean clear;
	private LocalDate aOrderTime;
	private int begin;
	private int end;
	private String time;
	private int cost;
	public User(int userId, String orderTime, Space space, boolean clear, String time) {
		this.userId = userId;
		this.orderTime = orderTime;
		this.space = space;
		this.clear = clear;
		this.time = time;
		String a[] = time.split("~");
		String b[] = a[0].split(":00");
		String c[] = a[1].split(":00");
		this.begin = Integer.parseInt(b[0]);
		this.end = Integer.parseInt(c[0]);
	}

	
	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public User(String time) {
		super();
		this.time = time;
	}
	
	public int getBegin() {
		return begin;
	}
	
	public void setBegin(int begin) {
		this.begin = begin;
	}
	
	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}

	public LocalDate getaOrderTime() {
		return aOrderTime;
	}
	public void setaOrderTime(){
		aOrderTime = LocalDate.parse(this.orderTime);
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Space getSpace() {
		return space;
	}
	public void setSpace(Space space) {
		this.space = space;
	}
	public boolean isClear() {
		return clear;
	}
	public void setClear(boolean clear) {
		this.clear = clear;
	}
	
	//HashMap重写HashCode方法
	public int hashcode(){
		return new Integer(this.userId).hashCode();
	}
	//HashMap重写equals方法
	public boolean equals(Object aUser){
		if(this == aUser) return true; //如果本身即一个地址
		if(aUser == null) return false; //如果aUser为空
		if(this.getClass() != aUser.getClass()) return false;//比较this和aUser是否是同一个类！
		if(!(aUser instanceof User)) return false; //当前对象是否是User的实例
		//从这里开始比较User的实例域
		User other = (User)aUser;
		Integer idA = this.userId;
		Integer idB = other.userId;
		if(idA.equals(idB))return true;
		return false;
	}
	//重写comparable接口的compareTo方法
	public int compareTo(User other)
	{
		return Integer.compare(this.getUserId(),other.getUserId());
	}


	
}
