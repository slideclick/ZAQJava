package org.hanoiTower1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HanoiTowerCarry extends Frame implements ActionListener {
	HanoiTower tower = null;
	Button renew = null;
	char towername[] = { 'A', 'B', 'C' };
	int count, width, height;
	Thread thread; 						// �߳�
	TextArea textArea = null; 			// ��Ϣ��
	public HanoiTowerCarry() {
		count = 5;
		width = 80;
		height = 18;
		textArea = new TextArea(12, 12);
		textArea.setText(null);
		tower = new HanoiTower(count, width, height, towername, textArea);
		renew = new Button("���¿�ʼ");
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
		validate(); // ��֤�������������������,ʹ�����ٴβ����������
	}
	public void actionPerformed(ActionEvent e) { // �жϵ������ĸ���ť
		if (e.getSource() == renew) {
			this.remove(tower);
			textArea.setText(null);
			tower = new HanoiTower(count, width, height, towername, textArea);
			add(tower, BorderLayout.CENTER);
			validate();
		}
	}
	public static void main(String args[]) {
		new HanoiTowerCarry().setTitle("��ŵ��");
	}
}
