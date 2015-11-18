package org.swing;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	public class JToolBarTest {
		JFrame f = new JFrame("������JToolBar");
		JLabel stat = new JLabel("������״̬��");
		Font ft = new Font("Serif", Font.BOLD, 18);
		JLabel l1 = new JLabel("����������", JLabel.CENTER);
		JLabel l2 = new JLabel("����������", JLabel.CENTER);
		JLabel l3 = new JLabel("�����Ƕ���", JLabel.CENTER);
		JPanel pc = new JPanel();
		CardLayout c = new CardLayout();
		JMenuBar menubar1 = new JMenuBar();
		JMenu menu1 = new JMenu("��ͼ");
		JMenu menu2 = new JMenu("�༭");
		JMenuItem mitm1 = new JMenuItem("����");
		JMenuItem mitm2 = new JMenuItem("����");
		JMenuItem mitm3 = new JMenuItem("����");
		JMenuItem mitm4 = new JMenuItem("����");
		JMenuItem mitm5 = new JMenuItem("ճ��");
		JCheckBoxMenuItem mitm6 = new JCheckBoxMenuItem("״̬��", true);
		JMenuItem mitm7 = new JMenuItem("�˳�");
		JPopupMenu pmenu;
		JToolBar jtb = new JToolBar();			// ����һ��������JToolBox����jtb
		Icon c1 =new ImageIcon(getClass().getResource("1.gif"));	// ���幤������ť�ϵ�ͼƬ
		Icon c2 =new ImageIcon(getClass().getResource("2.gif"));
		Icon c3 =new ImageIcon(getClass().getResource("3.gif"));
		Icon c4 =new ImageIcon(getClass().getResource("4.gif"));
		Icon c5 =new ImageIcon(getClass().getResource("5.gif"));
		Icon c7 =new ImageIcon(getClass().getResource("6.gif"));
		JButton btn1 = new JButton(c1);
		// ���幤�����ϵİ�ť
		JButton btn2 = new JButton(c2);
		JButton btn3 = new JButton(c3);
		JButton btn4 = new JButton(c4);
		JButton btn5 = new JButton(c5);
		JButton btn7 = new JButton(c7);
		public static void main(String args[]) {
			JToolBarTest that = new JToolBarTest();
			that.go();
		}
		public void go() {
			f.setSize(350, 300);
			pmenu = menu1.getPopupMenu();			// ���˵�menu1��Ϊ����ʽ�˵�pmenu
			menubar1.add(menu1);menubar1.add(menu2);
			menu1.add(mitm1);menu1.add(mitm2);
			mitm1.setAccelerator(KeyStroke.getKeyStroke('O',
					KeyEvent.SHIFT_MASK,false));		// Ϊ�˵���mitm1��ӿ�ݼ�Shift-O
			mitm2.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK
					+ KeyEvent.SHIFT_MASK, true));	// Ϊ�˵���mitm2��ӿ�ݼ�Ctrl+Shift-S
			menu1.add(mitm3);menu1.addSeparator();
			menu1.add(mitm6);menu1.addSeparator();menu1.add(mitm7);
			mitm7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,
					KeyEvent.CTRL_MASK, false));		// Ϊ�˵���mitm7��ӿ�ݼ�Ctrl -F1
			menu2.add(mitm4);menu2.add(mitm5);
			f.setJMenuBar(menubar1);
			f.getContentPane().add("Center", pc);
			f.getContentPane().add("South", stat);
			pc.setLayout(c);
			pc.add(l1, "west");pc.add(l2, "center");pc.add(l3, "east");
			f.getContentPane().add("North", jtb);			// ��������jtb�ӵ�����f�ı�������
			jtb.add(btn1);							// �ڹ���������Ӱ�ť
			jtb.add(btn2);jtb.add(btn3);
			jtb.addSeparator();
			jtb.add(btn4);jtb.add(btn5);
			jtb.addSeparator();jtb.add(btn7);
			btn1.setToolTipText("��ʾ��һ��");			// ����ť�����ʾ��Ϣ
			btn2.setToolTipText("��ʾ�ڶ���");
			btn1.addActionListener(new JMenuHandler(1));//����ťע�ᵽ�������ϣ�����1��ʾ��btn1
			btn2.addActionListener(new JMenuHandler(2));
			btn3.addActionListener(new JMenuHandler(3));
			btn4.addActionListener(new JMenuHandler(4));
			btn5.addActionListener(new JMenuHandler(5));
			btn7.addActionListener(new JMenuHandler(7));
			mitm1.addActionListener(new JMenuHandler(1));
			mitm2.addActionListener(new JMenuHandler(2));
			mitm3.addActionListener(new JMenuHandler(3));
			mitm4.addActionListener(new JMenuHandler(4));
			mitm5.addActionListener(new JMenuHandler(5));
			mitm7.addActionListener(new JMenuHandler(7));
			mitm6.addItemListener(new JMenuDisp());
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// ������pcע�ᵽ������MouseH�У�����1��ʾ����p
			pc.addMouseListener(new MouseH(1));	
			// ����ǩstatע�ᵽ������MouseH�У�����2��ʾ��������pc
			stat.addMouseListener(new MouseH(2));	
			//������fע�ᵽ������MouseH�У�����2��ʾ��������pc					
			f.addMouseListener(new MouseH(2));		
			l1.setFont(ft);l2.setFont(ft);l3.setFont(ft);
			stat.setFont(ft);
			menu1.setFont(ft);menu2.setFont(ft);mitm1.setFont(ft);
			mitm2.setFont(ft);mitm3.setFont(ft);mitm4.setFont(ft);
			mitm5.setFont(ft);mitm6.setFont(ft);mitm7.setFont(ft);
			f.setVisible(true);
		}
		class MouseH extends MouseAdapter {
			int sel;
			MouseH(int select) {
				sel = select;
			}
			public void mouseClicked(MouseEvent e) {
				if (sel == 1){					// �����������pc��ʱ
					// ��������Ҽ�������MouseEvent.META_MASK��ʾ����Ҽ�
					if (e.getModifiers() == MouseEvent.META_MASK){											int x1, y1;
						// ��������������������Ļ��X��λ��
						x1 = (int) e.getComponent().getLocationOnScreen().getX();
						// ��������������������Ļ��Y��λ��
						y1 = (int) e.getComponent().getLocationOnScreen().getY();	
						// ������ʽ�˵�pmenu��λ����Ϊ�������λ��
						pmenu.setLocation(x1 + e.getX(), y1 + e.getY());											pmenu.setVisible(true);	// ��ʾ����ʽ�˵�pmenu
					} else
						pmenu.setVisible(false);	// ����������Ҽ��������ص���ʽ�˵�pmenu
				}
				if (sel == 2)					// ����겻������pc��ʱ
					pmenu.setVisible(false);		// ���ص���ʽ�˵�pmenu
			}
		}
		class JMenuDisp implements ItemListener {		
			public void itemStateChanged(ItemEvent e) {
				if (mitm6.getState())
					stat.setVisible(true);
				else
					stat.setVisible(false);
				pmenu.setVisible(false);
			}
		}
		class JMenuHandler implements ActionListener {	// ʵ�ּ�����
			private int ch;
			JMenuHandler(int select) {
				ch = select;
			}
			public void actionPerformed(ActionEvent e) {
				switch (ch) {
				case 1:
					c.show(pc, "west");
					pmenu.setVisible(false);
					break;
				case 2:
					c.show(pc, "center");
					pmenu.setVisible(false);
					break;
				case 3:
					c.show(pc, "east");
					pmenu.setVisible(false);
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
	}
