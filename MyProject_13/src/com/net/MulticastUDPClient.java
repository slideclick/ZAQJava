package com.net;
		import java.io.*;
		import java.net.*;
		import java.awt.*;
		import java.awt.event.*;
		public class MulticastUDPClient {
			public static void main(String[] args) throws Exception {
				TextArea list = new TextArea();
				Frame f = new Frame();
				DatagramSocket ds = null;
				f.setLocation(400, 300);
				f.add(list,BorderLayout.NORTH);
				f.setSize(300, 300);
				f.pack();
				list.append("�鲥��������Ϊ��"+"\n");
				f.setVisible(true);
				MulticastSocket msocket = new MulticastSocket(8888);
				// ��8888�˿ڴ���һ���鲥�õ�Socket
				InetAddress group = InetAddress.getByName("226.1.1.6");
				// �γ��鲥��ַ
				msocket.joinGroup(group);
				// ������飬�����ɽ��յ������еİ�
				DatagramPacket rdp = null;
				byte[] rbuf = new byte[1024];
				boolean more = true;
				f.addWindowListener(new WindowAdapter() {	// �رմ���
					public void windowClosing(WindowEvent arg0) {
						System.exit(0);
					}
				});
				do {
					rdp = new DatagramPacket(rbuf, 1024);
					msocket.receive(rdp);					// �ȴ��������а�
					// ȡ��������������
					String data = new String(rdp.getData(), rdp.getOffset(), rdp.getLength());
					list.append(data+"\n");
				} while (more); 
				msocket.leaveGroup(group); 				// �뿪����
				msocket.close(); 						// �ر�Socket
			}
		}

