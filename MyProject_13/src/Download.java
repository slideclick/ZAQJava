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
			p.add(l);p.add(tf);
			jf.getContentPane().add(p, "North");
			final JTextArea ta = new JTextArea();
			jf.getContentPane().add(ta, "Center");
			JButton btn = new JButton("下载");
			jf.getContentPane().add(btn, "South");
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = tf.getText();				// 获取文本框中输入的URL地址
					try {
						URL url = new URL(str);
						URLConnection uc = url.openConnection(); 	// 生成URLConnection对象
						uc.connect(); // 发起连接
						int n = 1; 
						String key = null;
							// 若"名---值"对中，key值不为空
						while ((key = uc.getHeaderFieldKey(n)) != null) {
							// 取出"名-值"对中相应的value部分
							String value = uc.getHeaderField(n); 
							ta.append(key + " <---> " + value+"\n");		
							n++;
						}
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

