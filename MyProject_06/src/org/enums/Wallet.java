package org.enums;
	public class Wallet {
		Bills b;
		public static void main(String[] args) {
			for(Bills b : Bills.values()) {
				System.out.print("Worth: ");
				switch(b) {
					case ONE: System.out.println("��1"); break; 
					case FIVE: System.out.println("��5"); break;
					case TEN: System.out.println("��10"); break;
					default: break;
				}
			}	
		}
	}
	enum Bills {
		ONE, FIVE, TEN
	}

