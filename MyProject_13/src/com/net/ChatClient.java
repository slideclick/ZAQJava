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
	Button bt1 = new Button("����");
	Thread thread = new Thread(new ClientThread());				// �����߳�
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
		setLayout(null);									// ȡ�����ֹ�����
		setBackground(Color.cyan);
		tf.setBounds(250, 40, 70, 25);
		ta1.setBounds(30, 40, 200, 80);
		ta2.setBounds(30, 140, 200, 80);
		bt1.setBounds(265, 250, 70, 30);
		tf.setBounds(30, 240, 200, 35);
		tf.addActionListener(new MyListener());				// ע���¼�������
		add(tf);add(jt1);add(jt2);add(bt1);
		add(ta1);add(ta2);add(tf);
		this.addWindowListener(new WindowAdapter() { 	 		// �رմ���
			public void windowClosing(WindowEvent e) {	
				disconnect();
				System.exit(0);
			}
		});
		bt1.addActionListener(new MyListener());				// ע���¼�������
		setVisible(true);
		connect();
		thread.start();									// �����߳�
	}
	public void connect() {
		try {
			s = new Socket("127.0.0.1", 8888);
			dos = new DataOutputStream(s.getOutputStream());		// ����һ�������
			dis = new DataInputStream(s.getInputStream());		// ����һ��������
			System.out.println("connected!");
			Connected = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void disconnect() {
		try {
			dos.close();									// �ر������
			dis.close();									// �ر�������
			s.close();										// �ر�Socket
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = tf.getText().trim();			// ��ȡ�ı����е�����
			tf.setText("");
			ta2.append(str+"\n");					// ���ı����е�������ӵ��ı�����
			try {
				dos.writeUTF(str);				// ���������д������
				dos.flush();						// ˢ����
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class ClientThread implements Runnable {
		public void run() {
			try {
				while (Connected) {	
					String str = dis.readUTF();		// ��������ж�ȡ����
					ta1.append(str+"\n");
				}
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
	}
}

