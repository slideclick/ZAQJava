package org.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class MyJTabbedPane {
	JFrame f = new JFrame("This is a JTabbedPane");
	JScrollPane jsp1 = new JScrollPane();
	JScrollPane jsp2 = new JScrollPane();
	JPanel p = new JPanel(new BorderLayout());
	JTextArea jta = new JTextArea(5, 10);
	JList list = new JList();
	JTabbedPane jPane = new JTabbedPane();
	JButton bt = new JButton("ȷ��");
	JTextField jtf = new JTextField(10);
	Font font = new Font("Serif", Font.BOLD, 16);
	JLabel label = new JLabel("��ѡ����ǵ�0�ű�ǩҳ");
	void launch() {
		f.setSize(400, 300);
		f.getContentPane().add("Center", jPane);
		jPane.add("��0��", jsp1);
		// ͬʱ������jsp1�����ڸñ�ǩҳ��
		jPane.setToolTipTextAt(0, "������ｫ��ʾ��0��");
		// ���õ�0�ű�ǩҳ����ʾ��ϢΪ"������ｫ��ʾ��һ��"
		jPane.add("��1��", jsp2);
		jPane.setToolTipTextAt(1, "������ｫ��ʾ��1��");
		jPane.add("��2��", p);
		p.add("North", bt);
		p.add("South", jtf);
		jsp1.getViewport().add(jta);
		jsp2.getViewport().add(list);
		String[] months = { "January", "February", "March", "April", "May",
			"June", "July", "August", "September", "October", "September","December" };
		list.setListData(months);
		list.setFont(font);
		jta.setFont(font);
		jPane.setFont(font);
		f.getContentPane().add("South", label);
		label.setFont(font);
		jPane.addChangeListener(new MyMonitor());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String arg[]) {
		 new MyJTabbedPane().launch();
	}
	class MyMonitor implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			int id = jPane.getSelectedIndex();
			label.setText("��ѡ����ǵ�" + id + "�ű�ǩҳ");
		}
	}
}

