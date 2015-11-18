package org.hanoiTower1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HanoiTower extends JPanel implements MouseListener,MouseMotionListener {
	TowerPoint point[];
	int x, y;
	boolean move = false;
	Disk disk[];															//����
	int startX, startY;
	int startI;
	int count = 0;
	int width, height;
	char towername[] = { 'A', 'B', 'C' };
	TextArea textArea = null;												//��Ϣ��
	public HanoiTower(int number, int w, int h, char[] name, TextArea text) {	
		towername = name;
		count = number;
		width = w;
		height = h;
		textArea = text;
		setLayout(null);
		addMouseListener(this); 
		addMouseMotionListener(this);
		disk = new Disk[count];
		point = new TowerPoint[3 * count];									//����
		int space = 20;
		for (int i = 0; i < count; i++) {
			point[i] = new TowerPoint(40 + width, 100 + space, false);		//������ߵ�����
			space = space + height;
		}
		space = 20;
		for (int i = count; i < 2 * count; i++) {
			point[i] = new TowerPoint(160 + width, 100 + space, false);		//�����м������
			space = space + height;
		}
		space = 20;
		for (int i = 2 * count; i < 3 * count; i++) {
			point[i] = new TowerPoint(280 + width, 100 + space, false);		//�����ұߵ�����
			space = space + height;
		}
		int tempWidth = width;
		int sub = (int) (tempWidth * 0.2);
		for (int i = count - 1; i >= 0; i--) {
			disk[i] = new Disk(i, this);									//��������
			disk[i].setSize(tempWidth, height);
			tempWidth = tempWidth - sub;
		}
		for (int i = 0; i < count; i++) {
			point[i].deposit(disk[i], this);								//����ߵ������Ϸ�������
			if (i >= 1)
				disk[i].setTopHaving(true);
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(point[0].getX(), point[0].getY(), point[count - 1].getX(),
				point[count - 1].getY());									//�ڣ�����ֱֱ��
		g.drawLine(point[count].getX(), point[count].getY(), point[2 * count - 1]
				.getX(), point[2 * count - 1].getY());						//�ڶ�����ֱֱ��
		g.drawLine(point[2 * count].getX(), point[2 * count].getY(),
				point[3 * count - 1].getX(), point[3 * count - 1].getY());//��������ֱֱ��
		g.drawLine(point[count - 1].getX() - width, point[count - 1].getY(),
			point[3 * count - 1].getX() + width, point[3 * count - 1].getY());
		int leftx = point[count - 1].getX() - width;
		int lefty = point[count - 1].getY();
		int w = (point[3 * count - 1].getX() + width)
				- (point[count - 1].getX() - width);
		int h = height / 2;
		g.setColor(Color.green);											//���ߵ���ɫ
		g.fillRect(leftx, lefty, w, h);										//������
		int size = 4;
		for (int i = 0; i < 3 * count; i++) {								//������Բ
			g.fillOval(point[i].getX() - size / 2, point[i].getY() - size / 2,
					size, size);
		}
		g.drawString("" + towername[0] + "��", point[count - 1].getX(),
				point[count - 1].getY() + 30);
		g.drawString("" + towername[1] + "��", point[2 * count - 1].getX(),
				point[count - 1].getY() + 30);
		g.drawString("" + towername[2] + "��", point[3 * count - 1].getX(),
				point[count - 1].getY() + 30);

		g.drawString("��ȫ�����Ӵ�" + towername[0] + "�����˵�" + towername[1] + "����"
				+ towername[2] + "��", point[count - 1].getX(), point[count - 1]
				.getY() + 80);
	}
	public void mousePressed(MouseEvent e) {
		Disk disk = null;
		Rectangle rect = null;
		if (e.getSource() == this)
			move = false;
		if (move == false){
			if (e.getSource() instanceof Disk) {
				disk = (Disk) e.getSource();
				startX = disk.getBounds().x;
				startY = disk.getBounds().y;
				rect = disk.getBounds();								//��ʾ����߽�ľ���
				for (int i = 0; i < 3 * count; i++) {
					int x = point[i].getX();
					int y = point[i].getY();
					if (rect.contains(x, y)) {
						startI = i;
						break;
					}
				}
			}
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent e) {							//�������

		Disk disk = null;
		if (e.getSource() instanceof Disk) {
			disk = (Disk) e.getSource();
			move = true;

			e = SwingUtilities.convertMouseEvent(disk, e, this);
		}

		if (e.getSource() == this) {
			if (move && disk != null) {
				x = e.getX();
				y = e.getY();
				if (disk.isTopHaving() == false)
					disk.setLocation(x - disk.getWidth() / 2, y
							- disk.getHeight() / 2);
			}
		}
	}
	public void mouseReleased(MouseEvent e) {						//�ͷ����
		Disk disk = null;
		move = false;
		Rectangle rect = null;
		if (e.getSource() instanceof Disk) {
			disk = (Disk) e.getSource();
			rect = disk.getBounds();

			e = SwingUtilities.convertMouseEvent(disk, e, this);
		}
		if (e.getSource() == this) {
			boolean containTowerPoint = false;
			int x = 0, y = 0;
			int endI = 0;
			if (disk != null) {
				for (int i = 0; i < 3 * count; i++) {
					x = point[i].getX();
					y = point[i].getY();
					if (rect.contains(x, y)) {
						containTowerPoint = true;
						endI = i;
						break; 
					}
				}
			}
			if (disk != null && containTowerPoint) {
				if (point[endI].ishaving() == true) {						//����û����
					disk.setLocation(startX, startY);						//�Ż�ԭ��
				} else {
					//������̵����͵㣬��ֱ�ӷ�������
					if (endI == count - 1 || endI == 2 * count - 1
							|| endI == 3 * count - 1) {
						point[endI].deposit(disk, this);
						if (startI != count - 1 && startI != 2 * count - 1
								&& startI != 3 * count - 1) {
							(point[startI + 1].getDisk()).setTopHaving(false);			//�����Ѿ���ȡ��
							point[startI].setHaving(false);								//�����Ѿ���ȡ��
						} else {
							point[startI].setHaving(false);
						}
					} else {
						//�ж������Ƿ�������
						if (point[endI + 1].ishaving() == true) {
							Disk tempDisk = point[endI + 1].getDisk();
							//�����������ӱ����������С�����Է�������
							if ((tempDisk.getNumber() - disk.getNumber()) >= 1) {
								point[endI].deposit(disk, this);
								if (startI != count - 1
										&& startI != 2 * count - 1
										&& startI != 3 * count - 1) {
									(point[startI + 1].getDisk()).setTopHaving(false);	//�����Ѿ���ȡ��
									point[startI].setHaving(false);						//�����Ѿ���ȡ��
									tempDisk.setTopHaving(true);						//endI+1λ�õ��Ϸ�endI�����Ӿ��Ǹոշ��ϵ�����
								} else {
									point[startI].setHaving(false);						//�÷���������Ѿ���ȡ��
									tempDisk.setTopHaving(true);
								}
							} else {
								disk.setLocation(startX, startY);
							}
						} else {
							disk.setLocation(startX, startY);
						}
					}
				}
			}
			if (disk != null && !containTowerPoint) {
				disk.setLocation(startX, startY);
			}
		}
	}



	public void mouseExited(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void autoCarry(int count, char A, char B, char C) {
		if (count == 1) {
			textArea.append("" + A +"��"+ " ��: " + C + "��\n");
			Disk disk = getTopDisk(A);
			int startI = getTopPosition(A);
			int endI = getSupremePosition(C);
			if (disk != null) {
				point[endI].deposit(disk, this);
				point[startI].setHaving(false);
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
		} else {
			autoCarry(count - 1, A, C, B);									//�ݹ�
			textArea.append("" + A + "��"+ " ��: " + C + "��\n");
			Disk disk = getTopDisk(A);
			int startI = getTopPosition(A);										//�����л�ȡ���������ӵ�λ��
			int endI = getSupremePosition(C);									//�����л�ȡ���������ӵ��Ϸ�λ��
			if (disk != null) {
				point[endI].deposit(disk, this);
				point[startI].setHaving(false);
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			autoCarry(count - 1, B, A, C);								
		}
	}
	public Disk getTopDisk(char name) {												//�����л�ȡ�����������
		Disk disk = null;
		if (name == towername[0]) {													//��һ������
			for (int i = 0; i < count; i++) {
				if (point[i].ishaving() == true) {
					disk = point[i].getDisk();
					break;
				}
			}
		}
		if (name == towername[1]) {													//�ڶ�������
			for (int i = count; i < 2 * count; i++) {
				if (point[i].ishaving() == true) {
					disk = point[i].getDisk();
					break;
				}
			}
		}
		if (name == towername[2]) {													//����������
			for (int i = 2 * count; i < 3 * count; i++) {
				if (point[i].ishaving() == true) {
					disk = point[i].getDisk();
					break;
				}
			}
		}
		return disk;
	}
	public int getSupremePosition(char name) {										//�����л�ȡ���������ӵ��Ϸ�λ��
		int position = 0;
		if (name == towername[0]) {
			int i = 0;
			for (i = 0; i < count; i++) {
				if (point[i].ishaving() == true) {
					position = Math.max(i - 1, 0);
					break;
				}
			}
			if (i == count) {
				position = count - 1;
			}
		}
		if (name == towername[1]) {
			int i = 0;
			for (i = count; i < 2 * count; i++) {
				if (point[i].ishaving() == true) {
					position = Math.max(i - 1, 0);
					break;
				}
			}
			if (i == 2 * count) {
				position = 2 * count - 1;
			}
		}
		if (name == towername[2]) {
			int i = 0;
			for (i = 2 * count; i < 3 * count; i++) {
				if (point[i].ishaving() == true) {
					position = Math.max(i - 1, 0);
					break;
				}
			}
			if (i == 3 * count) {
				position = 3 * count - 1;
			}
		}
		return position;
	}
	public int getTopPosition(char name) {											//�����л�ȡ���������ӵ�λ��
		int position = 0;
		if (name == towername[0]) {
			int i = 0;
			for (i = 0; i < count; i++) {
				if (point[i].ishaving() == true) {
					position = i;
					break;
				}
			}
			if (i == count) {
				position = count - 1;
			}
		}
		if (name == towername[1]) {
			int i = 0;
			for (i = count; i < 2 * count; i++) {
				if (point[i].ishaving() == true) {
					position = i;
					break;
				}
			}
			if (i == 2 * count) {
				position = 2 * count - 1;
			}
		}
		if (name == towername[2]) {
			int i = 0;
			for (i = 2 * count; i < 3 * count; i++) {
				if (point[i].ishaving() == true) {
					position = i;
					break;
				}
			}
			if (i == 3 * count) {	
				position = 3 * count - 1;
			}
		}
		return position;
	}
}
