package org.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JListTest {
		JFrame f = new JFrame("JList���÷�");
		JPanel p1 = new JPanel(new FlowLayout());			// ������ʽ���ֹ�����
		JPanel p2 = new JPanel(new GridLayout(1, 2, 10, 5));
		JList l1 = new JList();
		JList l2 = new JList();
		JTextField jtf = new JTextField(12);
		JToggleButton b1 = new JToggleButton("����", false);
		JToggleButton b2 = new JToggleButton("����", false);
		Font ft = new Font("Serif", Font.BOLD, 18);
		public static void main(String args[]) {
			JListTest that = new JListTest();
			that.go();
		}
		void go() {
			f.getContentPane().add("North", p1);				// ������p1�ӵ����ڵı���
			p1.add(jtf);							
			p1.add(b1);
			p1.add(b2);
			f.getContentPane().add("Center", p2);				// ������p2�ӵ����ڵ�����
			p2.add(l1);
			p2.add(l2);
			jtf.setFont(ft);								// ��������
			b1.setFont(ft);
			b2.setFont(ft);
			b1.setToolTipText("�����б༭���е����ݼӵ�����б����");
			b2.setToolTipText("������б���е����ݸ��Ƶ��ұ��б����");
			l1.setFont(ft);
			l2.setFont(ft);
			b1.addActionListener(new ButtonH(1));				// ע�������
			b2.addActionListener(new ButtonH(2));
			f.setLocation(300, 500);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// �رմ���
			f.setSize(400, 300);
			f.setResizable(true);
			f.setVisible(true);
		}
		public class ButtonH implements ActionListener {			// ʵ�ּ�����
			int sel;
			ButtonH(int select) {
				sel = select;
			}
			public void actionPerformed(ActionEvent e) {
				if (sel == 1) {
					int num = l1.getModel().getSize();				// ����б��l1�е���Ŀ��
					String data[] = new String[num + 1];
					for (int i = 0; i < num; i++)
						data[i] = (String) l1.getModel().getElementAt(i);
					data[num] = jtf.getText();
					l1.setListData(data);
					b1.setSelected(false);
				}
				if (sel == 2){
					String data[] = new String[l1.getModel().getSize()];
			for (int i = 0; i < l1.getModel().getSize(); i++)
						data[i] = (String) l1.getModel().getElementAt(i);	//ǿ������ת��
					l2.setListData(data);
					b2.setSelected(false);
				}
			}
		}
}

