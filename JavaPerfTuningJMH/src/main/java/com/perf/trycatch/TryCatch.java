package com.perf.trycatch;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@BenchmarkMode({ Mode.AverageTime })
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class TryCatch {
	
	int LOOP_COUNT=1000;
	boolean result;
	
	@GenerateMicroBenchmark
	public void tryCatchExceptionThrow() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			try {
				result=resultProcessThrow(0);
			} catch(Exception e) {
				
			}
		}
	}
	@GenerateMicroBenchmark
	public void tryCatchNoException() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			try {
				result=resultProcessThrow(1);
			} catch(Exception e) {
				
			}
		}
	}
	@GenerateMicroBenchmark
	public void normal() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			result=resultProcess(0);
		}
	}
	public boolean resultProcessThrow(int data) throws RuntimeException{
		if(data==0) {
			throw new RuntimeException("Exception Occured");
		} else {
			return true;
		}
	}
	public boolean resultProcess(int data) {
		if(data==0) {
			return false;
		} else {
			return true;
		}
	}
}
