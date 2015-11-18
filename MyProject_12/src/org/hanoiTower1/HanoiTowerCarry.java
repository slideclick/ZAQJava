package org.hanoiTower1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HanoiTowerCarry extends Frame implements ActionListener {
	HanoiTower tower = null;
	Button renew = null;
	char towername[] = { 'A', 'B', 'C' };
	int count, width, height;
	Thread thread; 						// 线程
	TextArea textArea = null; 			// 信息条
	public HanoiTowerCarry() {
		count = 5;
		width = 80;
		height = 18;
		textArea = new TextArea(12, 12);
		textArea.setText(null);
		tower = new HanoiTower(count, width, height, towername, textArea);
		renew = new Button("重新开始");
		renew.setBackground(Color.cyan);
		renew.addActionListener(this);
		add(tower, BorderLayout.CENTER);
		add(renew, BorderLayout.SOUTH);
		add(textArea, BorderLayout.EAST);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
		setBounds(60, 20, 670, 540);
		validate(); // 验证此容器及其所有子组件,使容器再次布置其子组件
	}
	public void actionPerformed(ActionEvent e) { // 判断单击是哪个按钮
		if (e.getSource() == renew) {
			this.remove(tower);
			textArea.setText(null);
			tower = new HanoiTower(count, width, height, towername, textArea);
			add(tower, BorderLayout.CENTER);
			validate();
		}
	}
	public static void main(String args[]) {
		new HanoiTowerCarry().setTitle("汉诺塔");
	}
}
