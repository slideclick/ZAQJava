package com.net;
	import java.io.*;
	import java.net.*;
	import java.awt.*;
	import java.awt.event.*;
	public class MulticastUDPServer {
		static List list = new List(6);
		static TextField tf = new TextField(40);
		static DatagramPacket sdp = null;
		public static void main(String[] args) throws Exception {
			Frame f = new Frame();
			DatagramSocket ds = null;
			f.setLocation(400, 300);
			f.add(list,BorderLayout.NORTH);
			f.add(tf,BorderLayout.SOUTH);
			f.setSize(300, 300);
			f.pack();
			tf.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try {
						String str =tf.getText();				// 获取文本框的数据
						list.add(str);						// 将数据添加到
						tf.setText(null);
						byte[] sbuf = str.getBytes();				// 将字符串转换为字节数组
						// 构造一个发往组226.1.1.6、端口号8888的UDP包
						MulticastUDPServer.sdp = new DatagramPacket(sbuf, 
								sbuf.length, InetAddress.getByName("226.1.1.6"), 8888);
						// 创建一个UDPSocket，用于发送数据包
						DatagramSocket ds = new DatagramSocket(); 		
						ds.send(sdp); 						// 向组发送数据包
						Thread.currentThread().sleep(3000); 		// 等待3秒
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			f.addWindowListener(new WindowAdapter() {			// 关闭窗体
				public void windowClosing(WindowEvent arg0) {
					System.exit(0);
				}
			});
			f.setVisible(true);								// 设置窗体可见
		}
	}

