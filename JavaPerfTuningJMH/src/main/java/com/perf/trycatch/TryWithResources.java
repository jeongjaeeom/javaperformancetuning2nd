package com.perf.trycatch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

	public static void main(String[] args) {
		
	}
	public String readFile(String fileName) throws IOException {
		FileReader reader=new FileReader(new File(fileName));
		BufferedReader br=new BufferedReader(reader);
		String data=null;
		try {
			data=br.readLine();
		} finally {
			if (br!=null) br.close();
		}
		return data;
	}
	public String readFileNew(String fileName) throws IOException {
		FileReader reader=new FileReader(new File(fileName));
		try(BufferedReader br = new BufferedReader(reader)) {
			return br.readLine();
		}
	}
}
