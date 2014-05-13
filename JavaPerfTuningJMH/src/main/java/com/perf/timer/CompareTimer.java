package com.perf.timer;

import java.util.ArrayList;
import java.util.HashMap;

public class CompareTimer {
	public static void main(String[] args) {
		CompareTimer timer=new CompareTimer();
		for(int loop=0;loop<10;loop++) {
			timer.checkNanoTime();
			timer.checkCurrentTimeMillis();
		}
	}
	private DummyData dummy;
	public void checkNanoTime() {
		long startTime=System.nanoTime();
		dummy=timeMakeObjects();
		long endTime=System.nanoTime();
		double elapsedTime=(endTime-startTime)/1000000.0;
		System.out.println("nano="+elapsedTime);
	}
	public void checkCurrentTimeMillis() {
		long startTime=System.currentTimeMillis();
		dummy=timeMakeObjects();
		long endTime=System.currentTimeMillis();
		long elapsedTime=endTime-startTime;
		System.out.println("milli="+elapsedTime);
	}
	public DummyData timeMakeObjects() {
		HashMap<String,String> map=new HashMap<String,String>(1000000);
		ArrayList<String> list=new ArrayList<String>(1000000);
		return new DummyData(map,list);
	}
}
