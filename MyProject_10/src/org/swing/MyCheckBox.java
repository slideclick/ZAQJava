package org.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Favrate extends JPanel {
		JCheckBox jCheck1, jCheck2, jCheck3, jCheck4;
		Favrate() {
			jCheck1 = new JCheckBox("运动");
			jCheck2 = new JCheckBox("电脑");
			jCheck3 = new JCheckBox("音乐");
			jCheck4 = new JCheckBox("读书");
			add(new JLabel("爱好"));
			add(jCheck1);						// 把JCheckBox加载到JPanel上
			add(jCheck2);
			add(jCheck3);
			add(jCheck4);
		}
}
class SexBox extends JPanel {
		JRadioButton jRadio1, jRadio2;
		SexBox() {
			jRadio1 = new JRadioButton("男");
			jRadio2 = new JRadioButton("女");
			add(new JLabel("性别"));
			ButtonGroup bg = new ButtonGroup();
			bg.add(jRadio1);
			bg.add(jRadio2);
			add(jRadio1);
			add(jRadio2);
		}
}
class NameBox extends JPanel {
		JTextField jText;
		NameBox() {
			jText = new JTextField(10);
			add(new JLabel("姓名"));
			add(jText);
		}
}
class ThreeButton extends JPanel {
		JButton jButton1, jButton2, jButton3;
		ThreeButton() {
			jButton1 = new JButton("List");
			jButton2 = new JButton("Save");
			jButton3 = new JButton("Exit");
			add(jButton1);				
			add(jButton2);
			add(jButton3);
		}
}
class MyCheckBox extends JFrame implements ActionListener {
		Favrate favrate;
		SexBox sex;
		NameBox name;
		JTextArea JText;
		ThreeButton tb;
		MyCheckBox() {
			super("调查表");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container container = this.getContentPane();
			container.setLayout(new FlowLayout());
			testInit();
			container.add(name);
			container.add(sex);
			container.add(favrate);
			container.add(new JScrollPane(JText));
			container.add(tb);
			this.setBounds(300, 200, 280, 300);
			this.setVisible(true);
		}
		void testInit() {
			favrate = new Favrate();
			sex = new SexBox();
			name = new NameBox();
			JText = new JTextArea(5, 22);
			tb = new ThreeButton();
			tb.jButton1.addActionListener(this);			// 注册自身的监听器
			tb.jButton2.addActionListener(this);
			tb.jButton3.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o == tb.jButton1) {
				StringBuffer ss = new StringBuffer("\n姓名：" + name.jText.getText()
					+ "\n性别：");
				if (sex.jRadio1.isSelected() == true)
					ss.append("男");
				else if (sex.jRadio2.isSelected() == true)
					ss.append("女");
				ss.append("\n爱好：");
				if (favrate.jCheck1.isSelected() == true)
					ss.append("运动");
				if (favrate.jCheck2.isSelected() == true)
					ss.append("  电脑");
				if (favrate.jCheck3.isSelected() == true)
					ss.append("  音乐");
				if (favrate.jCheck4.isSelected() == true)
					ss.append("  读书");
				JText.setText(ss.toString());
			}
			else if (o == tb.jButton2) {
				try {
					FileWriter out = new FileWriter("D:\\temp.txt", true);
					out.write("\r\n" + JText.getText());
					JOptionPane.showMessageDialog(this, "文件已保存!");
					out.close();
				} catch (Exception ex) {
				}
			}
			else
				System.exit(0);
		}
		public static void main(String[] args) {
			new MyCheckBox();
		}
}

