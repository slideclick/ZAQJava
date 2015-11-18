package org.aeroplane;
public class Flight implements FlightInterface {
	private String flightName; 							//航班名
	private int row; 									//座位排数
	private int rowLength; 								//每排座位数
	private int[] fail = { -1 }; 						//返回预订号
	private Passenger[] passengerList; 					//预订座位的旅客
	public Flight(String FlightName, int rows, int rowLength)
			throws Exception {
		if (FlightName == null || FlightName.trim().length() == 0 || rows <= 0
				|| rowLength <= 0)
			throw new Exception("Error");
		else {
			this.flightName = FlightName;
			this.row = rows;
			this.rowLength = rowLength;
			this.passengerList = new Passenger[row * rowLength];
			for (int i = 0; i < row * rowLength; i++)
				passengerList[i] = null; 				//所有座位没有被预订
		}
	}
	// 功能：预订座位
	public int[] reserve(String names[]) {
		if (names.length > rowLength)
			return fail;
		int i = 0, j = 0, k = 0;
		// true--能安排false--不能安排
		boolean flag = false; 									
		// 在同一排找相邻的且没有被预订的座位，座位个数是names.length
		labelA: for (i = 0; i <= row - 1; i++) {
			for (j = 0; j <= rowLength - names.length; j++) {
				// 在本行从 j 到j+names.length-1找这样的空座位
				for (k = j; k <= j + names.length - 1; k++) { 	
					if (passengerList[i * rowLength + k] != null)
						break;
				}
				if (k > j + names.length - 1) { 		//已找到,从第i行第j列开始
					flag = true; 						//设置已找到标记
					break labelA; 						//退出整个循环
				}
			}
		}
		if (!flag)
			return fail;
		// 从第i行第j列开始分配座位
		int[] bn = new int[names.length]; 				//每一个旅客返回一个预订号
		for (k = j; k <= j + names.length - 1; k++) {
			bn[k - j] = i * rowLength + k + 1; 			//产生预订号，names[0]对应 bn[0]
			passengerList[i * rowLength + k] = new Passenger(names[k - j], i
					* rowLength + k + 1, i, k);
		}
		return bn;
	}
	public boolean cancel(int bookingNumber) {
		boolean Status = false;
		for (int i = 0; i < row * rowLength; i++) {
			if (passengerList[i] != null
					&& bookingNumber == passengerList[i].getBookingNumber()) {
				Status = true;
				passengerList[i] = null;
				break;
			}
		}
		return Status;
	}
	public Passenger[] getPassengerList() {
		return passengerList;
	}
}
