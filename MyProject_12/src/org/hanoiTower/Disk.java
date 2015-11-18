package org.hanoiTower;
import java.awt.*;
public class Disk extends Button {
	int number;								//盘子序号
	boolean topHaving = false;
	public Disk(int number, HanoiTower con) {
		this.number = number;
		setBackground(Color.blue);			//设置盘子的背景色
		addMouseMotionListener(con);
		addMouseListener(con);
	}
	public boolean isTopHaving() {			//判断上方是否有盘
		return topHaving;
	}
	public void setTopHaving(boolean b) {	//设置上方有盘
		topHaving = b;
	}
	public int getNumber() {
		return number;
	}
}
