package org.awt;
import java.awt.event.*;
	import java.awt.*;
	public class Key implements KeyListener {
		TextField tf = new TextField(20);
		TextArea ta1 = new TextArea("��ʾ���µļ�:\n", 7, 20);
		TextArea ta2 = new TextArea("��ʾ�ͷŵļ�:\n", 7, 20);
		TextArea ta3 = new TextArea("��ʾ�����빦�ܼ�:\n", 7, 20);
		TextArea ta4 = new TextArea(null, 2, 20);
		public void keyTyped(KeyEvent e) {				// ���İ������ͷ��¼�
			ta4.append(String.valueOf(e.getKeyChar()));		// ����ȡ���ַ����ͱ���д�뵽�ı�����
		}
		public void keyPressed(KeyEvent e) {				// ���İ����¼�
			ta1.append(String.valueOf(e.getKeyChar()));		
			ta3.append(e.getKeyText(e.getKeyCode()) + "\n");	// �����������ͱ���
		}
		public void keyReleased(KeyEvent e) {				// �����ͷ��¼�
			ta2.append(String.valueOf(e.getKeyChar()));
		}
		Key() {
			Frame f = new Frame();
			f.setBackground(Color.cyan);
			f.addWindowListener(new WindowAdapter() {	// �رմ���
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			f.setLayout(new FlowLayout());				// ʹ����ʽ���ֹ�����
			Panel p1 = new Panel();
			f.add(p1);
			p1.add(new Label("���ڴ˱༭���������ַ�: "));
			p1.add(tf);
			tf.addKeyListener(this);					// ע���¼�������
			Panel p2 = new Panel();
			f.add(p2);
			p2.add(ta1); p2.add(ta2); p2.add(ta3);
			Panel p3 = new Panel();
			f.add(p3);
			p3.add(new Label("��ʾ���²��ͷŵļ���: "));
			p3.add(ta4);
			f.setSize(500, 280);
			f.setVisible(true);
		}
		public static void main(String[] args) {
			new Key();
		}
	}

