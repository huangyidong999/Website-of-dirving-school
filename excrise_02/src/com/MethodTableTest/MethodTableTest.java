package com.MethodTableTest;
import java.lang.reflect.*;

/**
 * 这个是显示，如何通过反射来完成对任意一个类的方法调用
 * @author Lucifer
 *
 */
public class MethodTableTest {
	public static double square(double x){
		return x*x;
	}
	
	public static void printTable(double from, double to, int n, Method f){
		System.out.println(f);
		double dx = (to -from) / (n - 1);
		
		for(double x = from; x <= to; x += dx){
			try{
				// 这里真正运用了反射来调用方法f在下方是已经获得方法名的，由于是静态方法所以第一个参数可以
				// 为null，否则必须填写，第二个参数为实际参数列表
				double y = (Double) f.invoke(null, x);
				System.out.printf("%10.4f", x, y);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		try{
			// getMethod第一个参数是需要调用的方法名，第二个参数是那个方法需要的参数(注意！这里只是类型！)
			Method square = MethodTableTest.class.getMethod("square", double.class);
			Method sqrt = Math.class.getMethod("sqrt", double.class);
			printTable(1,10,10,square);
			printTable(1,10,10,sqrt);
		}catch(Exception e){
			
		}
		
	}
}
