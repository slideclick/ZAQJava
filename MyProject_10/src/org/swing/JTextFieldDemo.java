package org.swing;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	public class JTextFieldDemo extends JFrame{
		static JTextField tf1 = new JTextField();
		static JTextField tf2 = new JTextField();
		static JTextField tf3 = new JTextField();	
		public JTextFieldDemo(){
			Container contentPane = getContentPane();		// 返回此窗体的 contentPane 对象	
			contentPane.setLayout(null);					// 取消布局管理器
			contentPane.setBackground(Color.cyan);		// 设置窗口的颜色
			setLocation(300, 300);
			setSize(new Dimension(300, 200));
			JLabel l1 = new JLabel("第一个数");
			JLabel l2 = new JLabel("第二个数");
			JLabel l3 = new JLabel("所求的数");
			Button bt1 = new Button("求公约数和公倍数");
			bt1.setBackground(Color.cyan);
			bt1.addActionListener(new NumAction());					// 注册事件监听器
			bt1.setBounds(new Rectangle(80, 120, 120, 25));
			l1.setBounds(new Rectangle(30, 20, 60, 25));
			l2.setBounds(new Rectangle(120, 20, 60, 25));
			l3.setBounds(new Rectangle(210, 20, 120, 25));
			tf1.setBounds(new Rectangle(30, 50, 70, 25));
			tf2.setBounds(new Rectangle(120, 50, 70, 25));
			tf3.setBounds(new Rectangle(210, 50, 70, 25));
			tf3.setEditable(false);
			setVisible(true);										// 设置窗体可见
			contentPane.add(l1);contentPane.add(l2);contentPane.add(l3);
			contentPane.add(bt1);
			contentPane.add(tf1);contentPane.add(tf2);contentPane.add(tf3);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// 关闭窗口
		}
		public static void main(String[] args) {
			JTextFieldDemo fd = new JTextFieldDemo();
		}
	}
	class NumAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int m ,n, r =0;
			int gcd = 0;										// 最大公约数
			int lcm =0;										// 最小公倍数
			m = Integer.parseInt(JTextFieldDemo.tf1.getText());			// 把字符串转换为整型
			n = Integer.parseInt(JTextFieldDemo.tf2.getText());			
			lcm = m * n ;
			while((r=m%n)!=0){
				m = n;
				n =r;
			}
			gcd = n;
			lcm = lcm /gcd;
			String str1 = String.valueOf(gcd);						// 返回此字符串形式
			String str2 = String.valueOf(lcm);
			String s = str1+"   "+str2;
			JTextFieldDemo.tf3.setText(s);						// 设置第三个文本框的内容
		}
	}

