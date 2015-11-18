package org;
	import java.io.*;
	import java.net.*;
	import java.awt.*;
	import java.awt.event.*;
	public class UDPServer {
		public static void main(String[] args) throws Exception {
			DatagramSocket ds = new DatagramSocket(9777);		// 在9777端口上创建UDPSocket
			Frame f = new Frame("UDPServer");
			f.setLocation(400, 300);
			f.setSize(300, 300);
			TextField tf = new TextField(40);
			TextArea list = new TextArea();
			f.add(list, BorderLayout.NORTH);
			f.pack();
			f.setVisible(true);
			f.addWindowListener(new WindowAdapter() {		// 关闭窗口
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			byte[] buf = new byte[1024];						// 接收缓冲区
			DatagramPacket dp = null; 						// 接收UDP数据包
			DatagramPacket sdp = null; 						// 发送UDP数据包
			boolean more = true; 							// 控制UDP服务器
			while (more) {
				dp = new DatagramPacket(buf, 1024); 			// 创建一个用于接收的UDP数据包
				ds.receive(dp); 							// 等待任一个客户机发数据包
				InetAddress caddr = dp.getAddress(); 			// 获取客户机的IP地址
				int cport = dp.getPort();			 		// 获取客户机的端口号
				// 获取客户机发送的文本内容
				String s = new String(dp.getData(), dp.getOffset(), dp.getLength());
				String str = "客户机 IP: " + caddr + " 客户机端口号：" + cport+ "\n"
						+ "  客户机发送的数据是：" + s + " \n";
				list.append(str);
				String rs = new String("字符串：" + s + " 的长度是：" + s.length());
				byte[] sbuf = rs.getBytes();					// 将串转换成字节数组
				// 生成一个发送回特定客户机的UDP数据包的DatagramPacket对象
				sdp = new DatagramPacket(sbuf, sbuf.length, caddr, cport);
				ds.send(sdp); 							// 向客户机发回响应信息
			}
		}
	}

