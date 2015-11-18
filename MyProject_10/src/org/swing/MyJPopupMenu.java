package org.swing;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MyJPopupMenu extends JFrame {
		JMenu fileMenu;
		JPopupMenu jPopupMenuOne;
		JMenuItem openFile, closeFile, exit;
		JRadioButtonMenuItem copyFile, pasteFile;
		ButtonGroup buttonGroupOne;
		public MyJPopupMenu() {
			jPopupMenuOne = new JPopupMenu();		// ����jPopupMenuOne����
			buttonGroupOne = new ButtonGroup();
			// �����ļ��˵����Ӳ˵��������Ӳ˵���ӵ��ļ��˵���
			fileMenu = new JMenu("�ļ�");
			openFile = new JMenuItem("��");
			closeFile = new JMenuItem("�ر�");
			fileMenu.add(openFile);
			fileMenu.add(closeFile);
			jPopupMenuOne.add(fileMenu);			// ��fileMenu�˵���ӵ�����ʽ�˵���
			jPopupMenuOne.addSeparator();			// ��ӷָ��
			copyFile = new JRadioButtonMenuItem("����");
			pasteFile = new JRadioButtonMenuItem("ճ��");
			buttonGroupOne.add(copyFile);
			buttonGroupOne.add(pasteFile);
			jPopupMenuOne.add(copyFile);			// ��copyFile��ӵ�jPopupMenuOne��
			jPopupMenuOne.add(pasteFile);			// ��pasteFile��ӵ�jPopupMenuOne��
			jPopupMenuOne.addSeparator();
			exit = new JMenuItem("�˳�");
			jPopupMenuOne.add(exit);				// ��exit��ӵ�jPopupMenuOne��
			MouseListener popupListener = new PopupListener(jPopupMenuOne);
			this.addMouseListener(popupListener);		// ��������ע�������
			this.setTitle("This is a JPopupMenu");
			this.setBounds(100, 100, 250, 150);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public static void main(String args[]) {
			new MyJPopupMenu();
		}
		//***********����ڲ��࣬����չ��MouseAdapter�࣬������������¼�**********
		class PopupListener extends MouseAdapter {
			JPopupMenu popupMenu;
			PopupListener(JPopupMenu popupMenu) {
				this.popupMenu = popupMenu;
			}
			public void mousePressed(MouseEvent e) {
				showPopupMenu(e);
			}
			public void mouseReleased(MouseEvent e) {
				showPopupMenu(e);
			}
			private void showPopupMenu(MouseEvent e) {
				if (e.isPopupTrigger()) {			// �����ǰ�¼�������¼���أ��򵯳��˵�
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}		
			}
		} 
}

