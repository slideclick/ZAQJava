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
			ta.append("�ӿͻ��˽��ܵ����ݣ�"+"\n");
			ServerSocket ss = null;
			try {
				ss = new ServerSocket(8800);					 // ����һ������Socket����
			} catch (BindException e) {
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Frame f = new Frame("��������");
			f.setLocation(300, 300);
			f.setSize(200, 200);								
			f.add(ta, BorderLayout.NORTH);
			f.pack();
			f.addWindowListener(new WindowAdapter() {			// �رմ���
				public void windowClosing(WindowEvent e) {		
					System.exit(0);
				}
			});
			f.setVisible(true);								// ���ô���ɼ�
			try {
				started = true;
				while (started) {
					boolean bConnected = false;
					s = ss.accept();							// �ȴ��ͻ�����������
					bConnected = true;
					dis = new DataInputStream(s.getInputStream());	
					while (bConnected) {
						String str = dis.readUTF();				// ���������ж�ȡ����
						str.length();
						ta.append(str+",�ַ������ȣ�"+str.length()+"\n");					// ��������ӵ��ı�����
					}
				}
			} catch (EOFException e) {
				System.out.println("Client closed!");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (dis != null)
						dis.close();							// �ر� ������
					if (s != null)
						s.close();							// �ر�Socket����
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
