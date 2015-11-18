package org;
	import java.io.*;
	import java.net.*;
	import java.awt.*;
	import java.awt.event.*;
	public class TCPServer {
		static DataInputStream dis = null;
		public static void main(String[] args) {
			boolean started = false;
			Socket s = null;
			TextArea ta = new TextArea();
			ta.append("从客户端接受的数据："+"\n");
			ServerSocket ss = null;
			try {
				ss = new ServerSocket(8800);					 // 创建一个监听Socket对象
			} catch (BindException e) {
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Frame f = new Frame("服务器端");
			f.setLocation(300, 300);
			f.setSize(200, 200);								
			f.add(ta, BorderLayout.NORTH);
			f.pack();
			f.addWindowListener(new WindowAdapter() {			// 关闭窗口
				public void windowClosing(WindowEvent e) {		
					System.exit(0);
				}
			});
			f.setVisible(true);								// 设置窗体可见
			try {
				started = true;
				while (started) {
					boolean bConnected = false;
					s = ss.accept();							// 等待客户端请求连接
					bConnected = true;
					dis = new DataInputStream(s.getInputStream());	
					while (bConnected) {
						String str = dis.readUTF();				// 从输入流中读取数据
						str.length();
						ta.append(str+",字符串长度："+str.length()+"\n");					// 将数据添加到文本区中
					}
				}
			} catch (EOFException e) {
				System.out.println("Client closed!");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (dis != null)
						dis.close();							// 关闭 输入流
					if (s != null)
						s.close();							// 关闭Socket对象
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
