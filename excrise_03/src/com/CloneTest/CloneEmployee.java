package com.CloneTest;

import java.util.Date;
import java.util.GregorianCalendar;

public class CloneEmployee implements Cloneable{
	private String name;
	private double salary;
	private Date hireDay;
	
	public CloneEmployee(String name, double salary){
		this.name = name;
		this.salary = salary;
		hireDay = new Date();
	}
	/**
	 * 不管深浅克隆都要实现Cloneable 接口 ，重写clone方法
	 */
	public CloneEmployee clone() throws CloneNotSupportedException
	{
		// 调用Object的clone()方法
		CloneEmployee cloned = (CloneEmployee)super.clone();
		
		// 如果没有将那些可变的实力域进行克隆，那他就是浅克隆 。 clone可变的 域
		cloned.hireDay = (Date) hireDay.clone();
		
		return cloned;
	}
	
	public void serHireDay(int year, int month, int day){
		Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
		hireDay.setTime(newHireDay.getTime());
	}
	
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	public String toString(){
		return "Employee[name = " + name + ",salary = " + salary + ",hireDay = " + 
	 hireDay;
	}
}
