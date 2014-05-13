package com.perf.io;

public class WatcherSample {

	public static void main(String[] args) {
		WatcherThread thread=new WatcherThread("C:\\Temp");
		thread.start();
	}

}
