package com.perf.io;

import java.io.File;
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
public class IOPerformance {
	long lastModifiedTime;
	
	@GenerateMicroBenchmark
	public void lastModified() {
		File file=new File("C:\\Temp\\setting.properties");
		lastModifiedTime=file.lastModified();
	}

}
