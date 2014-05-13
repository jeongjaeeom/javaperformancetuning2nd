package com.perf.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
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
public class ListGet  {
	int LOOP_COUNT=1000;
	List<Integer> arrayList;
	List<Integer> vector;
	LinkedList<Integer> linkedList;
	
	int result=0;
	
	@Setup(Level.Trial) 
	public void setUp() {
		arrayList=new ArrayList<Integer>();
		vector=new Vector<Integer>();
		linkedList=new LinkedList<Integer>();
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			arrayList.add(loop);
			vector.add(loop);
			linkedList.add(loop);
		}
	}
	@GenerateMicroBenchmark
	public void getArrayList() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			result=arrayList.get(loop);
		}
	}
	@GenerateMicroBenchmark
	public void getVector() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			result=vector.get(loop);
		}
	}
	@GenerateMicroBenchmark
	public void getLinkedList() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			result=linkedList.get(loop);
		}
	}
	@GenerateMicroBenchmark
	public void peekLinkedList() {
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			result=linkedList.peek();
		}
	}

}