package com.neitui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.WeakHashMap;

public class Admin {
	public Space A = new Space("A");
	public Space B = new Space("B");
	public Space C = new Space("C");
	public Space D = new Space("D");
	
	private static Admin single = null;
	//用Map接口作为HashMap的引用
	private Map<User,Space> work = new HashMap();
	private Map<User,Space> weakwork = new WeakHashMap();
	
	//对于用户的管理员采用单例模式
	private Admin(){}
	public Admin getInstance()
	{
		if(single == null)
			single = new Admin();
		return single;
	}
	public boolean putUser(User aUser)
	{
		if(this.conflict(aUser)){
		work.put(aUser, aUser.getSpace());
		return true;
		}
		return false;
	}
	//用弱映射，帮助虚拟机快速删除
	public void deleteUser(User aUser)
	{
		work.remove(aUser);
		weakwork.put(aUser, aUser.getSpace());
	}
	//运用视图技术，从键中判断是否四种情况发生
	public boolean conflict(User aUser)
	{
		 Set<User> users = work.keySet();
		 for(User userTemp : users){
			 if(userTemp.getSpace().equals(aUser.getSpace()))
					 {
				 		if(userTemp.getaOrderTime().equals(aUser.getaOrderTime())){
				 			if(aUser.getBegin() < userTemp.getBegin()&& aUser.getEnd()<userTemp.getEnd())
				 				return false;
				 			if(userTemp.getBegin() < aUser.getBegin() && userTemp.getEnd() < aUser.getEnd())
				 				return false;
				 			if(userTemp.getBegin() < aUser.getBegin() && userTemp.getEnd()>aUser.getEnd())
				 				return false;
				 			if(aUser.getBegin() < userTemp.getBegin() && userTemp.getEnd() < aUser.getEnd())
				 				return false;
				 		}
					 }
		 }
		 return true;
	}
	public void userMoney(Space aSpace){
		SortedSet<User> sortA = new TreeSet<>();
		System.out.println("场地"+aSpace.getName());
		for(Map.Entry<User, Space>entry : work.entrySet()){
			User userNow = entry.getKey();
			Space spaceNow = entry.getValue();
			if(userNow.getSpace().equals(aSpace)){
				//调用计算方法，并且调用增加相应场馆money的方法
				int temp = Calculation.cal(userNow);
				userNow.setCost(temp);
				sortA.add(userNow);
				spaceNow.setAllMoney(temp);
			}
		}
		for(User a : sortA){
			System.out.println(a.getOrderTime()+" "+a.getTime()+" "+a.getCost());
		}
		System.out.println("小计" + aSpace.getName() +" "+aSpace.getAllMoney());
	}
	public static void main(String[] args) {
		Admin admin = new Admin();
		User aUser = new User(1,"2012-06-01",admin.A,false,"9:00~10:00");
		aUser.setaOrderTime();
		admin.putUser(aUser);
		admin.userMoney(admin.A);
	}
}
