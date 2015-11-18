package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	public class MultiplyOperation extends Frame {
		TextField num1;
		TextField num2;
		TextField sum;
		static Choice ch = new Choice();							// ���������б��
		public static void main(String[] args) {
			MultiplyOperation test = new MultiplyOperation();
			test.operation();
			test.setBackground(Color.cyan); 						// ���ô������ɫ
			test.setSize(280, 150); 							// ���ô����λ��
			test.addWindowListener(new WindowHandler3());			// ע���¼�������
		}
		public void operation() {
			num1 = new TextField();
			num2 = new TextField();
			sum = new TextField();
			ch.add("+");
			ch.add("-");
			ch.add("*");
			ch.add("/");
			num1.setColumns(5); 								// ���ô��ı��������
			num2.setColumns(5);
			sum.setColumns(5);
			setLayout(new FlowLayout());						// ������ʽ���ֹ�����
			Button btnEqual = new Button("=");
			btnEqual.setBackground(Color.cyan);
			btnEqual.addActionListener(new MyListener1(this));		// ע���¼�������
			ch.addItemListener(new ChoiceHandler()); 				// ע���¼�������
			add(num1); 									// ���ı�����뵽������
			add(ch);
			add(num2);						
			add(btnEqual);
			add(sum);
			setVisible(true); 									// ���ô���ɼ�		
		}
	}
	class MyListener1 implements ActionListener {
		private MultiplyOperation mulp;
		public MyListener1(MultiplyOperation mulp) {
			this.mulp = mulp;
		}
		public void actionPerformed(ActionEvent e) {
			String s1 = mulp.num1.getText();						// ��ȡ�ı����е�����
			String s2 = mulp.num2.getText();
			int i1 = Integer.parseInt(s1);							// ���ַ�������ת��Ϊ����
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
			itm = MultiplyOperation.ch.getSelectedItem();			// ��ȡ��ѡ�������
		}
	}
	class WindowHandler3 extends WindowAdapter {			
		public void windowClosing(WindowEvent e) {				// �رմ���
			System.exit(-1);				
		}
	}

