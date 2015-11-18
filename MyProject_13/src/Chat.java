import java.awt.*;
	import java.awt.event.*;
	import java.net.*;
	public class Chat {
			Frame f = new Frame();
			TextField tf = new TextField(15);
			List list = new List(6);
			DatagramSocket ds;
			public Chat() {
				try {
					ds = new DatagramSocket(3000);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				new Thread(new Runnable() {
					public void run() {
						byte buf[] = new byte[1024];
						DatagramPacket dp = new DatagramPacket(buf, 1024);
						while (true) {
							try {
								ds.receive(dp);				// �������ݰ�
								// ��������ӵ��б����
								list.add(new String(buf, 0, dp.getLength()) + ":from"
									+ dp.getAddress().getHostAddress(), 0);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}).start();			 						// �����߳�
			}
			public static void main(String[] args) {
				Chat chat = new Chat();
				chat.init();
			}
			public void init() {
				f.setSize(300, 300);
				f.add(list);
				Panel p = new Panel();
				p.setLayout(new BorderLayout());					//  ʹ�ñ߽粼�ֹ�����
				p.add("West", tf);
				TextField tfData = new TextField(20);
				p.add("East", tfData);
				f.add("South", p);
				f.setVisible(true);
				f.setResizable(false);							// �����û��ı䴰�ڵĴ�С
				// �����˳�ʱ���ر�Socket���ͷ������Դ
				f.addWindowListener(new WindowAdapter() {		
					public void windowClosing(WindowEvent e) {
						ds.close();									
				 		f.setVisible(false);				
				 		f.dispose();							// �ͷ���Դ
						System.exit(0);						// �رմ���
					}
				});
				// ��������Ϣ�ı����а��»س������¼��������
				tfData.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						byte[] buf;
						// ȡ���ı����е���Ϣ�ַ�����������ת�����ֽ�����
						buf = e.getActionCommand().getBytes();		
						try {
							// ����һ��UDP���ݰ�
							DatagramPacket dp = new DatagramPacket(buf, buf.length,
									InetAddress.getByName(tf.getText()), 3000);
							ds.send(dp);					// �����ݷ��ͳ�ȥ
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						((TextField) e.getSource()).setText("");		// ȡ���ı����е�����
					}
				});
			}
	}

