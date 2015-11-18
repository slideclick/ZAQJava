package org.enums;
public class Enums {
	public enum Bills {
		ONE, TWO,FIVE
	}
	public static void main(String[] args) {
		for(Bills b : Bills.values())
			System.out.println(b + ", ordinal " + b.ordinal());	
	}	
}
