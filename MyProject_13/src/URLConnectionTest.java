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
						ta.append("Host: " + url.getHost());		// ��ȡURL��������
						ta.append(line);						// ����Ϣ��ӵ��ı�����
						ta.append("Port: " + url.getDefaultPort());	// ��ȡ��URL������Ĭ�϶˿�
						ta.append(line);
						// ��ȡ content-type ͷ�ֶε�ֵ
						ta.append("ContentType: " + urlConn.getContentType());		
						ta.append(line);
						//���� content-length ͷ�ֶε�ֵ
						ta.append("ContentLength: " + urlConn.getContentLength());	
						// ��ȡ content-length ͷ�ֶε�ֵ
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			jf.addWindowListener(new WindowAdapter() {			// �رմ���
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			jf.setVisible(true);								// ���ô���ɼ�
		}
	}
