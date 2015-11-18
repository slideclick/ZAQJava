package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	public class EventAdapter{
		public static Button bt1 = new Button("红色");
		public static Button bt2 = new Button("绿色");
		public static Button bt3 = new Button("蓝色");
		public static void main(String[] args) {
			Frame f = new Frame();
			f.setBackground(Color.cyan);
			f.setSize(new Dimension(330, 250));	
			f.setLayout(null);							// 取消窗口布局管理器
			bt1.setBackground(Color.red);
			bt1.setBounds(new Rectangle(45, 180, 70, 25));
			bt3.setBackground(Color.blue);
			bt2.setBounds(new Rectangle(135, 180, 70, 25));
			bt2.setBackground(Color.green);
			bt3.setBounds(new Rectangle(220, 180, 70, 25));
			ActionListener insert = new InsertAction();
			f.setLocation(300,300);	
			f.add(bt2);
			f.add(bt1);
			f.add(bt3);
			f.addWindowListener(new WindowHandler1());
			f.setVisible(true);
			bt1.addActionListener(insert);					// 注册事件监听器
			bt2.addActionListener(insert);
			bt3.addActionListener(insert);
		}
	}
	//********方法windowClosing就是当窗口关闭时的处理动作**********
	class WindowHandler1 extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(1);								// 关闭窗口
		} 
	}
	class InsertAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String input = event.getActionCommand(); 			// 返回与此动作相关的命令字符串
			if(input.equals("红色")){
				EventAdapter.bt1.setBackground(Color.red);
				EventAdapter.bt2.setBackground(Color.red);
				EventAdapter.bt3.setBackground(Color.red);
			}
			else if(input.equals("绿色")) {
				EventAdapter.bt1.setBackground(Color.green);
				EventAdapter.bt2.setBackground(Color.green);
				EventAdapter.bt3.setBackground(Color.green);
			}
			else {
				EventAdapter.bt1.setBackground(Color.blue);
				EventAdapter.bt2.setBackground(Color.blue);
				EventAdapter.bt3.setBackground(Color.blue);
			}
		}
	}

