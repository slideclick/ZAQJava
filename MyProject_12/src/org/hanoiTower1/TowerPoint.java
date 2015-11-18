package org.hanoiTower1;
import java.awt.*;
public class TowerPoint {
	int x, y;
	boolean having;//������
	Disk disk = null;
	HanoiTower tower = null;
	public TowerPoint(int x, int y, boolean having) {
		this.x = x;
		this.y = y;
		this.having = having;
	}
	public boolean ishaving() {
		return having;
	}
	public void setHaving(boolean having) {
		this.having = having;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void deposit(Disk disk, HanoiTower tower) {		//��������
		this.tower = tower;
		tower.setLayout(null);
		this.disk = disk;
		tower.add(disk);
		int w = disk.getBounds().width;
		int h = disk.getBounds().height;
		disk.setBounds(x - w / 2, y - h / 2, w, h);			//�ƶ������������С
		having = true;
		tower.validate();									//���²���
	}
	public Disk getDisk() {
		return disk;
	}
}
