package com.perf.condition;

public class SwitchCaseString {

	public static void main(String[] args) {
		SwitchCaseString scs=new SwitchCaseString();
		scs.getMonthNumber("February");
	}
	public int getMonthNumber(String str) {
		int month=-1;
		switch(str) {
		case "January": month=1;
			break;
		case "February": month=2;
			break;
		case "March" : month=3;
			break;
		case "April": month=4;
			break;
		case "May": month=5;
			break;
		case "June": month=6;
			break;
		case "July": month=7;
			break;
		case "August": month=8;
			break;
		case "September": month=9;
			break;
		case "October": month=10;
			break;
		case "November": month=11;
			break;
		case "December": month=12;
			break;
		}
//		System.out.println("January".hashCode());
//		System.out.println("February".hashCode());
//		System.out.println("March".hashCode());
//		System.out.println("April".hashCode());

		return month;
	}
	
}
