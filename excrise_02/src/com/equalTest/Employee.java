package com.equalTest;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee(String name, double salary, int year, int month, int day){
		this.name = name;
		this.salary = salary;
		hireDay = LocalDate.of(year, month, day);
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	/**
	 * 完美地重写equals方法！
	 */
	public boolean equals(Object otherObject){
		// 快速判断这个object是否和this一样地址
		if(this == otherObject )return true;
		
		// 如果显式的object是空，必须返回false
		if(otherObject == null)return false;
		
		// 应用反射，如果类名不匹配，他们不会相等
		if(this.getClass() != otherObject.getClass())return false;
		
		// 现在我们知道他不是一个空的Employee
		Employee other = (Employee) otherObject;
		
		//测试他们的域是为否一样的值
		return Objects.equals(name, other.name) && salary == other.salary
				&& Objects.equals(hireDay,other.hireDay);
	}
	
	/**
	 * 如果重写了equals就要重写hashcode，这是为了散列表（hashmap）
	 * Object 的 hash 方法可以用任意个参数，它将返回合适的hash值。
	 */
	public int hashCode(){
		return Objects.hash(name,salary,hireDay);
	}
	/**
	 * 自己写一个toString方法
	 */
	public String toString(){
		return getClass().getName() + "[name = " + name +",salaty=" + salary +",hireday"
				+hireDay + "]";
	}
}
