package com.perf.reflection;

import java.math.BigDecimal;
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
public class Reflection {

	int LOOP_COUNT=100;
	String result;
	
	@GenerateMicroBenchmark
	public void withEquals() {
		Object src = new BigDecimal("6");
		for (int loop = 0; loop < LOOP_COUNT; loop++) {
			if (src.getClass().getName().equals("java.math.BigDecimal")) {
				result = "BigDecimal";
			}
		}
	}

	@GenerateMicroBenchmark
	public void withInstanceof() {
		Object src = new BigDecimal("6");
		for (int loop = 0; loop < LOOP_COUNT; loop++) {
			if (src instanceof java.math.BigDecimal) {
				result = "BigDecimal";
			}
		}
	}
}
