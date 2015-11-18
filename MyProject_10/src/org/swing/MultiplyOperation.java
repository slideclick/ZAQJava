package org.swing;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	public class MultiplyOperation extends JFrame{
		JTextField num1;
		JTextField num2;
		JTextField sum;
		static Choice ch = new Choice();
		public static void main(String[] args) {
			MultiplyOperation test = new MultiplyOperation();
			test.operation();
			test.getContentPane().setBackground(Color.cyan); 			// 设置窗体的颜色
			test.setSize(280, 150); 
			test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 关闭窗口
		}
		public void operation() {
			num1 = new JTextField();
			num2 = new JTextField();
			sum = new  JTextField();
			ch.add("+");
			ch.add("-");
			ch.add("*");
			ch.add("/");
			num1.setColumns(5); 								// 设置此文本框的列数
			num2.setColumns(5);
			sum.setColumns(5);
			setLayout(new FlowLayout()); 						// 采用流式布局管理器
			Button btnEqual = new Button("=");
			btnEqual.setBackground(Color.cyan);
			btnEqual.addActionListener(new MyListener(this));			// 注册事件监听器
			ch.addItemListener(new ChoiceHandler());				// 注册事件监听器
			add(num1);										// 将文本框加入到窗体上
			add(ch);
			add(num2);
			add(btnEqual);
			add(sum);
			setVisible(true); 									// 设置窗体可见
		}
	}
	class MyListener implements ActionListener {
		private MultiplyOperation mulp;
		public MyListener(MultiplyOperation mulp) {
			this.mulp = mulp;
		}
		public void actionPerformed(ActionEvent e) {
			String s1 = mulp.num1.getText();						// 获取文本框中的内容
			String s2 = mulp.num2.getText();
			int i1 = Integer.parseInt(s1);							// 将字符串类型转换为整型
			int i2 = Integer.parseInt(s2);
			String itm;
			itm = ChoiceHandler.itm1 ;								
			if (itm.equals("+")) {
				mulp.sum.setText(String.valueOf(i1 + i2));
			} else if (itm.equals("-")) {
				mulp.sum.setText(String.valueOf(i1 - i2));
			} else if (itm.equals("*")) {
				mulp.sum.setText(String.valueOf(i1 * i2));
			} else if (itm.equals("/")) {
				mulp.sum.setText(String.valueOf(i1 / i2));
			}
		}
	}
	class ChoiceHandler implements ItemListener {
		static String itm1;
		public void itemStateChanged(ItemEvent e) {
			itm1 = MultiplyOperation.ch.getSelectedItem();			// 获得所选项
		}
	}

