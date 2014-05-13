package com.perf.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
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
public class MapGet {
	int LOOP_COUNT=1000;
	Map<Integer,String> hashMap;
	Map<Integer,String> hashtable;
	Map<Integer,String> treeMap;
	Map<Integer,String> linkedHashMap;
	int keys[];
	@Setup(Level.Trial)
	public void setUp() {
		if(keys==null || keys.length!=LOOP_COUNT) {
			hashMap=new HashMap<Integer,String>();
			hashtable=new Hashtable<Integer,String>();
			treeMap=new TreeMap<Integer,String>();
			linkedHashMap=new LinkedHashMap<Integer,String>();
			String data="abcdefghijklmnopqrstuvwxyz";
			for(int loop=0;loop<LOOP_COUNT;loop++) {
				String tempData=data+loop;
				hashMap.put(loop,tempData);
				hashtable.put(loop,tempData);
				treeMap.put(loop,tempData);
				linkedHashMap.put(loop,tempData);
			}
			keys=RandomKeyUtil.generateRandomNumberKeysSwap(LOOP_COUNT);
		}
	}

	@GenerateMicroBenchmark
	public void getSeqHashMap() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			hashMap.get(loop);
		}
	}
	@GenerateMicroBenchmark
	public void getRandomHashMap() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			hashMap.get(keys[loop]);
		}
	}
	
	@GenerateMicroBenchmark
	public void getSeqHashtable() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			hashtable.get(loop);
		}
	}
	@GenerateMicroBenchmark
	public void getRandomHashtable() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			hashtable.get(keys[loop]);
		}
	}
	
	@GenerateMicroBenchmark
	public void getSeqTreeMap() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			treeMap.get(loop);
		}
	}
	@GenerateMicroBenchmark
	public void getRandomTreeMap() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			treeMap.get(keys[loop]);
		}
	}
	
	@GenerateMicroBenchmark
	public void getSeqLinkedHashMap() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			linkedHashMap.get(loop);
		}
	}
	@GenerateMicroBenchmark
	public void getRandomLinkedHashMap() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			linkedHashMap.get(keys[loop]);
		}
	}
}