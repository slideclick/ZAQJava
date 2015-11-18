package org.aeroplane;
import java.util.*;
import java.io.*;

public class Client {
	private String flightName = null; 					// 航班名
	private int row = 0; 								// 座位排数
	private int rowLength = 0; 							// 每排座位数
	private Flight flight = null;	 					// 本次航班对象
	private String cmdString = null; 					// 命令串
	private BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) {
		new Client().commandShell(); 					// 命令shell
	}
	private void commandShell() {
		System.out.println("\n\n================================");
		System.out.println(" Command Shell V0.01 ");
		System.out.println(" type 'exit' command to exit.");
		System.out.println(" type 'help' command for HELP.");
		while (true) {
			readCommand(); 								// 读命令
			processCommand();	 						// 处理命令
		}
	}

	// 功能：从控制台读入命令
	private void readCommand() {
		// 若还没有创建航班，提示先创建航班
		if (flightName == null) {
			System.out.println("*********************************************");
			System.out.println("Please Create The Flight Data First!");
			System.out
					.println("Use command: create  flight_name  rows  rowLenght <CR>");
			System.out
					.println("*********************************************\n\n\n");
		}
		System.out.print("\nCOMMAND>"); 				// 命令提示符，仿Unix风格
		try {
			cmdString = br.readLine().trim(); 			// 读入一行命令
		} catch (IOException e) {
			System.out.println(" command error!  ");
			cmdString = null;
		}
	}

	// 功能：分析命令串
	// cmds 用于保存命令的各个分量。如：命令：create sk213 10 5
	private void processCommand() { 
		// "create" 放在 cmds[0]
		// "sk213" 放在 cmds[1]
		// "10" 放在 cmds[2]
		// "5" 放在 cmds[3]
		String[] cmds;
		String cmd;
		if (cmdString != null) {
			cmds = command(cmdString); 					// 分析命令，分离出各个分量。
			if (cmds != null){ // 若命令正确
				cmd = cmds[0].toLowerCase(); 			// 统一转换成小写
				if (cmd.equals("create")) { 			// 处理create命令
					if (flightName == null) 			// 若航班还没有创建
						createCommand(cmds);
					else { 								// 仅处理一个航班
						System.out.println("Create Error:can't handle more flights!");
					}
				} else if (cmd.equals("reserve")) { 	// 处理reserve命令
					if (flightName != null) 			// 当航班已创建过
						reserveCommand(cmds);
				} else if (cmd.equals("cancel")) { 		// 处理cancel命令
					if (flightName != null) 			// 当航班已创建过
						cancelCommand(cmds);
				} else if (cmd.equals("list")) { 		// 处理list命令
					if (flightName != null) 			// 当航班已创建过
						listCommand(cmds);
				} else if (cmd.equals("exit")) { 		// 处理exit命令
					System.out.println("Thanks. See you later!");
					System.exit(0);
				} else { 									
					System.out.println(" Bad command ! ");
					cmdString = null;
				}
			}
		}
	}

	// 功能：分析命令串
	// 返回值：命令有错，返回null，否则返回存有各个分量的数组.
	private String[] command(String cmdStr) {
		int cc = 0; 									// 命令串中分量的个数
		String[] cmd;
		StringTokenizer st = new StringTokenizer(cmdStr);
		if ((cc = st.countTokens()) == 0)
			return null;
		cmd = new String[cc];
		for (int i = 0; i < cc; i++)
			cmd[i] = st.nextToken();
		return cmd;
	}

	private int readInt(String valstr) {
		int val = 0;
		try {
			val = Integer.parseInt(valstr);
		} catch (Exception e) {
			val = Integer.MIN_VALUE;
		}
		return val;
	}

	private void createCommand(String[] cmds) {
		if (cmds.length != 4) {
			System.out.println("create command error!");
		}
		// create命令格式错
		else {
			flightName = cmds[1];
			row = readInt(cmds[2]);
			rowLength = readInt(cmds[3]);
			if (row <= 0 || rowLength <= 0) {
				System.out.println("create command parameters error!");
				flightName = null;
				row = 0;
				rowLength = 0;
			} else {
				try {
					flight = new Flight(flightName, row, rowLength);
					System.out.println("create Flight OK!");
				} catch (Exception e) {
					System.out.println(e);
					flight = null;
					flightName = null;
					row = 0;
					rowLength = 0;
				}
			}
		}
	}

	private void reserveCommand(String[] cmds) { 		//用户名放在 cmds[1],cmds[2],...
		if (cmds.length <= 1) {
			System.out.println("reserve command error!");
			return;
		}
		String[] names = new String[cmds.length - 1];
		// 从 cmds[1]..cmds[cmds.length -1]将用户名COPY过来
		for (int i = 0; i < names.length; i++)
			names[i] = new String(cmds[i + 1]);
		int[] bn = flight.reserve(names); 				//处理座位预订
		if (bn[0] != -1) {
			for (int i = 0; i < bn.length; i++)
				System.out.println(names[i] + "'s Booking Number is:" + bn[i]);
		} else
			System.out.println("No Such Sequential Seats Now!");
	}

	private void cancelCommand(String[] cmds) {
		if (cmds.length != 2) {
			System.out.println("\ncancel command format error!");
			return;
		}
		int bookingNumber = readInt(cmds[1]);
		if (bookingNumber <= 0) {
			System.out.println("\ncancel command parameter error!");
			return;
		}
		boolean state = flight.cancel(bookingNumber);
		if (state)
			System.out.println(" Your seat has been cancelled! ");
		else
			System.out.println("The seat has not been reserved!");
	}

	private void listCommand(String[] cmds) {
		if (cmds.length != 1) {
			System.out.println("\nlist command format error!");
			return;
		}
		Passenger[] passengerlist = flight.getPassengerList();
		int flag = 0;
		System.out.println("Name Booking Number Row Seat Position ");
		System.out.println("---------------------------------------------------------");
		if (passengerlist == null || passengerlist.length <= 0)
			System.out.println("Now no seat is occupied!");
		else {
			flag = 0;
			for (int b = 0; b < passengerlist.length; b++) {
				if (passengerlist[b] != null) {
					flag = 1;
					System.out
							.println(formatStr(passengerlist[b].getName())
									+ formatStr(""
											+ passengerlist[b]
													.getBookingNumber())
									+ formatStr("" + passengerlist[b].getRow())
									+ formatStr(""
											+ passengerlist[b]
													.getSeatPosition()));
				}
			}
			if (flag == 0)
				System.out.println("Now no seat is occupied!");
		}
	}

	private String formatStr(String s) {
		for (int i = 0; i < 16 - s.trim().length(); i++)
			s += ' ';
		return s;
	}
}
