package com.net;
		import java.net.*;
		import javax.swing.*;
		import java.awt.event.*;
		import java.io.*;
		public class Download {
			public static void main(String[] args) {
				JFrame jf = new JFrame("下载程序");
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
						String str = tf.getText();		// 获取文本框中输入的URL地址
						try {
							URL url = new URL(str);
							// 产生一个缓冲流
							BufferedReader br = new BufferedReader(new 														InputStreamReader(url.openStream()));
							String s;
							while ((s = br.readLine()) != null){
								ta.append(s+"\n");	// 将读取的内容添加到文本区中
							}
							br.close();						// 关闭缓冲流 
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				jf.addWindowListener(new WindowAdapter() {		// 关闭窗体
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
				jf.setVisible(true);							// 设置窗体可见
			}
		}

