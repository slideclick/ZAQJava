package org.enums;
	public class Wallet {
		Bills b;
		public static void main(String[] args) {
			for(Bills b : Bills.values()) {
				System.out.print("Worth: ");
				switch(b) {
					case ONE: System.out.println("гд1"); break; 
					case FIVE: System.out.println("гд5"); break;
					case TEN: System.out.println("гд10"); break;
					default: break;
				}
			}	
		}
	}
	enum Bills {
		ONE, FIVE, TEN
	}

