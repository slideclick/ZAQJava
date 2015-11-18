package org.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ButtonAndIcon extends JFrame {
	private static Icon[] icons;
	private JButton jbt1, jbt2 = new JButton("Disable");
	private boolean flag = false;
	public ButtonAndIcon(String title) {
		super(title);
		icons = new Icon[] {
			new ImageIcon(getClass().getResource("image0.jpg")),
			new ImageIcon(getClass().getResource("image1.jpg")),
			new ImageIcon(getClass().getResource("image2.jpg")),
			new ImageIcon(getClass().getResource("image3.jpg")),
			new ImageIcon(getClass().getResource("image4.jpg")), };
		jbt1 = new JButton("Pet", icons[0]);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());			//使用流式布局管理器
		jbt1.addActionListener(new ActionListener() {		//注册监听器
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					jbt1.setIcon(icons[0]);
					flag = false;
				} else {
					jbt1.setIcon(icons[1]);
					flag = true;
				}
				jbt1.setVerticalAlignment(JButton.TOP);
				jbt1.setHorizontalAlignment(JButton.LEFT);
			}
		});
		jbt1.setRolloverEnabled(true);
		jbt1.setRolloverIcon(icons[2]);
		jbt1.setPressedIcon(icons[3]);
		jbt1.setDisabledIcon(icons[4]);
		jbt1.setToolTipText("Click Me!");
		contentPane.add(jbt1);
		jbt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jbt1.isEnabled()) {
					jbt1.setEnabled(false); 			//使按钮失效
					jbt2.setText("Enable");
				} else {
					jbt1.setEnabled(true); 				//使按钮有效
					jbt2.setText("Disable");
				}
			}
		});
		contentPane.add(jbt2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 关闭窗体
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new ButtonAndIcon("use Buttons");
	}
}

