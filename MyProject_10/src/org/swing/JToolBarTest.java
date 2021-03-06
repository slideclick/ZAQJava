package org.swing;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	public class JToolBarTest {
		JFrame f = new JFrame("工具栏JToolBar");
		JLabel stat = new JLabel("这里是状态栏");
		Font ft = new Font("Serif", Font.BOLD, 18);
		JLabel l1 = new JLabel("这里是西方", JLabel.CENTER);
		JLabel l2 = new JLabel("这里是中央", JLabel.CENTER);
		JLabel l3 = new JLabel("这里是东方", JLabel.CENTER);
		JPanel pc = new JPanel();
		CardLayout c = new CardLayout();
		JMenuBar menubar1 = new JMenuBar();
		JMenu menu1 = new JMenu("视图");
		JMenu menu2 = new JMenu("编辑");
		JMenuItem mitm1 = new JMenuItem("西方");
		JMenuItem mitm2 = new JMenuItem("中央");
		JMenuItem mitm3 = new JMenuItem("东方");
		JMenuItem mitm4 = new JMenuItem("剪下");
		JMenuItem mitm5 = new JMenuItem("粘贴");
		JCheckBoxMenuItem mitm6 = new JCheckBoxMenuItem("状态栏", true);
		JMenuItem mitm7 = new JMenuItem("退出");
		JPopupMenu pmenu;
		JToolBar jtb = new JToolBar();			// 定义一个工具栏JToolBox对象jtb
		Icon c1 =new ImageIcon(getClass().getResource("1.gif"));	// 定义工具栏按钮上的图片
		Icon c2 =new ImageIcon(getClass().getResource("2.gif"));
		Icon c3 =new ImageIcon(getClass().getResource("3.gif"));
		Icon c4 =new ImageIcon(getClass().getResource("4.gif"));
		Icon c5 =new ImageIcon(getClass().getResource("5.gif"));
		Icon c7 =new ImageIcon(getClass().getResource("6.gif"));
		JButton btn1 = new JButton(c1);
		// 定义工具栏上的按钮
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
			pmenu = menu1.getPopupMenu();			// 将菜单menu1作为弹出式菜单pmenu
			menubar1.add(menu1);menubar1.add(menu2);
			menu1.add(mitm1);menu1.add(mitm2);
			mitm1.setAccelerator(KeyStroke.getKeyStroke('O',
					KeyEvent.SHIFT_MASK,false));		// 为菜单项mitm1添加快捷键Shift-O
			mitm2.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK
					+ KeyEvent.SHIFT_MASK, true));	// 为菜单项mitm2添加快捷键Ctrl+Shift-S
			menu1.add(mitm3);menu1.addSeparator();
			menu1.add(mitm6);menu1.addSeparator();menu1.add(mitm7);
			mitm7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,
					KeyEvent.CTRL_MASK, false));		// 为菜单项mitm7添加快捷键Ctrl -F1
			menu2.add(mitm4);menu2.add(mitm5);
			f.setJMenuBar(menubar1);
			f.getContentPane().add("Center", pc);
			f.getContentPane().add("South", stat);
			pc.setLayout(c);
			pc.add(l1, "west");pc.add(l2, "center");pc.add(l3, "east");
			f.getContentPane().add("North", jtb);			// 将工具栏jtb加到窗口f的北部区域
			jtb.add(btn1);							// 在工具栏上添加按钮
			jtb.add(btn2);jtb.add(btn3);
			jtb.addSeparator();
			jtb.add(btn4);jtb.add(btn5);
			jtb.addSeparator();jtb.add(btn7);
			btn1.setToolTipText("显示第一张");			// 给按钮添加提示信息
			btn2.setToolTipText("显示第二张");
			btn1.addActionListener(new JMenuHandler(1));//将按钮注册到监听器上，参数1表示按btn1
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
			// 将容器pc注册到监听器MouseH中，参数1表示容器p
			pc.addMouseListener(new MouseH(1));	
			// 将标签stat注册到监听器MouseH中，参数2表示不是容器pc
			stat.addMouseListener(new MouseH(2));	
			//将窗口f注册到监听器MouseH中，参数2表示不是容器pc					
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
				if (sel == 1){					// 当鼠标在容器pc上时
					// 若是鼠标右键，这里MouseEvent.META_MASK表示鼠标右键
					if (e.getModifiers() == MouseEvent.META_MASK){											int x1, y1;
						// 获得鼠标所在组件相对于屏幕的X轴位置
						x1 = (int) e.getComponent().getLocationOnScreen().getX();
						// 获得鼠标所在组件相对于屏幕的Y轴位置
						y1 = (int) e.getComponent().getLocationOnScreen().getY();	
						// 将弹出式菜单pmenu的位置设为鼠标所在位置
						pmenu.setLocation(x1 + e.getX(), y1 + e.getY());											pmenu.setVisible(true);	// 显示弹出式菜单pmenu
					} else
						pmenu.setVisible(false);	// 若不是鼠标右键，则隐藏弹出式菜单pmenu
				}
				if (sel == 2)					// 当鼠标不在容器pc上时
					pmenu.setVisible(false);		// 隐藏弹出式菜单pmenu
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
		class JMenuHandler implements ActionListener {	// 实现监听器
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
				stat.setText("你选择的菜单项是：" + e.getActionCommand());
			}
		}
	}
