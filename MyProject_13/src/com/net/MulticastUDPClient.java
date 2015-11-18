package com.net;
		import java.io.*;
		import java.net.*;
		import java.awt.*;
		import java.awt.event.*;
		public class MulticastUDPClient {
			public static void main(String[] args) throws Exception {
				TextArea list = new TextArea();
				Frame f = new Frame();
				DatagramSocket ds = null;
				f.setLocation(400, 300);
				f.add(list,BorderLayout.NORTH);
				f.setSize(300, 300);
				f.pack();
				list.append("组播包的内容为："+"\n");
				f.setVisible(true);
				MulticastSocket msocket = new MulticastSocket(8888);
				// 在8888端口创建一个组播用的Socket
				InetAddress group = InetAddress.getByName("226.1.1.6");
				// 形成组播地址
				msocket.joinGroup(group);
				// 加入该组，这样可接收到该组中的包
				DatagramPacket rdp = null;
				byte[] rbuf = new byte[1024];
				boolean more = true;
				f.addWindowListener(new WindowAdapter() {	// 关闭窗体
					public void windowClosing(WindowEvent arg0) {
						System.exit(0);
					}
				});
				do {
					rdp = new DatagramPacket(rbuf, 1024);
					msocket.receive(rdp);					// 等待接收组中包
					// 取出包中数据内容
					String data = new String(rdp.getData(), rdp.getOffset(), rdp.getLength());
					list.append(data+"\n");
				} while (more); 
				msocket.leaveGroup(group); 				// 离开该组
				msocket.close(); 						// 关闭Socket
			}
		}

