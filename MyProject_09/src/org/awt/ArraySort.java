package org.awt;
	import java.awt.*;
	import java.util.Arrays;
	import java.util.regex.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	public class ArraySort extends Frame implements ActionListener{
		static TextArea ta1 = new TextArea();
		static TextArea ta2 = new TextArea();
		static Button bt1 = new Button("����ǰ");
		static Button bt2 = new Button("�����");
		public static void main(String[] args) {
			ArraySort as = new ArraySort();
			as.setLayout(null);							// ȡ�����ֹ�����
			as.setBackground(Color.cyan);
			as.setSize(300, 200);
			as.setVisible(true);
			ta1.setBounds(70, 40, 220, 70);
			ta2.setBounds(70,120,220,70);
			as.add(ta1);
			bt1.setBounds(10,60,50,30);
			bt2.setBounds(10,140,50,30);
			bt1.setBackground(Color.cyan);
			bt2.setBackground(Color.cyan);
			as.add(bt1);
			as.add(bt2);
			bt2.addActionListener(as);					// ע���¼�������
			as.add(ta2);
		}
		public void actionPerformed(ActionEvent e) {
			String s = ta1.getText();
			int[] arr = new int[10];						// ����1����������
			Pattern p = Pattern.compile("(\\d{1,4})");		// ����������ʽ
			Matcher m = p.matcher(s);						// ���ַ�������ƥ��
			int i =0; 
			while(m.find()) {								// Ѱ����ָ��ģʽƥ�����һ��������
				int j = 0;
				j = Integer.parseInt(m.group());			// ���ַ�������ת��Ϊ����
				arr[i]= j;
				i++;
			}
			Arrays.sort(arr);								// �������������
			for(int c = 0;c<i;c++){ 
				String str1 = String.valueOf(arr[c]);
				ta2.append(str1+"   ");						// �������е�����������ı�����
			}
		}
	}

