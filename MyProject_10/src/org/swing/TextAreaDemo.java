package org.swing;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	public class TextAreaDemo extends JFrame {
			static JTextField tf1 = new JTextField();
			static JTextField tf2 = new JTextField();
			static JTextField tf3 = new JTextField();
			static TextArea ta = new TextArea(); 
			static JTextField tf4 = new JTextField();
			static int num = 0;	
			//*******显示滚动条**************
			JScrollPane jp = new JScrollPane(ta,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			public TextAreaDemo() {
				setBackground(Color.cyan);
				Container contentPane = getContentPane();
				contentPane.setLayout(null);							// 取消布局管理器
				contentPane.setBackground(Color.cyan);				// 设置窗口的颜色
				contentPane.add(jp);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// 关闭窗口
				setVisible(true);									// 使窗口可见
				setLocation(300, 300);
				setSize(new Dimension(500, 400));
				Button bt1 = new Button("求a到b之间的质数");
				bt1.setBackground(Color.cyan);
				bt1.addActionListener(new GetAction()); 				// 注册事件监听器
				Button bt2 = new Button("质数个数");
				bt2.setBackground(Color.cyan);
				JLabel l1 = new JLabel("输入a的值");
				JLabel l2 = new JLabel("输入b的值");
				JLabel l3 = new JLabel("每行显示个数");
				tf1.setBounds(new Rectangle(40, 50, 70, 25));
				tf2.setBounds(new Rectangle(130, 50, 70, 25));
				tf3.setBounds(new Rectangle(220, 50, 70, 25));
				ta.setEditable(true);
				ta.setText("");
				ta.setBackground(Color.white);						// 设置文本区的颜色
				ta.setBounds(new Rectangle(40, 100, 400, 200));
				l1.setBounds(new Rectangle(40, 20, 60, 25));
				l2.setBounds(new Rectangle(130, 20, 60, 25));
				l3.setBounds(new Rectangle(220, 20, 120, 25));
				bt1.setBounds(new Rectangle(340, 20, 120, 25));
				bt2.setBounds(new Rectangle(40, 330, 50, 25));
				tf4.setBounds(new Rectangle(130, 330, 70, 25));
				contentPane.add(l1);								// 加入组件
				contentPane.add(l2);
				contentPane.add(l3);
				contentPane.add(bt1);
				contentPane.add(bt2);
				contentPane.add(ta);
				contentPane.add(tf1);
				contentPane.add(tf2);
				contentPane.add(tf3);
				contentPane.add(tf4);
			}
			public static void main(String[] args) {
				TextAreaDemo test = new TextAreaDemo();
			}
		}
	class GetAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String text1 = TextAreaDemo.tf1.getText(); 			// 获取文本框中的内容
				String text2 = TextAreaDemo.tf2.getText();
				String text3 = TextAreaDemo.tf3.getText();
				int a, b, c;
				a = Integer.parseInt(text1); 						// 将字符串类型转换为整型
				b = Integer.parseInt(text2);
				c = Integer.parseInt(text3);
				boolean flag;
				int m, p, count = 0;
				for (m = a; m <= b; m++) {
					flag = true;
					for (p = 2; p <= m / 2; p++)
						if (m % p == 0) {						// 判断是否是质数
							flag = false;
							break;
						}
					if (flag) {
						String str = String.valueOf(m); 			// 将整型转换为字符串类型
						TextAreaDemo.ta.append(str + "    ");		// 将质数写入到文本区中
						count++;
						TextAreaDemo.num++;
						if (count % c == 0) { 					// 每行中只输出c个质数
							TextAreaDemo.ta.append("\n");
						}
					}
				}
				String str = String.valueOf(TextAreaDemo.num);
				TextAreaDemo.tf4.setText(str);
			}
	}

