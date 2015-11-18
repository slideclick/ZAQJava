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
						String str =tf.getText();				// ��ȡ�ı��������
						list.add(str);						// ��������ӵ�
						tf.setText(null);
						byte[] sbuf = str.getBytes();				// ���ַ���ת��Ϊ�ֽ�����
						// ����һ��������226.1.1.6���˿ں�8888��UDP��
						MulticastUDPServer.sdp = new DatagramPacket(sbuf, 
								sbuf.length, InetAddress.getByName("226.1.1.6"), 8888);
						// ����һ��UDPSocket�����ڷ������ݰ�
						DatagramSocket ds = new DatagramSocket(); 		
						ds.send(sdp); 						// ���鷢�����ݰ�
						Thread.currentThread().sleep(3000); 		// �ȴ�3��
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			f.addWindowListener(new WindowAdapter() {			// �رմ���
				public void windowClosing(WindowEvent arg0) {
					System.exit(0);
				}
			});
			f.setVisible(true);								// ���ô���ɼ�
		}
	}

