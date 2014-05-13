package com.perf.json;

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
public class JSONParser {

	@GenerateMicroBenchmark
	public void parseStream100(){
		ParseJSON pj=new ParseJSON();
		pj.parseStream("dummy100.json");
	}
	@GenerateMicroBenchmark
	public void parseStream1000(){
		ParseJSON pj=new ParseJSON();
		pj.parseStream("dummy1000.json");
	}

}