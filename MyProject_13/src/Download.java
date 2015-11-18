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
			p.add(l);p.add(tf);
			jf.getContentPane().add(p, "North");
			final JTextArea ta = new JTextArea();
			jf.getContentPane().add(ta, "Center");
			JButton btn = new JButton("����");
			jf.getContentPane().add(btn, "South");
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = tf.getText();				// ��ȡ�ı����������URL��ַ
					try {
						URL url = new URL(str);
						URLConnection uc = url.openConnection(); 	// ����URLConnection����
						uc.connect(); // ��������
						int n = 1; 
						String key = null;
							// ��"��---ֵ"���У�keyֵ��Ϊ��
						while ((key = uc.getHeaderFieldKey(n)) != null) {
							// ȡ��"��-ֵ"������Ӧ��value����
							String value = uc.getHeaderField(n); 
							ta.append(key + " <---> " + value+"\n");		
							n++;
						}
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

