package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	public class TestEvent {
		static JButton bt = new JButton("���ذ�ť");
		public static void main(String[] args) {
			Frame f = new Frame();
			f.setLocation(300, 200);
			f.setSize(200,200);
			f.setLayout(null);						// ȡ�����ֹ�����
			bt.addMouseListener(new MouseMove());		// ע������¼�������
			bt.setBackground(Color.cyan);
			bt.setBounds(new Rectangle(45, 100, 90, 30));
			f.add(bt);
			f.pack();
			f.addWindowListener(new WindowAdapter() {	// �رմ���
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			f.setVisible(true);						// ���ô���ɼ�
		}
	}
	class MouseMove extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {			// ��굥��Button��ť����ť���ɼ�
			TestEvent.bt.setVisible(false);
		}
		public void mouseExited(MouseEvent e) {			// ����ƿ�Button��ť����ť����
			TestEvent.bt.setVisible(true);
		}
	}
