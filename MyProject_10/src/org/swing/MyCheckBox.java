package org.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Favrate extends JPanel {
		JCheckBox jCheck1, jCheck2, jCheck3, jCheck4;
		Favrate() {
			jCheck1 = new JCheckBox("�˶�");
			jCheck2 = new JCheckBox("����");
			jCheck3 = new JCheckBox("����");
			jCheck4 = new JCheckBox("����");
			add(new JLabel("����"));
			add(jCheck1);						// ��JCheckBox���ص�JPanel��
			add(jCheck2);
			add(jCheck3);
			add(jCheck4);
		}
}
class SexBox extends JPanel {
		JRadioButton jRadio1, jRadio2;
		SexBox() {
			jRadio1 = new JRadioButton("��");
			jRadio2 = new JRadioButton("Ů");
			add(new JLabel("�Ա�"));
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
			add(new JLabel("����"));
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
			super("�����");
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
			tb.jButton1.addActionListener(this);			// ע������ļ�����
			tb.jButton2.addActionListener(this);
			tb.jButton3.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o == tb.jButton1) {
				StringBuffer ss = new StringBuffer("\n������" + name.jText.getText()
					+ "\n�Ա�");
				if (sex.jRadio1.isSelected() == true)
					ss.append("��");
				else if (sex.jRadio2.isSelected() == true)
					ss.append("Ů");
				ss.append("\n���ã�");
				if (favrate.jCheck1.isSelected() == true)
					ss.append("�˶�");
				if (favrate.jCheck2.isSelected() == true)
					ss.append("  ����");
				if (favrate.jCheck3.isSelected() == true)
					ss.append("  ����");
				if (favrate.jCheck4.isSelected() == true)
					ss.append("  ����");
				JText.setText(ss.toString());
			}
			else if (o == tb.jButton2) {
				try {
					FileWriter out = new FileWriter("D:\\temp.txt", true);
					out.write("\r\n" + JText.getText());
					JOptionPane.showMessageDialog(this, "�ļ��ѱ���!");
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

