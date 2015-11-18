package org;
	import java.io.*;
	import java.net.*;
	import java.awt.*;
	import java.awt.event.*;
	public class UDPServer {
		public static void main(String[] args) throws Exception {
			DatagramSocket ds = new DatagramSocket(9777);		// ��9777�˿��ϴ���UDPSocket
			Frame f = new Frame("UDPServer");
			f.setLocation(400, 300);
			f.setSize(300, 300);
			TextField tf = new TextField(40);
			TextArea list = new TextArea();
			f.add(list, BorderLayout.NORTH);
			f.pack();
			f.setVisible(true);
			f.addWindowListener(new WindowAdapter() {		// �رմ���
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			byte[] buf = new byte[1024];						// ���ջ�����
			DatagramPacket dp = null; 						// ����UDP���ݰ�
			DatagramPacket sdp = null; 						// ����UDP���ݰ�
			boolean more = true; 							// ����UDP������
			while (more) {
				dp = new DatagramPacket(buf, 1024); 			// ����һ�����ڽ��յ�UDP���ݰ�
				ds.receive(dp); 							// �ȴ���һ���ͻ��������ݰ�
				InetAddress caddr = dp.getAddress(); 			// ��ȡ�ͻ�����IP��ַ
				int cport = dp.getPort();			 		// ��ȡ�ͻ����Ķ˿ں�
				// ��ȡ�ͻ������͵��ı�����
				String s = new String(dp.getData(), dp.getOffset(), dp.getLength());
				String str = "�ͻ��� IP: " + caddr + " �ͻ����˿ںţ�" + cport+ "\n"
						+ "  �ͻ������͵������ǣ�" + s + " \n";
				list.append(str);
				String rs = new String("�ַ�����" + s + " �ĳ����ǣ�" + s.length());
				byte[] sbuf = rs.getBytes();					// ����ת�����ֽ�����
				// ����һ�����ͻ��ض��ͻ�����UDP���ݰ���DatagramPacket����
				sdp = new DatagramPacket(sbuf, sbuf.length, caddr, cport);
				ds.send(sdp); 							// ��ͻ���������Ӧ��Ϣ
			}
		}
	}

