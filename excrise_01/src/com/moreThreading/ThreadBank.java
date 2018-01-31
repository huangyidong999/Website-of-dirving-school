package com.moreThreading;

public class ThreadBank {
	public static void main(String[] args) {
		System.out.println(get());
		
		/*Runnable r = new Runnable(){
			public void run(){
			for(int i = 0;i <= 50;i++)
				System.out.print(i+" ");
			}
		};
		Thread t = new Thread(r);
		Thread m = new Thread(r);
		t.start(); m.start();*/
	}
	
	public static int get() {
		int i = 0;
		try {
			i = i + 1;
		} catch (Exception ex){
			
		} finally {
			i = i + 2;
			
		}
		return i;
	}

}
