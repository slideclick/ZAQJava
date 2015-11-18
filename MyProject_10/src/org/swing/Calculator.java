package org.swing;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	class MyFrame extends JFrame {
		public MyFrame() {
			setTitle("Calculator");
			MyPanel panel = new MyPanel();
			add(panel);
			pack(); 					// 调整此计算器窗口的大小
		}
	}
	class MyPanel extends JPanel {
		private JButton display;			// 显示单击计算器按钮的值和计算后的值			
		private JPanel panel;								// 计算器面板
		private double result;	
		private String lastCommand;							// 计算器的命令按钮
		private boolean start;								// 是否开始计算
		public MyPanel() {
			setLayout(new BorderLayout());
			result = 0;
			lastCommand = "=";
			start = true;
			display = new JButton("0");
			display.setEnabled(false);
			add(display, BorderLayout.NORTH);
			ActionListener insert = new InsertAction();
			ActionListener command = new CommandAction();
			// 以网格布局管理器管理16个计算器按钮，
			panel = new JPanel();
			panel.setLayout(new GridLayout(4, 4));				// 在JPanel布局16个计算器按钮
			addButton("7", insert);							// 把计算器按钮加到计算器面板上
			addButton("8", insert);
			addButton("9", insert);
			addButton("/", command);
			addButton("4", insert);
			addButton("5", insert);
			addButton("6", insert);
			addButton("*", command);
			addButton("1", insert);
			addButton("2", insert);
			addButton("3", insert);
			addButton("-", command);
			addButton("0", insert);
			addButton(".", insert);
			addButton("=", command);
			addButton("+", command);
			add(panel, BorderLayout.CENTER);
		}
		//*********添加计算器按钮到计算器面板上**********************
		private void addButton(String label, ActionListener listener) {
			JButton button = new JButton(label);
			button.addActionListener(listener); 				// 注册事件监听器
			panel.add(button);
		}
		// 设置 display的值为所点击的计算器按钮的值
		private class InsertAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				// 返回与此动作相关的命令字符串。
				String input = event.getActionCommand(); 		
				if (start) {
					display.setText("");
					start = false;
				}
				display.setText(display.getText() + input);		// 显示单击的计算器按钮的值
			}
		}
		//*********依单击计算器上的内容执行命令********************
		private class CommandAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				String command = event.getActionCommand();
				if (start) {
					if (command.equals("-")) {
						display.setText(command);			// 如果点击的是“-”按钮，说明
						start = false;
					} else
						lastCommand = command;				
				} else {
					// 把字符串转换为Double类型并计算结果
					calculate(Double.parseDouble(display.getText())); 										
					lastCommand = command;
					start = true;
				}
			}
		}
		// **********计算结果********************************
		public void calculate(double x) {
			if (lastCommand.equals("+"))
				result += x;
			else if (lastCommand.equals("-"))
				result -= x;
			else if (lastCommand.equals("*"))
				result *= x;
			else if (lastCommand.equals("/"))
				result /= x;
			else if (lastCommand.equals("="))
				result = x;
			display.setText("" + result);
		}
	}
	public class Calculator {
		public static void main(String[] args) {
			MyFrame frame = new MyFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// 关闭计算器窗口
			frame.setVisible(true);
		}
	}
