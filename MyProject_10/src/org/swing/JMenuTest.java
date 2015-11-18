package org.swing;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	public class JMenuTest {
		JFrame f = new JFrame("Swing�˵����÷�");
		JLabel stat = new JLabel("������״̬��");
		Font ft = new Font("Serif", Font.BOLD, 18);
		JLabel l1 = new JLabel("����������", JLabel.CENTER);
		JLabel l2 = new JLabel("����������", JLabel.CENTER);
		JLabel l3 = new JLabel("�����Ƕ���", JLabel.CENTER);
		JPanel pc = new JPanel();
		CardLayout c = new CardLayout();			// ����һ�����ֹ�����CardLayout�Ķ���c
		JMenuBar menubar1 = new JMenuBar();		// ����һ���˵���
		JMenu menu1 = new JMenu("��ͼ");			// ����һ���˵�����menu1�������Ϊ����ͼ��
		JMenu menu2 = new JMenu("�༭");
		// ����һ���˵���JMenuItem�Ķ���	mitm1�������Ϊ"����"
		JMenuItem mitm1 = new JMenuItem("����");	
		JMenuItem mitm2 = new JMenuItem("����");
		JMenuItem mitm3 = new JMenuItem("����");
		JMenuItem mitm4 = new JMenuItem("����");
		JMenuItem mitm5 = new JMenuItem("ճ��");
		// ����һ���˵���JCheckBoxMenuItem�Ķ���mitm6�������Ϊ"״̬��"��ѡ��
		JCheckBoxMenuItem mitm6 = new JCheckBoxMenuItem("״̬��", true);							JMenuItem mitm7 = new JMenuItem("�˳�");
		public static void main(String args[]) {
			JMenuTest that = new JMenuTest();
			that.go();
		}
		public void go() {
			f.setSize(350, 300);
			menubar1.add(menu1);			// ��� menu1 �� MenuBar ��
			menubar1.add(menu2);
			menu1.add(mitm1);
			menu1.add(mitm2);
			// Ϊ�˵���mitm1��ӿ�ݼ�Shift-O
			mitm1.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.SHIFT_MASK,false));					mitm2.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK
					+ KeyEvent.SHIFT_MASK, false));	// Ϊ�˵���mitm2��ӿ�ݼ�Ctrl+Shift-S
			menu1.add(mitm3);
			menu1.addSeparator();				// ���һ���ָ���
			menu1.add(mitm6);
			menu1.addSeparator();
			menu1.add(mitm7);
			mitm7.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_MASK,
					false));				// Ϊ�˵���mitm7��ӿ�ݼ�Ctrl -X
			menu2.add(mitm4);
			menu2.add(mitm5);
			f.setJMenuBar(menubar1);			// �趨����f�Ĳ˵���Ϊmenubar1
			f.getContentPane().add("Center", pc);	// ������pc�ӵ�����f������
			f.getContentPane().add("South", stat);	// ����ǩstat�ӵ�����f�ĵײ�
			pc.setLayout(c);
			pc.add(l1, "west");
			pc.add(l2, "center");
			pc.add(l3, "east");
			// ���˵���mitm1ע�ᵽ������JMenuHandler�ϣ�����1����mitm1
			mitm1.addActionListener(new JMenuHandler(1));	
			mitm2.addActionListener(new JMenuHandler(2));	
			mitm3.addActionListener(new JMenuHandler(3));
			mitm4.addActionListener(new JMenuHandler(4));
			mitm5.addActionListener(new JMenuHandler(5));
			mitm7.addActionListener(new JMenuHandler(7));
			// JCheckBoxMenuItem����ӦActionEvent�¼���������ItemEvent�¼�
			mitm6.addItemListener(new JMenuDisp());												f.addWindowListener(new WinHandler());
			l1.setFont(ft);									// ���ò˵�����
			l2.setFont(ft);
			l3.setFont(ft);
			stat.setFont(ft);
			menu1.setFont(ft);
			menu2.setFont(ft);
			mitm1.setFont(ft);
			mitm2.setFont(ft);
			mitm3.setFont(ft);
			mitm4.setFont(ft);
			mitm5.setFont(ft);
			mitm6.setFont(ft);
			mitm7.setFont(ft);
			f.setVisible(true);
		}
		class JMenuDisp implements ItemListener {
			public void itemStateChanged(ItemEvent e) {
				//���˵��ѡ�񣬼�ǰ����һ����ǣ��򽫱�ǩstat��Ϊ�ɼ�,������Ϊ���ɼ�
				if (mitm6.getState())																	stat.setVisible(true);
				else
					stat.setVisible(false);
			}
		}
		class JMenuHandler implements ActionListener {
			private int ch;
			JMenuHandler(int select) {
				ch = select;
			}
			public void actionPerformed(ActionEvent e) {
				switch (ch) {
				case 1:	
					c.show(pc, "west");		// ��ѡ����mitm1������ʾ��Ϊwest�Ŀ�Ƭ
					break;
				case 2:
					c.show(pc, "center");
					break;
				case 3:
					c.show(pc, "east");
					break;
				case 4:
				case 5:
					break;
				case 7:
					System.exit(-1);
				}
				stat.setText("��ѡ��Ĳ˵����ǣ�" + e.getActionCommand());
			}
		}
		class WinHandler extends WindowAdapter {
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		}
	}

