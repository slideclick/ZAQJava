package org.aeroplane;
import java.util.*;
import java.io.*;

public class Client {
	private String flightName = null; 					// ������
	private int row = 0; 								// ��λ����
	private int rowLength = 0; 							// ÿ����λ��
	private Flight flight = null;	 					// ���κ������
	private String cmdString = null; 					// ���
	private BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) {
		new Client().commandShell(); 					// ����shell
	}
	private void commandShell() {
		System.out.println("\n\n================================");
		System.out.println(" Command Shell V0.01 ");
		System.out.println(" type 'exit' command to exit.");
		System.out.println(" type 'help' command for HELP.");
		while (true) {
			readCommand(); 								// ������
			processCommand();	 						// ��������
		}
	}

	// ���ܣ��ӿ���̨��������
	private void readCommand() {
		// ����û�д������࣬��ʾ�ȴ�������
		if (flightName == null) {
			System.out.println("*********************************************");
			System.out.println("Please Create The Flight Data First!");
			System.out
					.println("Use command: create  flight_name  rows  rowLenght <CR>");
			System.out
					.println("*********************************************\n\n\n");
		}
		System.out.print("\nCOMMAND>"); 				// ������ʾ������Unix���
		try {
			cmdString = br.readLine().trim(); 			// ����һ������
		} catch (IOException e) {
			System.out.println(" command error!  ");
			cmdString = null;
		}
	}

	// ���ܣ��������
	// cmds ���ڱ�������ĸ����������磺���create sk213 10 5
	private void processCommand() { 
		// "create" ���� cmds[0]
		// "sk213" ���� cmds[1]
		// "10" ���� cmds[2]
		// "5" ���� cmds[3]
		String[] cmds;
		String cmd;
		if (cmdString != null) {
			cmds = command(cmdString); 					// ����������������������
			if (cmds != null){ // ��������ȷ
				cmd = cmds[0].toLowerCase(); 			// ͳһת����Сд
				if (cmd.equals("create")) { 			// ����create����
					if (flightName == null) 			// �����໹û�д���
						createCommand(cmds);
					else { 								// ������һ������
						System.out.println("Create Error:can't handle more flights!");
					}
				} else if (cmd.equals("reserve")) { 	// ����reserve����
					if (flightName != null) 			// �������Ѵ�����
						reserveCommand(cmds);
				} else if (cmd.equals("cancel")) { 		// ����cancel����
					if (flightName != null) 			// �������Ѵ�����
						cancelCommand(cmds);
				} else if (cmd.equals("list")) { 		// ����list����
					if (flightName != null) 			// �������Ѵ�����
						listCommand(cmds);
				} else if (cmd.equals("exit")) { 		// ����exit����
					System.out.println("Thanks. See you later!");
					System.exit(0);
				} else { 									
					System.out.println(" Bad command ! ");
					cmdString = null;
				}
			}
		}
	}

	// ���ܣ��������
	// ����ֵ�������д�����null�����򷵻ش��и�������������.
	private String[] command(String cmdStr) {
		int cc = 0; 									// ����з����ĸ���
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
		// create�����ʽ��
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

	private void reserveCommand(String[] cmds) { 		//�û������� cmds[1],cmds[2],...
		if (cmds.length <= 1) {
			System.out.println("reserve command error!");
			return;
		}
		String[] names = new String[cmds.length - 1];
		// �� cmds[1]..cmds[cmds.length -1]���û���COPY����
		for (int i = 0; i < names.length; i++)
			names[i] = new String(cmds[i + 1]);
		int[] bn = flight.reserve(names); 				//������λԤ��
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
