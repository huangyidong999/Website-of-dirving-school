package com.anonymouslnnerTest;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TalkingClock {
	public void start(int interval, boolean beep){
		ActionListener listener = new ActionListener(){
		public void actionPerformed(ActionEvent event){
			System.out.println();
			if(beep) Toolkit.getDefaultToolkit().beep();
		}
		};
		Timer t = new Timer(interval, listener);
		t.start();
	}
}
