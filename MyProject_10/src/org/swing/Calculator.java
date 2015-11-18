package org.swing;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	class MyFrame extends JFrame {
		public MyFrame() {
			setTitle("Calculator");
			MyPanel panel = new MyPanel();
			add(panel);
			pack(); 					// �����˼��������ڵĴ�С
		}
	}
	class MyPanel extends JPanel {
		private JButton display;			// ��ʾ������������ť��ֵ�ͼ�����ֵ			
		private JPanel panel;								// ���������
		private double result;	
		private String lastCommand;							// �����������ť
		private boolean start;								// �Ƿ�ʼ����
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
			// �����񲼾ֹ���������16����������ť��
			panel = new JPanel();
			panel.setLayout(new GridLayout(4, 4));				// ��JPanel����16����������ť
			addButton("7", insert);							// �Ѽ�������ť�ӵ������������
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
		//*********��Ӽ�������ť�������������**********************
		private void addButton(String label, ActionListener listener) {
			JButton button = new JButton(label);
			button.addActionListener(listener); 				// ע���¼�������
			panel.add(button);
		}
		// ���� display��ֵΪ������ļ�������ť��ֵ
		private class InsertAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				// ������˶�����ص������ַ�����
				String input = event.getActionCommand(); 		
				if (start) {
					display.setText("");
					start = false;
				}
				display.setText(display.getText() + input);		// ��ʾ�����ļ�������ť��ֵ
			}
		}
		//*********�������������ϵ�����ִ������********************
		private class CommandAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				String command = event.getActionCommand();
				if (start) {
					if (command.equals("-")) {
						display.setText(command);			// ���������ǡ�-����ť��˵��
						start = false;
					} else
						lastCommand = command;				
				} else {
					// ���ַ���ת��ΪDouble���Ͳ�������
					calculate(Double.parseDouble(display.getText())); 										
					lastCommand = command;
					start = true;
				}
			}
		}
		// **********������********************************
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
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// �رռ���������
			frame.setVisible(true);
		}
	}
