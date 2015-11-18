package org.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
public class MyJList extends JFrame {
		private String[] months = { "January", "February", "March", "April", "May",
			"June", "July", "August", "September", "October", "September","December" };
	private JList list = new JList(months);
	private JTextArea textArea = new JTextArea(5, 20);
	private ListSelectionListener listener = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting())
				return;
			textArea.setText("");
			Object[] items = list.getSelectedValues();
			for (int i = 0; i < items.length; i++)
				textArea.append(items[i] + "\n");
		}
	};
	public MyJList(String title) {
		super(title);
		textArea.setEditable(false);
		list.setVisibleRowCount(5); 				// �ڽ�������ʾ5��ѡ��
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(textArea);
		contentPane.add(new JScrollPane(list)); 	    // ��������
		list.addListSelectionListener(listener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyJList("This is a Jlist");
	}
}

