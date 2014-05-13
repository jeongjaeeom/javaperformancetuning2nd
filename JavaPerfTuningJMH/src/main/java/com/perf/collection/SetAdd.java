package com.perf.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
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
public class SetAdd  {
	int LOOP_COUNT=1000;
	Set<String> set;
	String data = "abcdefghijklmnopqrstuvwxyz";
	
	@GenerateMicroBenchmark
	public void addHashSet() {
		set=new HashSet<String>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			set.add(data+loop);
		}
	}
	
	@GenerateMicroBenchmark
	public void addHashSetWithInitialSize() {
		set=new HashSet<String>(LOOP_COUNT);
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			set.add(data+loop);
		}
	}
	
	@GenerateMicroBenchmark
	public void addTreeSet() {
		set=new TreeSet<String>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			set.add(data+loop);
		}
	}
	@GenerateMicroBenchmark
	public void addLinkedHashSet() {
		set=new LinkedHashSet<String>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			set.add(data+loop);
		}
	}
}
