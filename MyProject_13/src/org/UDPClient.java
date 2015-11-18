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
			DatagramSocket ds = new DatagramSocket();		// ����һ���ͻ�����UDPSocket
			f.setLocation(400, 300);
			f.setSize(300, 300);
			f.add(tf, BorderLayout.SOUTH);
			f.add(list, BorderLayout.NORTH);
			f.pack();
			f.addWindowListener(new WindowAdapter() {			// �رմ���
				public void windowClosing(WindowEvent arg0) {
					System.exit(0);
				}
			});
			tf.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try {
						byte[] rbuf = new byte[1024], 			// ���ջ�������С����Ϊ1024
						sbuf = null;
						String str =tf.getText();				// ��ȡ�ı��������
						list.add(str);						// ��������ӵ��б����
						tf.setText(null);
						sbuf = str.getBytes(); 					// ת���ֽ�����
						// ����һ�����͸�UDP��������UDP���ݰ�
						sdp = new DatagramPacket(sbuf,
 							sbuf.length, InetAddress.getByName("127.0.0.1"), 9777);
						// ����һ�����͸�UDP��������UDP���ݰ� 
						DatagramSocket ds = new DatagramSocket(); 
						ds.send(sdp); 						// ���ͳ�ȥ
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			f.setVisible(true);
			ds.close(); 											// �ر�Socket
		}
	}

