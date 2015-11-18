package com.net;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
public class ChatClient extends Frame {
	static Icon[] icons = new Icon[] {
		new ImageIcon("E:/workbench/MyProject_13/src/com/net/image0.jpg"),
		new ImageIcon("E:/workbench/MyProject_13/src/com/net/image1.jpg"), };
	Socket s = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;
	private boolean Connected = false;
	TextField tf = new TextField();
	TextArea ta1 = new TextArea();
	TextArea ta2 = new TextArea();
	Button bt1 = new Button("发送");
	Thread thread = new Thread(new ClientThread());				// 创建线程
	public static void main(String[] args) {
		new ChatClient().call();
	}
	public void call() {
		bt1.setBackground(Color.cyan);
		JButton  jt1 = new JButton(icons[0]);
		JButton  jt2 = new JButton(icons[1]);
		jt1.setBounds(265, 40, 80, 80);
		jt2.setBounds(265, 140, 80, 80);
		setLocation(400, 300);
		setSize(400, 300);
		setLayout(null);									// 取消布局管理器
		setBackground(Color.cyan);
		tf.setBounds(250, 40, 70, 25);
		ta1.setBounds(30, 40, 200, 80);
		ta2.setBounds(30, 140, 200, 80);
		bt1.setBounds(265, 250, 70, 30);
		tf.setBounds(30, 240, 200, 35);
		tf.addActionListener(new MyListener());				// 注册事件监听器
		add(tf);add(jt1);add(jt2);add(bt1);
		add(ta1);add(ta2);add(tf);
		this.addWindowListener(new WindowAdapter() { 	 		// 关闭窗口
			public void windowClosing(WindowEvent e) {	
				disconnect();
				System.exit(0);
			}
		});
		bt1.addActionListener(new MyListener());				// 注册事件监听器
		setVisible(true);
		connect();
		thread.start();									// 启动线程
	}
	public void connect() {
		try {
			s = new Socket("127.0.0.1", 8888);
			dos = new DataOutputStream(s.getOutputStream());		// 返回一个输出流
			dis = new DataInputStream(s.getInputStream());		// 返回一个输入流
			System.out.println("connected!");
			Connected = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void disconnect() {
		try {
			dos.close();									// 关闭输出流
			dis.close();									// 关闭输入流
			s.close();										// 关闭Socket
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = tf.getText().trim();			// 获取文本框中的数据
			tf.setText("");
			ta2.append(str+"\n");					// 将文本框中的数据添加到文本区中
			try {
				dos.writeUTF(str);				// 向输出流中写入数据
				dos.flush();						// 刷空流
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class ClientThread implements Runnable {
		public void run() {
			try {
				while (Connected) {	
					String str = dis.readUTF();		// 从输出流中读取数据
					ta1.append(str+"\n");
				}
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
	}
}

