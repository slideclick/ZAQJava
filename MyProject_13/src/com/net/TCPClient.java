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
		client.list.add("��������˷��͵����ݣ�");
		client.setTitle("�ͻ���");
		client.run();
	}
	public void run() {
		setLocation(400, 300);									// ���ô����λ��
		this.setSize(300, 300);									// ���ô���Ĵ�С
		add(tf, BorderLayout.SOUTH);
		add(list, BorderLayout.NORTH);
		pack();
		this.addWindowListener(new WindowAdapter() {			// �رմ���
			public void windowClosing(WindowEvent e) {
				disconnect();
				System.exit(0);
			}
		});
		tf.addActionListener(new MyListener());					// ע�� �¼�������
		setVisible(true);
		connect();
	}
	public void connect() {
		try {
			s = new Socket("127.0.0.1", 8866);					// ����һ����������������ӵ�Socket����
			dos = new DataOutputStream(s.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		try {
			dos.close();										// �ر������
			s.close();											// �ر�Socket����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s1 = null; 
			String s2 = null; 
			String str = tf.getText().trim();			// ��ȡ�ı����е�����
			list.add(str);
			tf.setText("");								// ���ı�����������
			try {
				dos.writeUTF(str);						// ������д������
				dos.flush();							// ˢ����
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
