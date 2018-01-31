package com.CopyOfTest;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * 这个测试演示了如何正确的Copy一个数组，需要用到一些反射的知识来使用newInstance方法
 * @author Lucifer
 *
 */
public class CopyOfTest {
	/**
	 * 这个不用
	 * @return
	 */
	public static Object[] badCopyOf(Object[] a,int newLength){
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
		return newArray;
	}

	public static Object goodCopyOf(Object a,int newLength){
		Class cl = a.getClass();
		if(!cl.isArray()) return null;
		//得到数组的类型
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, length);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
	}
	
	public static void main(String[] args) {
		int[] a ={1,2,3};
		a = (int[])goodCopyOf(a,10);
		System.out.println(Arrays.toString(a));
		
		String[] b = {"Tom","Dick","Harry"};
		b = (String[])goodCopyOf(b,10);
		System.out.println(Arrays.toString(b));
		
		System.out.println("The following call will generate an exception.");
		b = (String[]) badCopyOf(b,10);
	}
}
