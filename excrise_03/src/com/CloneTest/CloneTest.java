package com.CloneTest;

public class CloneTest {
	public static void main(String[] args)  {
		CloneEmployee original = new CloneEmployee("John",50000);
		original.serHireDay(2000, 6, 6);
		CloneEmployee copy;
		try {
		copy = original.clone();
		copy.raiseSalary(10);
		copy.serHireDay(2017, 12, 13);
		System.out.println("original =" + original);
		System.out.println("copy = "+copy);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
