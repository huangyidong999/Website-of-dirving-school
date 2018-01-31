package com.neitui;

import java.util.ArrayList;

import javax.xml.crypto.Data;

public class Calculation {
	public static int cal(User user){
		if(user.getaOrderTime().getDayOfWeek().equals("Saturday")||
			"Sunday".equals(user.getaOrderTime().getDayOfWeek())	){
			return timeMoney2(user.getBegin(),user.getEnd());
		}
		else{
			return timeMoney1(user.getBegin(),user.getEnd());
		}
	}
	//周一到周五的计算方法
	private static int timeMoney1(int x,int y)
	{
		if(x == y) return 0;
		if(9<=x && x<=12) return 30+timeMoney1(x+1,y);
		if(12<x && x<=18) return 50+timeMoney1(x+1,y);
		if(18<x && x<=20) return 80+timeMoney1(x+1,y);
		if(20<x && x<=22) return 60+timeMoney1(x+1,y);
		return 0;
	}
	//周六周日的计算方法
	private static int timeMoney2(int x,int y)
	{
		if(x == y) return 0;
		if(9<=x && x<=12) return 40+timeMoney1(x+1,y);
		if(12<x && x<=18) return 50+timeMoney1(x+1,y);
		if(18<x && x<=22) return 60+timeMoney1(x+1,y);
		return 0;
	}
}
