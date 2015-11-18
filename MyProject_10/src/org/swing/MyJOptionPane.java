package org.swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class MyJOptionPane {
	JFrame frame = new JFrame(" This is a JOptionPane");
	JPanel panel = new JPanel(new GridLayout(1, 3, 10, 10));
	JButton bt1 = new JButton("ȷ�϶Ի���");
	JButton bt2 = new JButton("����Ի���");
	JButton bt3 = new JButton("��Ϣ�Ի���");
	JLabel label = new JLabel("���ѡ���������", JLabel.CENTER);
	Font font = new Font("Serif", Font.BOLD, 18);
	public static void main(String args[]) {
		new MyJOptionPane().launch();
	}
	void launch() {
		frame.getContentPane().add("North", panel);
		panel.add(bt1);
		panel.add(bt2);
		panel.add(bt3);
		bt1.setFont(font);
		bt2.setFont(font);
		bt3.setFont(font);
		frame.getContentPane().add("Center", label);
		label.setFont(font);
		bt1.addActionListener(new ButtonMonitor(1));
		bt2.addActionListener(new ButtonMonitor(2));
		bt3.addActionListener(new ButtonMonitor(3));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setVisible(true);
	}
	class ButtonMonitor implements ActionListener {
		int sel;
		ButtonMonitor(int select) {
			sel = select;
		}
		public void actionPerformed(ActionEvent e) {
			if (sel == 1) {
				int n = JOptionPane.showConfirmDialog(null,
					"����һ��ȷ�϶Ի���! ����ֵ:\n0��ʾYes��1��ʾNo��2ѡ��Cancel",
					"ȷ�϶Ի�����÷�", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
				String choice;
				if (n == 0)
					choice = "Yes";
				else if (n == 1)
					choice = "No";
				else
					choice = "Cancel";
				label.setText("��ѡ����ǣ�" + choice);
			}
			if (sel == 2) {
				Object[] vals = { "Blue", "Yellow", "Brown", "Pink", "White" };
				String inpt = (String) JOptionPane.showInputDialog(null,
					"����һ������Ի���! ����ֵ��ʾ��������ѡ��","����Ի�����÷�",
					JOptionPane.QUESTION_MESSAGE, new ImageIcon("001.jpg"),
					vals, vals[2]);
				label.setText("��������ǣ�" + inpt);
			}
			if (sel == 3) {
				JOptionPane.showMessageDialog(null, "����һ����Ϣ�Ի���! û�з���ֵ��",
					"��Ϣ�Ի�����÷�", JOptionPane.WARNING_MESSAGE, new ImageIcon(
					"001.jpg"));
				label.setText("��Ϣ�Ի���û�з���ֵ��");
			}
		}
	}
}
