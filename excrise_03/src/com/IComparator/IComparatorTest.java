package com.IComparator;

import java.util.Arrays;

public class IComparatorTest {
	public static void main(String[] args) {
		String[] friends = {"Peter", "Paul", "Mary"};
		// 注意这里，使用Comparator接口的时候，在完成具体比较的时候，要建立一个实例！
		// 类似这样
		// Comparator<String>comp = new LengthCompartor();
		// if(comp.compare(words[i], words[j]) > 0) ... ... 
		Arrays.sort(friends, new LengthCompartor());
		
		System.out.println(friends[0] +"  " +friends[1]+"  " + friends[2]);
	}
}
