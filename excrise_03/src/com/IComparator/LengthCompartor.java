package com.IComparator;

import java.util.Comparator;

public class LengthCompartor implements Comparator<String>{
	public int compare(String first, String second){
		return first.length() - second.length();
	}
}
