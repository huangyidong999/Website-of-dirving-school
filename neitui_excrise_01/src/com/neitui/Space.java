package com.neitui;

public class Space {
	private int allMoney;
	private String name;
	
	public Space(String name) {
		super();
		this.allMoney = 0;
		this.name = name;
	}
	public int getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(int allMoney) {
		this.allMoney = this.allMoney + allMoney;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
