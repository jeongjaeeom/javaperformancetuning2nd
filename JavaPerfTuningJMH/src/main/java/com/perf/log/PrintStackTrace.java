package com.perf.log;


public class PrintStackTrace {
	public static void main(String[] args) {
		PrintStackTrace trace=new PrintStackTrace();
		trace.calculate(); 
	}
	int a=3,b=0;
	double result;

	public void calculate() throws ArithmeticException {
		result=a/b;
	}
}
