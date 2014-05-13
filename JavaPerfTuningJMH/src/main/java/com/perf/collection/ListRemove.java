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
public class ListRemove  {
	int LOOP_COUNT=10;
	List<Integer> arrayList;
	List<Integer> vector;
	LinkedList<Integer> linkedList;
	
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
	public void removeArrayListFromFirst() {
		ArrayList<Integer> tempList=new ArrayList<Integer>(arrayList);
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			tempList.remove(0);
		}
	}
	@GenerateMicroBenchmark
	public void removeVectorFromFirst() {
		List<Integer> tempList=new Vector<Integer>(vector);
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			tempList.remove(0);
		}
	}
	@GenerateMicroBenchmark
	public void removeLinkedListFromFirst() {
		LinkedList<Integer> tempList=new LinkedList<Integer>(linkedList);
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			tempList.remove(0);
		}
	}
	
	@GenerateMicroBenchmark
	public void removeArrayListFromLast() {
		ArrayList<Integer> tempList=new ArrayList<Integer>(arrayList);
		for(int loop=LOOP_COUNT-1;loop>=0;loop--) {
			tempList.remove(loop);
		}
	}
	@GenerateMicroBenchmark
	public void removeVectorFromLast() {
		List<Integer> tempList=new Vector<Integer>(vector);
		for(int loop=LOOP_COUNT-1;loop>=0;loop--) {
			tempList.remove(loop);
		}
	}
	@GenerateMicroBenchmark
	public void removeLinkedListFromLast() {
		LinkedList<Integer> tempList=new LinkedList<Integer>(linkedList);
		for(int loop=0;loop<LOOP_COUNT;loop++) {
			tempList.removeLast();
		}
	}
	
}