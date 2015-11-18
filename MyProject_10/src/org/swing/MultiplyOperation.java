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
			test.getContentPane().setBackground(Color.cyan); 			// ���ô������ɫ
			test.setSize(280, 150); 
			test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// �رմ���
		}
		public void operation() {
			num1 = new JTextField();
			num2 = new JTextField();
			sum = new  JTextField();
			ch.add("+");
			ch.add("-");
			ch.add("*");
			ch.add("/");
			num1.setColumns(5); 								// ���ô��ı��������
			num2.setColumns(5);
			sum.setColumns(5);
			setLayout(new FlowLayout()); 						// ������ʽ���ֹ�����
			Button btnEqual = new Button("=");
			btnEqual.setBackground(Color.cyan);
			btnEqual.addActionListener(new MyListener(this));			// ע���¼�������
			ch.addItemListener(new ChoiceHandler());				// ע���¼�������
			add(num1);										// ���ı�����뵽������
			add(ch);
			add(num2);
			add(btnEqual);
			add(sum);
			setVisible(true); 									// ���ô���ɼ�
		}
	}
	class MyListener implements ActionListener {
		private MultiplyOperation mulp;
		public MyListener(MultiplyOperation mulp) {
			this.mulp = mulp;
		}
		public void actionPerformed(ActionEvent e) {
			String s1 = mulp.num1.getText();						// ��ȡ�ı����е�����
			String s2 = mulp.num2.getText();
			int i1 = Integer.parseInt(s1);							// ���ַ�������ת��Ϊ����
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
			itm1 = MultiplyOperation.ch.getSelectedItem();			// �����ѡ��
		}
	}

