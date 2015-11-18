package org.swing;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	public class JMenuTest {
		JFrame f = new JFrame("Swing菜单的用法");
		JLabel stat = new JLabel("这里是状态栏");
		Font ft = new Font("Serif", Font.BOLD, 18);
		JLabel l1 = new JLabel("这里是西方", JLabel.CENTER);
		JLabel l2 = new JLabel("这里是中央", JLabel.CENTER);
		JLabel l3 = new JLabel("这里是东方", JLabel.CENTER);
		JPanel pc = new JPanel();
		CardLayout c = new CardLayout();			// 创建一个布局管理器CardLayout的对象c
		JMenuBar menubar1 = new JMenuBar();		// 创建一个菜单条
		JMenu menu1 = new JMenu("视图");			// 定义一个菜单对象menu1，其标题为“视图”
		JMenu menu2 = new JMenu("编辑");
		// 定义一个菜单项JMenuItem的对象	mitm1，其标题为"西方"
		JMenuItem mitm1 = new JMenuItem("西方");	
		JMenuItem mitm2 = new JMenuItem("中央");
		JMenuItem mitm3 = new JMenuItem("东方");
		JMenuItem mitm4 = new JMenuItem("剪下");
		JMenuItem mitm5 = new JMenuItem("粘贴");
		// 定义一个菜单项JCheckBoxMenuItem的对象mitm6，其标题为"状态栏"，选中
		JCheckBoxMenuItem mitm6 = new JCheckBoxMenuItem("状态栏", true);							JMenuItem mitm7 = new JMenuItem("退出");
		public static void main(String args[]) {
			JMenuTest that = new JMenuTest();
			that.go();
		}
		public void go() {
			f.setSize(350, 300);
			menubar1.add(menu1);			// 添加 menu1 到 MenuBar 中
			menubar1.add(menu2);
			menu1.add(mitm1);
			menu1.add(mitm2);
			// 为菜单项mitm1添加快捷键Shift-O
			mitm1.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.SHIFT_MASK,false));					mitm2.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK
					+ KeyEvent.SHIFT_MASK, false));	// 为菜单项mitm2添加快捷键Ctrl+Shift-S
			menu1.add(mitm3);
			menu1.addSeparator();				// 添加一条分隔线
			menu1.add(mitm6);
			menu1.addSeparator();
			menu1.add(mitm7);
			mitm7.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_MASK,
					false));				// 为菜单项mitm7添加快捷键Ctrl -X
			menu2.add(mitm4);
			menu2.add(mitm5);
			f.setJMenuBar(menubar1);			// 设定窗口f的菜单条为menubar1
			f.getContentPane().add("Center", pc);	// 将容器pc加到窗口f的中央
			f.getContentPane().add("South", stat);	// 将标签stat加到窗口f的底部
			pc.setLayout(c);
			pc.add(l1, "west");
			pc.add(l2, "center");
			pc.add(l3, "east");
			// 将菜单项mitm1注册到监听器JMenuHandler上，参数1代表mitm1
			mitm1.addActionListener(new JMenuHandler(1));	
			mitm2.addActionListener(new JMenuHandler(2));	
			mitm3.addActionListener(new JMenuHandler(3));
			mitm4.addActionListener(new JMenuHandler(4));
			mitm5.addActionListener(new JMenuHandler(5));
			mitm7.addActionListener(new JMenuHandler(7));
			// JCheckBoxMenuItem不响应ActionEvent事件，这里用ItemEvent事件
			mitm6.addItemListener(new JMenuDisp());												f.addWindowListener(new WinHandler());
			l1.setFont(ft);									// 设置菜单字体
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
				//若菜单项被选择，即前面有一个标记，则将标签stat置为可见,否则置为不可见
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
					c.show(pc, "west");		// 若选择了mitm1，则显示名为west的卡片
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
				stat.setText("你选择的菜单项是：" + e.getActionCommand());
			}
		}
		class WinHandler extends WindowAdapter {
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		}
	}

