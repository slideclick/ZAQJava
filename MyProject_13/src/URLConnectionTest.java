import java.net.*;
	import javax.swing.*;
	import java.awt.event.*;
	import java.io.*;
	public class URLConnectionTest {
		public static void main(String[] args) {
			JFrame jf = new JFrame();
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
					String str = tf.getText();
					try {
						URL url = new URL(str);
						URLConnection urlConn = url.openConnection();
						String line = System.getProperty("line.separator");
						ta.append("Host: " + url.getHost());		// 获取URL的主机名
						ta.append(line);						// 将信息添加到文本区中
						ta.append("Port: " + url.getDefaultPort());	// 获取此URL关联的默认端口
						ta.append(line);
						// 获取 content-type 头字段的值
						ta.append("ContentType: " + urlConn.getContentType());		
						ta.append(line);
						//返回 content-length 头字段的值
						ta.append("ContentLength: " + urlConn.getContentLength());	
						// 获取 content-length 头字段的值
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			jf.addWindowListener(new WindowAdapter() {			// 关闭窗体
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			jf.setVisible(true);								// 设置窗体可见
		}
	}
