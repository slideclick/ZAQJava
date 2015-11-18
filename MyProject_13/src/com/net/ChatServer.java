package com.net;

import java.io.*;
import java.net.*;
import java.util.*;
public class ChatServer {
	boolean started = false;
	ServerSocket ss = null;
	//List<Client> clients =Collections.synchronized( new ArrayList<Client>());
	List<Client> clients =Collections.synchronizedList(new ArrayList<Client>());
	//clients�ǹ������,ͨ��Collections.synchronized(��)��ͬ��������
	public static void main(String[] args) {
		new ChatServer().start();
	}
	public void start() {
		try {
			ss = new ServerSocket(8888); 					// ����һ������Socket����
			started = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			while (started) {
				Socket s = ss.accept(); 					// �ȴ��ͻ��˷�������
				Client c = new Client(s);
				System.out.println("a client connected!");
				new Thread(c).start(); 						// �����߳�
				clients.add(c);                              //�����¿ͻ���
			}
			ss.close(); 									// �ر�Socket
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	class Client implements Runnable { 						// ʵ��Runnable�ӿ�
		private Socket s;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private boolean Connected = false;
		public Client(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream()); 	// ����������
				dos = new DataOutputStream(s.getOutputStream()); // ���������
				Connected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void send(String str) {
			try {
				dos.writeUTF(str); 						// ����������д������
			} catch (IOException e) {
				clients.remove(this); 		//����ʱ(�ͻ������Ѷ���),�Ƴ�һ���ͻ���
			}
		}
		public void run() {
			try {
				while (Connected) {
					String str = dis.readUTF(); 				// ��������ж�ȡ����
                        synchronized(clients){     //�Թ�����б���б���ʱ����Ҫͬ����
					Iterator<Client> it = clients.iterator();		// ����һ��������
					while(it.hasNext()) {
						Client c = it.next();
						c.send(str);						// �����ݷ��ͳ�ȥ
					}//while
                    }//synchronized
				} //while(Connected)
				dis.close();								// �ر�������
				dos.close();								// �ر������
				s.close();								// �ر�Socket
			} catch (Exception e) {
				System.out.println("Client closed!");
			}
               finally{
                     clients.remove(this);    
       //ȷ���߳̽���ʱ�ӹ��������ɾ���Լ�(����:�ӿͻ���������ʱ����,
       //�ͻ��������ѵ���,�̻߳����)
}//try
		}//run
	}
}

