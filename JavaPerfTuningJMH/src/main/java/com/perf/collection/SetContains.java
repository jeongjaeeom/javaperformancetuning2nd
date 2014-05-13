package com.perf.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@BenchmarkMode({ Mode.AverageTime })
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class SetContains  {
	int LOOP_COUNT=1000;
	Set<String> hashSet;
	Set<String> treeSet;
	Set<String> linkedHashSet;
	
	String data = "abcdefghijklmnopqrstuvwxyz";
	String []keys;
	
	@Setup(Level.Trial)
	public void setUp() {
		hashSet=new HashSet<String>();
		treeSet=new TreeSet<String>();
		linkedHashSet=new LinkedHashSet<String>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			String tempData=data+loop;
			hashSet.add(tempData);
			treeSet.add(tempData);
			linkedHashSet.add(tempData);
		}
		if(keys==null || keys.length!=LOOP_COUNT) {
			keys=RandomKeyUtil.generateRandomSetKeysSwap(hashSet);
		}
	}
	@GenerateMicroBenchmark
	public void containsHashSet() {
		for(String key:keys) {
			hashSet.contains(key);
		}
	}
	@GenerateMicroBenchmark
	public void containsTreeSet() {
		for(String key:keys) {
			treeSet.contains(key);
		}
	}
	@GenerateMicroBenchmark
	public void containsLinkedHashSet() {
		for(String key:keys) {
			linkedHashSet.contains(key);
		}
	}
}
