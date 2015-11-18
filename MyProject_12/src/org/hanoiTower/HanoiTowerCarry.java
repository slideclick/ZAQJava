package org.hanoiTower;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HanoiTowerCarry extends Frame implements ActionListener, Runnable {
	HanoiTower tower = null;
	Button renew = null; 				//重新搬运盘子
	Button auto = null;					//自动搬运盘子
	
	char towername[] = { 'A', 'B', 'C' };		
	int count;							//盘子数目
	int width;							//盘子宽度
	int height;							//盘子高度
	Thread thread; 						//线程
	TextArea textArea = null;			//信息条

	public HanoiTowerCarry() {
		thread = new Thread(this);		//创建线程
		count = 5;
		width = 80;
		height = 18;
		textArea = new TextArea(12, 12);			//创建信息条
		textArea.setText(null);
		tower = new HanoiTower(count, width, height, towername, textArea);
		renew = new Button("重新开始");
		renew.setBackground(Color.cyan);			
		auto = new Button("自动搬运盘子");
		auto.setBackground(Color.cyan);
		renew.addActionListener(this);				//注册监听器
		auto.addActionListener(this);				//注册监听器
		add(tower, BorderLayout.CENTER);
		add(renew, BorderLayout.SOUTH);
		add(auto, BorderLayout.NORTH);
		add(textArea, BorderLayout.EAST);
		addWindowListener(new WindowAdapter() {		//注册监听器
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
		setBounds(60, 20, 670, 540);				
		validate();									//重新布局
	}

	public void actionPerformed(ActionEvent e) {		//判断单击是哪个按钮
		if (e.getSource() == renew) {					//单击的是重新开始按钮
			if (!(thread.isAlive())) {
				this.remove(tower);
				textArea.setText(null);
				tower = new HanoiTower(count, width, height, towername, textArea);
				add(tower, BorderLayout.CENTER);
				validate();
			}
		}
		if (e.getSource() == auto) {					//单击的是自动开始按钮
			if (!(thread.isAlive())) {
				thread = new Thread(this);
			}
			try {
				thread.start();							//启动线程
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public void run() {
		this.remove(tower);
		textArea.setText(null);
		tower = new HanoiTower(count, width, height, towername, textArea);
		add(tower, BorderLayout.CENTER);
		validate();
		tower.autoCarry(count, towername[0], towername[1], towername[2]);
	}
	public static void main(String args[]) {
		new HanoiTowerCarry().setTitle("汉诺塔");
	}
}
