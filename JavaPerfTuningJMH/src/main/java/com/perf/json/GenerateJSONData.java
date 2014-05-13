package com.perf.json;

public class GenerateJSONData {
	public static void main(String[] args) {
		GenerateJSONData gen=new GenerateJSONData();
		gen.makeDummyData(1000);
		//TODO jackson json example write
		
	}
	public void makeDummyData(int dataCount) {
		StringBuilder data=new StringBuilder();
		data.append("\n{\"DataStart\":[");
		for(int loop=0;loop<dataCount;loop++) {
			data.append("\t{\"productName\":");
			data.append("\"prod").append(loop+1).append("\",");
			
			data.append("\"price\":");
			data.append("\"").append(loop+1).append("\"},\n");
		}
		data.deleteCharAt(data.length()-2);
		data.append("]}");
		System.out.println(data);
	}
}
