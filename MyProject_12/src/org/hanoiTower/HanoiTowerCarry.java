package org.hanoiTower;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HanoiTowerCarry extends Frame implements ActionListener, Runnable {
	HanoiTower tower = null;
	Button renew = null; 				//���°�������
	Button auto = null;					//�Զ���������
	
	char towername[] = { 'A', 'B', 'C' };		
	int count;							//������Ŀ
	int width;							//���ӿ��
	int height;							//���Ӹ߶�
	Thread thread; 						//�߳�
	TextArea textArea = null;			//��Ϣ��

	public HanoiTowerCarry() {
		thread = new Thread(this);		//�����߳�
		count = 5;
		width = 80;
		height = 18;
		textArea = new TextArea(12, 12);			//������Ϣ��
		textArea.setText(null);
		tower = new HanoiTower(count, width, height, towername, textArea);
		renew = new Button("���¿�ʼ");
		renew.setBackground(Color.cyan);			
		auto = new Button("�Զ���������");
		auto.setBackground(Color.cyan);
		renew.addActionListener(this);				//ע�������
		auto.addActionListener(this);				//ע�������
		add(tower, BorderLayout.CENTER);
		add(renew, BorderLayout.SOUTH);
		add(auto, BorderLayout.NORTH);
		add(textArea, BorderLayout.EAST);
		addWindowListener(new WindowAdapter() {		//ע�������
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
		setBounds(60, 20, 670, 540);				
		validate();									//���²���
	}

	public void actionPerformed(ActionEvent e) {		//�жϵ������ĸ���ť
		if (e.getSource() == renew) {					//�����������¿�ʼ��ť
			if (!(thread.isAlive())) {
				this.remove(tower);
				textArea.setText(null);
				tower = new HanoiTower(count, width, height, towername, textArea);
				add(tower, BorderLayout.CENTER);
				validate();
			}
		}
		if (e.getSource() == auto) {					//���������Զ���ʼ��ť
			if (!(thread.isAlive())) {
				thread = new Thread(this);
			}
			try {
				thread.start();							//�����߳�
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
		new HanoiTowerCarry().setTitle("��ŵ��");
	}
}
