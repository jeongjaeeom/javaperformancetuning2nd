package com.perf;

import java.io.IOException;

import org.openjdk.jmh.Main;

import com.perf.timer.CompareTimerJMH;

public class RunJMH {
    public static void main(String[] args) throws IOException {
    	RunJMH.compareTimerJMH(); 
    }
 
    private static void compareTimerJMH() {
    	String className=".*CompareTimerJHM.*";//".*ArrayCopy.*";
    			//"com.perf.timer.CompareTimerJHM";
    			//".*JMH.*";
    			//"\"com.perf.timer.CompareTimerJMH\"";//".*C.*";
    	int nRuns=5;
    	int runForMilliseconds=5000;
    	int nThreads=1;
    	String[] params= new String[]{
    			className,
            "-i", "" + nRuns,
            "-r", runForMilliseconds + "ms",
            "-t", "" + nThreads,
            "-w", "5000ms",
            "-wi", "3",
            
        };
//    	Main.main(params);
    	String[] param=new String[]{className};
    	Main.main(param);
//    	Main.main(new String[]{});
    }
}
