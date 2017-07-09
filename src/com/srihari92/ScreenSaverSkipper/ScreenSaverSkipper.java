package com.srihari92.ScreenSaverSkipper;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.util.Random;

public class ScreenSaverSkipper {
	// time interval to check mousemovement
	final int TIMER_INTERVAL=1000*60; // change as your convenient 

	public static void main(String... a){
		ScreenSaverSkipper m=new ScreenSaverSkipper();
		m.doMovement();

	}

	private void doMovement(){
		//initial x,y set to zero
		int x = 0,y = 0;
		int maxX,maxY;
		Robot r=null;
		Random ran=null;
		// getting the dimension of system
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		maxX = (int) screenSize.getWidth();
		maxY = (int) screenSize.getHeight();
		try {
			ran=new Random();
			r=new Robot();
			// infinite loof
			while(true){
				// get the mouse postion
				Point p=MouseInfo.getPointerInfo().getLocation();
				// if previous position of mouse point not equal to current position
				if(x!=p.getX() || y!=p.getY()){
					//update latest postion and sleep for TIMER_INTERVAL
					x=(int) p.getX();
					y=(int) p.getY();
					Thread.sleep(TIMER_INTERVAL);
				}
				// if previous position of mouse point equal to current position
				// so no movement from the user for TIMER_INTERVAL
				else{
					// generate random number within scope of user's screen and update
					// update the previous position points and wait for TIMER_INTERVAL.
					x=ran.nextInt(maxX);
					y=ran.nextInt(maxY);
					r.mouseMove(x,y);
					Thread.sleep(TIMER_INTERVAL);
				}
			}
		} catch (AWTException | InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}