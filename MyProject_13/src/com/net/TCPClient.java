package com.net;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class TCPClient extends Frame {
	Socket s = null;
	DataOutputStream dos = null;
	DataInputStream  dis = null;
	TextField tf = new TextField(40);
	List list = new List(6);
	public static void main(String[] args) {
		TCPClient client = new TCPClient();
		client.list.add("向服务器端发送的数据：");
		client.setTitle("客户端");
		client.run();
	}
	public void run() {
		setLocation(400, 300);									// 设置窗体的位置
		this.setSize(300, 300);									// 设置窗体的大小
		add(tf, BorderLayout.SOUTH);
		add(list, BorderLayout.NORTH);
		pack();
		this.addWindowListener(new WindowAdapter() {			// 关闭窗体
			public void windowClosing(WindowEvent e) {
				disconnect();
				System.exit(0);
			}
		});
		tf.addActionListener(new MyListener());					// 注册 事件监听器
		setVisible(true);
		connect();
	}
	public void connect() {
		try {
			s = new Socket("127.0.0.1", 8866);					// 创建一个向服务器发起连接的Socket对象
			dos = new DataOutputStream(s.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		try {
			dos.close();										// 关闭输出流
			s.close();											// 关闭Socket对象
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s1 = null; 
			String s2 = null; 
			String str = tf.getText().trim();			// 获取文本框中的内容
			list.add(str);
			tf.setText("");								// 将文本框的内容清空
			try {
				dos.writeUTF(str);						// 向流中写入数据
				dos.flush();							// 刷空流
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
