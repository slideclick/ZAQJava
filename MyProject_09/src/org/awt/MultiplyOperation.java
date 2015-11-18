package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	public class MultiplyOperation extends Frame {
		TextField num1;
		TextField num2;
		TextField sum;
		static Choice ch = new Choice();							// 创建下拉列表框
		public static void main(String[] args) {
			MultiplyOperation test = new MultiplyOperation();
			test.operation();
			test.setBackground(Color.cyan); 						// 设置窗体的颜色
			test.setSize(280, 150); 							// 设置窗体的位置
			test.addWindowListener(new WindowHandler3());			// 注册事件监听器
		}
		public void operation() {
			num1 = new TextField();
			num2 = new TextField();
			sum = new TextField();
			ch.add("+");
			ch.add("-");
			ch.add("*");
			ch.add("/");
			num1.setColumns(5); 								// 设置此文本框的列数
			num2.setColumns(5);
			sum.setColumns(5);
			setLayout(new FlowLayout());						// 采用流式布局管理器
			Button btnEqual = new Button("=");
			btnEqual.setBackground(Color.cyan);
			btnEqual.addActionListener(new MyListener1(this));		// 注册事件监听器
			ch.addItemListener(new ChoiceHandler()); 				// 注册事件监听器
			add(num1); 									// 将文本框加入到窗体上
			add(ch);
			add(num2);						
			add(btnEqual);
			add(sum);
			setVisible(true); 									// 设置窗体可见		
		}
	}
	class MyListener1 implements ActionListener {
		private MultiplyOperation mulp;
		public MyListener1(MultiplyOperation mulp) {
			this.mulp = mulp;
		}
		public void actionPerformed(ActionEvent e) {
			String s1 = mulp.num1.getText();						// 获取文本框中的内容
			String s2 = mulp.num2.getText();
			int i1 = Integer.parseInt(s1);							// 将字符串类型转换为整型
			int i2 = Integer.parseInt(s2);
			String itm;
			itm = mulp.ch.getSelectedItem();
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
		public void itemStateChanged(ItemEvent e) {
			String itm;
			itm = MultiplyOperation.ch.getSelectedItem();			// 获取所选项的名称
		}
	}
	class WindowHandler3 extends WindowAdapter {			
		public void windowClosing(WindowEvent e) {				// 关闭窗口
			System.exit(-1);				
		}
	}

