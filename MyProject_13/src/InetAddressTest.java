import java.net.*;
	import java.awt.*;
	import java.awt.event.*;
	public class InetAddressTest {
		static TextField tf1 = new TextField(40);
		static List list = new List(6);
		public static void main(String[] args) throws Exception {
			Frame f = new Frame();
			f.add(list);
			f.setSize(300, 300);							// 设置窗体的大小
			Panel p = new Panel();
			p.setLayout(new BorderLayout());					// 设置边界布局管理器
			tf1.addActionListener(new MyListener());			// 注册事件监听器
			p.add("West", tf1);
			f.add("South", p);
			f.addWindowListener(new WindowAdapter() { 		// 关闭窗口
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
			});
			f.setVisible(true);
		}
	}
	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = InetAddressTest.tf1.getText();				// 获取文本框中的内容
			InetAddress[] addr;
			try {
				InetAddressTest.list.removeAll();				// 将列表框中的原有内容清除
				addr = InetAddress.getAllByName(s);			// 返回主机名所对应的所有IP地址
				for (int i = 0; i < addr.length; i++) {
					InetAddressTest.list.add(addr[i].toString());	// 添加到列表框中
				}
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			((TextField) e.getSource()).setText(null);			// 设置文本框的内容为空
		}
	}

