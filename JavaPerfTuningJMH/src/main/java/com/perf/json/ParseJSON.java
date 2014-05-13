package com.perf.json;

import java.io.File;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class ParseJSON {

	public void parseStream(String json) {
		JsonFactory f = new JsonFactory();
		StringBuilder jsonResult=new StringBuilder();
		try {
			JsonParser jp = f.createJsonParser(new File(json));
			jp.nextToken();
			while (jp.nextToken() != JsonToken.END_ARRAY) {
				String fieldName = jp.getCurrentName();
				if(fieldName!=null) {
					jp.nextToken(); 
					String text=jp.getText();
					if(fieldName.equals("productName")) {
						jsonResult.append("Product=").append(text).append("\t");
					} else if(fieldName.equals("price")) {
						jsonResult.append("Price=").append(text).append("\n");
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
