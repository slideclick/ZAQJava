package org.hanoiTower;
import java.awt.*;
public class Disk extends Button {
	int number;								//�������
	boolean topHaving = false;
	public Disk(int number, HanoiTower con) {
		this.number = number;
		setBackground(Color.blue);			//�������ӵı���ɫ
		addMouseMotionListener(con);
		addMouseListener(con);
	}
	public boolean isTopHaving() {			//�ж��Ϸ��Ƿ�����
		return topHaving;
	}
	public void setTopHaving(boolean b) {	//�����Ϸ�����
		topHaving = b;
	}
	public int getNumber() {
		return number;
	}
}
