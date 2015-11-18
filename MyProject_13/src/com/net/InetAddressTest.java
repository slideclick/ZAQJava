package com.net;
	import java.net.*;
	import java.awt.*;
	import java.awt.event.*;
	public class InetAddressTest {
		static TextField tf1 = new TextField(40);
		static List list = new List(6);
		public static void main(String[] args) throws Exception {
			Frame f = new Frame();
			f.add(list);
			f.setSize(300, 300);						// ���ô���Ĵ�С
			Panel p = new Panel();
			p.setLayout(new BorderLayout());				// ���ñ߽粼�ֹ�����
			tf1.addActionListener(new MyListener());		// ע���¼�������
			p.add("West", tf1);
			f.add("South", p);
			f.addWindowListener(new WindowAdapter() { 	// �رմ���
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			f.setVisible(true);						// ���ô���ɼ�
		}
	}
	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = InetAddressTest.tf1.getText();			// ��ȡ�ı����е�����
			InetAddress[] addr;
			InetAddress addr2;
			try {
				InetAddressTest.list.removeAll();			// ���б���е�ԭ���������
				addr = InetAddress.getAllByName(s);		// ��������������Ӧ������IP��ַ
				addr2 = InetAddress.getLocalHost();
				for (int i = 0; i < addr.length; i++) {
					InetAddressTest.list.add(addr[i].toString());	// ��ӵ��б����
				}
				InetAddressTest.list.add(addr2.toString());	// ������������IP��ַ��ӵ��б����
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			((TextField) e.getSource()).setText(null);		// �����ı��������Ϊ��
		}
	}
