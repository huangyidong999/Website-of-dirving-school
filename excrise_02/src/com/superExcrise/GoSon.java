package com.superExcrise;

public class GoSon extends GOgogo{
	private String sonName;
	public GoSon(String name, int age, String sex,String sonName){
		super(name, age, sex);
		this.sonName = sonName;
	}
	public String getSonName() {
		return sonName;
	}
	public void setSonName(String sonName) {
		this.sonName = sonName;
	}
	public void Print(){
		System.out.println(super.getName() + this.getSonName() + this.getAge());
	}
	public static void main(String[] args){
		GoSon a = new GoSon("ÕÔè÷",22,"ÄÐ","Ð¡º¢×Ó");
		a.Print();
	}
}
