package org.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JListTest {
		JFrame f = new JFrame("JList的用法");
		JPanel p1 = new JPanel(new FlowLayout());			// 设置流式布局管理器
		JPanel p2 = new JPanel(new GridLayout(1, 2, 10, 5));
		JList l1 = new JList();
		JList l2 = new JList();
		JTextField jtf = new JTextField(12);
		JToggleButton b1 = new JToggleButton("增加", false);
		JToggleButton b2 = new JToggleButton("复制", false);
		Font ft = new Font("Serif", Font.BOLD, 18);
		public static void main(String args[]) {
			JListTest that = new JListTest();
			that.go();
		}
		void go() {
			f.getContentPane().add("North", p1);				// 将容器p1加到窗口的北面
			p1.add(jtf);							
			p1.add(b1);
			p1.add(b2);
			f.getContentPane().add("Center", p2);				// 将容器p2加到窗口的中央
			p2.add(l1);
			p2.add(l2);
			jtf.setFont(ft);								// 设置字体
			b1.setFont(ft);
			b2.setFont(ft);
			b1.setToolTipText("将单行编辑框中的内容加到左边列表框中");
			b2.setToolTipText("将左边列表框中的内容复制到右边列表框中");
			l1.setFont(ft);
			l2.setFont(ft);
			b1.addActionListener(new ButtonH(1));				// 注册监听器
			b2.addActionListener(new ButtonH(2));
			f.setLocation(300, 500);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 关闭窗口
			f.setSize(400, 300);
			f.setResizable(true);
			f.setVisible(true);
		}
		public class ButtonH implements ActionListener {			// 实现监听器
			int sel;
			ButtonH(int select) {
				sel = select;
			}
			public void actionPerformed(ActionEvent e) {
				if (sel == 1) {
					int num = l1.getModel().getSize();				// 获得列表框l1中的项目数
					String data[] = new String[num + 1];
					for (int i = 0; i < num; i++)
						data[i] = (String) l1.getModel().getElementAt(i);
					data[num] = jtf.getText();
					l1.setListData(data);
					b1.setSelected(false);
				}
				if (sel == 2){
					String data[] = new String[l1.getModel().getSize()];
			for (int i = 0; i < l1.getModel().getSize(); i++)
						data[i] = (String) l1.getModel().getElementAt(i);	//强制类型转换
					l2.setListData(data);
					b2.setSelected(false);
				}
			}
		}
}

