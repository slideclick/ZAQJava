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
	JButton bt = new JButton("确定");
	JTextField jtf = new JTextField(10);
	Font font = new Font("Serif", Font.BOLD, 16);
	JLabel label = new JLabel("你选择的是第0张标签页");
	void launch() {
		f.setSize(400, 300);
		f.getContentPane().add("Center", jPane);
		jPane.add("第0张", jsp1);
		// 同时将容器jsp1放置在该标签页上
		jPane.setToolTipTextAt(0, "点击这里将显示第0张");
		// 设置第0张标签页的提示信息为"点击这里将显示第一张"
		jPane.add("第1张", jsp2);
		jPane.setToolTipTextAt(1, "点击这里将显示第1张");
		jPane.add("第2张", p);
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
			label.setText("你选择的是第" + id + "张标签页");
		}
	}
}

