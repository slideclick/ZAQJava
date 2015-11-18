package org.swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class MyJOptionPane {
	JFrame frame = new JFrame(" This is a JOptionPane");
	JPanel panel = new JPanel(new GridLayout(1, 3, 10, 10));
	JButton bt1 = new JButton("确认对话框");
	JButton bt2 = new JButton("输入对话框");
	JButton bt3 = new JButton("信息对话框");
	JLabel label = new JLabel("你的选择或输入是", JLabel.CENTER);
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
					"这是一个确认对话框! 返回值:\n0表示Yes、1表示No、2选择Cancel",
					"确认对话框的用法", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
				String choice;
				if (n == 0)
					choice = "Yes";
				else if (n == 1)
					choice = "No";
				else
					choice = "Cancel";
				label.setText("你选择的是：" + choice);
			}
			if (sel == 2) {
				Object[] vals = { "Blue", "Yellow", "Brown", "Pink", "White" };
				String inpt = (String) JOptionPane.showInputDialog(null,
					"这是一个输入对话框! 返回值表示你的输入或选择","输入对话框的用法",
					JOptionPane.QUESTION_MESSAGE, new ImageIcon("001.jpg"),
					vals, vals[2]);
				label.setText("你输入的是：" + inpt);
			}
			if (sel == 3) {
				JOptionPane.showMessageDialog(null, "这是一个信息对话框! 没有返回值！",
					"信息对话框的用法", JOptionPane.WARNING_MESSAGE, new ImageIcon(
					"001.jpg"));
				label.setText("信息对话框没有返回值！");
			}
		}
	}
}
