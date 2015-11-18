package com.net;
		import java.net.*;
		import javax.swing.*;
		import java.awt.event.*;
		import java.io.*;
		public class Download {
			public static void main(String[] args) {
				JFrame jf = new JFrame("���س���");
				jf.setSize(600, 400);
				jf.setLocation(100, 100);
				JPanel p = new JPanel();
				JLabel l = new JLabel("Please input URL:");
				final JTextField tf = new JTextField(30);
				p.add(l);
				p.add(tf);
				jf.getContentPane().add(p, "North");
				final JTextArea ta = new JTextArea();
				jf.getContentPane().add(ta, "Center");
				JButton btn = new JButton("Download");
				jf.getContentPane().add(btn, "South");
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String str = tf.getText();		// ��ȡ�ı����������URL��ַ
						try {
							URL url = new URL(str);
							// ����һ��������
							BufferedReader br = new BufferedReader(new 														InputStreamReader(url.openStream()));
							String s;
							while ((s = br.readLine()) != null){
								ta.append(s+"\n");	// ����ȡ��������ӵ��ı�����
							}
							br.close();						// �رջ����� 
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				jf.addWindowListener(new WindowAdapter() {		// �رմ���
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
				jf.setVisible(true);							// ���ô���ɼ�
			}
		}

