package org.enums;
	public enum Orientation {
		EAST("shanghai"),SOUTH("shenzhen"),WEST("xian"),NORTH("beijiang");
		private String city;
		Orientation(String city) {					// enum的构造方法
			this.city = city;
		}
		public String getCity() {					// enum的普通方法
			return city;
		}
		public static void main(String[] args) {
			Orientation or1 = Orientation.EAST;
			Orientation or2 = Orientation.SOUTH;
			Orientation or3 = Orientation.WEST;
			Orientation or4 = Orientation.NORTH;
			System.out.println(or1.getCity());
			System.out.println(or2.getCity());
			System.out.println(or3.getCity());
			System.out.println(or4.getCity());
		}
	}
