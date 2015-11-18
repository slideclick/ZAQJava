package org;
	import java.io.*;
	import java.net.*;
	import java.util.Date;
	import java.awt.*;
	import java.awt.event.*;
	public class UDPClient {
		static List list = new List(6);
		static TextField tf = new TextField(40);
		static DatagramPacket sdp = null;
		static DatagramPacket rdp = null;
		public static void main(String[] args) throws Exception {
			Frame f = new Frame("UDPClient");
			DatagramSocket ds = new DatagramSocket();		// 生成一个客户机用UDPSocket
			f.setLocation(400, 300);
			f.setSize(300, 300);
			f.add(tf, BorderLayout.SOUTH);
			f.add(list, BorderLayout.NORTH);
			f.pack();
			f.addWindowListener(new WindowAdapter() {			// 关闭窗口
				public void windowClosing(WindowEvent arg0) {
					System.exit(0);
				}
			});
			tf.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try {
						byte[] rbuf = new byte[1024], 			// 接收缓冲区大小设置为1024
						sbuf = null;
						String str =tf.getText();				// 获取文本框的内容
						list.add(str);						// 将数据添加到列表框中
						tf.setText(null);
						sbuf = str.getBytes(); 					// 转换字节数组
						// 生成一个发送给UDP服务器的UDP数据包
						sdp = new DatagramPacket(sbuf,
 							sbuf.length, InetAddress.getByName("127.0.0.1"), 9777);
						// 生成一个发送给UDP服务器的UDP数据包 
						DatagramSocket ds = new DatagramSocket(); 
						ds.send(sdp); 						// 发送出去
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			f.setVisible(true);
			ds.close(); 											// 关闭Socket
		}
	}

