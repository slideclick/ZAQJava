package com.net;

import java.io.*;
import java.net.*;
import java.util.*;
public class ChatServer {
	boolean started = false;
	ServerSocket ss = null;
	//List<Client> clients =Collections.synchronized( new ArrayList<Client>());
	List<Client> clients =Collections.synchronizedList(new ArrayList<Client>());
	//clients是共享变量,通过Collections.synchronized(…)做同步化处理
	public static void main(String[] args) {
		new ChatServer().start();
	}
	public void start() {
		try {
			ss = new ServerSocket(8888); 					// 创建一个监听Socket对象
			started = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			while (started) {
				Socket s = ss.accept(); 					// 等待客户端发起连接
				Client c = new Client(s);
				System.out.println("a client connected!");
				new Thread(c).start(); 						// 启动线程
				clients.add(c);                              //加入新客户端
			}
			ss.close(); 									// 关闭Socket
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	class Client implements Runnable { 						// 实现Runnable接口
		private Socket s;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private boolean Connected = false;
		public Client(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream()); 	// 创建输入流
				dos = new DataOutputStream(s.getOutputStream()); // 创建输出流
				Connected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void send(String str) {
			try {
				dos.writeUTF(str); 						// 向输入流中写入数据
			} catch (IOException e) {
				clients.remove(this); 		//出错时(客户可能已断线),移除一个客户端
			}
		}
		public void run() {
			try {
				while (Connected) {
					String str = dis.readUTF(); 				// 从输出流中读取数据
                        synchronized(clients){     //对共享的列表进行遍历时必须要同步化
					Iterator<Client> it = clients.iterator();		// 返回一个迭代器
					while(it.hasNext()) {
						Client c = it.next();
						c.send(str);						// 将数据发送出去
					}//while
                    }//synchronized
				} //while(Connected)
				dis.close();								// 关闭输入流
				dos.close();								// 关闭输出流
				s.close();								// 关闭Socket
			} catch (Exception e) {
				System.out.println("Client closed!");
			}
               finally{
                     clients.remove(this);    
       //确保线程结束时从共享变量中删除自己(比如:从客户机读数据时出错,
       //客户机可能已掉线,线程会结束)
}//try
		}//run
	}
}

