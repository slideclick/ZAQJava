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
								ds.receive(dp);				// 接受数据包
								// 将数据添加到列表框里
								list.add(new String(buf, 0, dp.getLength()) + ":from"
									+ dp.getAddress().getHostAddress(), 0);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}).start();			 						// 启动线程
			}
			public static void main(String[] args) {
				Chat chat = new Chat();
				chat.init();
			}
			public void init() {
				f.setSize(300, 300);
				f.add(list);
				Panel p = new Panel();
				p.setLayout(new BorderLayout());					//  使用边界布局管理器
				p.add("West", tf);
				TextField tfData = new TextField(20);
				p.add("East", tfData);
				f.add("South", p);
				f.setVisible(true);
				f.setResizable(false);							// 限制用户改变窗口的大小
				// 程序退出时，关闭Socket，释放相关资源
				f.addWindowListener(new WindowAdapter() {		
					public void windowClosing(WindowEvent e) {
						ds.close();									
				 		f.setVisible(false);				
				 		f.dispose();							// 释放资源
						System.exit(0);						// 关闭窗体
					}
				});
				// 增加在消息文本框中按下回车键的事件处理代码
				tfData.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						byte[] buf;
						// 取出文本框中的消息字符串，并将其转换成字节数组
						buf = e.getActionCommand().getBytes();		
						try {
							// 生成一个UDP数据包
							DatagramPacket dp = new DatagramPacket(buf, buf.length,
									InetAddress.getByName(tf.getText()), 3000);
							ds.send(dp);					// 将数据发送出去
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						((TextField) e.getSource()).setText("");		// 取消文本框中的数据
					}
				});
			}
	}

