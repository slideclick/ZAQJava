package org.swing;
import java.io.*;
import javax.swing.filechooser.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class MyJFileChooser {
	JTextArea jbl = new JTextArea();
	JScrollPane jsp = new JScrollPane();
	JPanel jp = new JPanel();
	JButton open = new JButton("��");
	JButton save = new JButton("����");
	JButton ret = new JButton("����");
	public void launch() {
		JFrame jf = new JFrame("�ļ�����");
		jf.getContentPane().add("Center", jsp);
		jsp.getViewport().add(jbl);
		jf.getContentPane().add("North", jp);
		jp.add(open);
		jp.add(save);
		jp.add(ret);
		save.addActionListener(new Select('s'));
		open.addActionListener(new Select('o'));
		ret.addActionListener(new Select('r'));
		Font newf = new Font("TimesRoman", Font.PLAIN, 24);
		jbl.setFont(newf);
		open.setFont(newf);
		save.setFont(newf);
		ret.setFont(newf);
		jf.setSize(400, 500);
		jf.setVisible(true);
	}
	public class Select implements ActionListener {
		private char isselect;
		String fname;
		JFileChooser jfc;
		// ����һ���ļ��Ի���jfc
		File sf;
		public Select(char ch) {
			isselect = ch;
		}
		public void actionPerformed(ActionEvent e) {
			if (isselect == 'r')
				System.exit(1);
			// ���Ƿ��ذ�ť���������������
			switch (isselect) {
			case 'o':
				// ����"��"��ť
				jfc = new JFileChooser("c:/"); 	// �ļ��Ի����ȱʡĿ¼ΪC:\
				jfc.showOpenDialog(null); 		// ��ʾ���ļ��Ի���
				sf = jfc.getSelectedFile(); 		// �����ѡ����ļ���
				fname = sf.getAbsolutePath(); 	// ��ú�����·�����ļ���
				String resl = "";
				try {
					FileReader fr = new FileReader(fname);
					// �Զ���ʽ���ļ��������ļ����ݶ���resl��
					int rd;
					rd = fr.read();
					while (rd != -1) {
						resl = resl + (char) rd;
						rd = fr.read();
					}
				} catch (IOException e1) {
				}
				;
				jbl.setText(resl); 				// �ڶ��б༭������ʾ�ļ�����resl
				break;
			case 's':
				// ���ǡ����桱��ť
				jfc = new JFileChooser("c:/");
				jfc.showSaveDialog(null);			// ��ʾ�����ļ��Ի���
				sf = jfc.getSelectedFile();
				fname = sf.getAbsolutePath();
				try {
					FileWriter fw = new FileWriter(fname);
					// ��д��ʽ���ļ����������б༭��������д���ļ���
					String sw;
					sw = jbl.getText();
					fw.write(sw);
					fw.close();
				} catch (IOException e2) {
				}
				break;
			}
		}
	}
	public static void main(String args[]) {
		new MyJFileChooser().launch();
	}
}

