package org.hanoiTower;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HanoiTower extends JPanel implements MouseListener,
		MouseMotionListener {
	TowerPoint point[];
	int x, y;
	boolean move = false;
	Disk disk[];															
	int startX, startY;							
	int startI;
	int count = 0;
	int width, height;
	char towername[] = { 'A', 'B', 'C' };
	TextArea textArea = null;												//信息条
	
	public HanoiTower(int number, int w, int h, char[] name, TextArea text) {
		towername = name;								//塔座的名字
		count = number;									//盘子的数目
		width = w;										//盘子宽度
		height = h;										//盘子高度
		textArea = text;								
		setLayout(null);								//取消布局管理器
		addMouseListener(this); 											//注册鼠标事件监听器
		addMouseMotionListener(this);										//注册鼠标移动事件监听器
		disk = new Disk[count];																		
		point = new TowerPoint[3 * count];								
		int space = 20;
		for (int i = 0; i < count; i++) {
			point[i] = new TowerPoint(40 + width, 100 + space, false);		//创建左边的塔点
			space = space + height;
		}
		space = 20;
		for (int i = count; i < 2 * count; i++) {
			point[i] = new TowerPoint(160 + width, 100 + space, false);		//创建中间的塔点
			space = space + height;											
		}
		space = 20;
		for (int i = 2 * count; i < 3 * count; i++) {
			point[i] = new TowerPoint(280 + width, 100 + space, false);		//创建右边的塔点
			space = space + height;
		}
		int tempWidth = width;
		int sub = (int) (tempWidth * 0.2);
		for (int i = count - 1; i >= 0; i--) {
			disk[i] = new Disk(i, this);									//创建盘子
			disk[i].setSize(tempWidth, height);								//设置盘子的大小
			tempWidth = tempWidth - sub;									//设置盘子的宽度
		}
		for (int i = 0; i < count; i++) {
			point[i].deposit(disk[i], this);								//在左边的塔点上放置盘子
			if (i >= 1)
				disk[i].setTopHaving(true);									
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(point[0].getX(), point[0].getY(), point[count - 1].getX(),
				point[count - 1].getY());										//第－个塔座
		g.drawLine(point[count].getX(), point[count].getY(), point[2 * count - 1]
				.getX(), point[2 * count - 1].getY());							//第二个塔座
		g.drawLine(point[2 * count].getX(), point[2 * count].getY(),
				point[3 * count - 1].getX(), point[3 * count - 1].getY());		//第三个塔座
		g.drawLine(point[count - 1].getX() - width, point[count - 1].getY(),
			point[3 * count - 1].getX() + width, point[3 * count - 1].getY());
		int leftx = point[count - 1].getX() - width;							//设置塔基的横坐标
		int lefty = point[count - 1].getY();									//设置塔基的纵坐标
		int w = (point[3 * count - 1].getX() + width)
				- (point[count - 1].getX() - width);							//设置塔基的宽度
		int h = height / 2;														//设置塔基的高度
		g.setColor(Color.green);													//设置梵塔的颜色
		g.fillRect(leftx, lefty, w, h);												//创建塔基
		int size = 4;
		for (int i = 0; i < 3 * count; i++) {										
			g.fillOval(point[i].getX() - size / 2, point[i].getY() - size / 2,	//创建塔基的塔点
					size, size);
		}
		g.drawString("" + towername[0] + "座", point[count - 1].getX(),
				point[count - 1].getY() + 30);
		g.drawString("" + towername[1] + "座", point[2 * count - 1].getX(),
				point[count - 1].getY() + 30);
		g.drawString("" + towername[2] + "座", point[3 * count - 1].getX(),
				point[count - 1].getY() + 30);

		g.drawString("将全部盘子从" + towername[0] + "座搬运到" + towername[1] + "座或"
				+ towername[2] + "座", point[count - 1].getX(), point[count - 1]
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
				startX = disk.getBounds().x;									//获取盘子的横坐标
				startY = disk.getBounds().y;									//获取盘子的纵坐标
				rect = disk.getBounds();										//表示组件边界的矩形
				for (int i = 0; i < 3 * count; i++) {						
					int x = point[i].getX();
					int y = point[i].getY();																		
					if (rect.contains(x, y)) {
						startI = i;												//获取鼠标单击是哪个盘子
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
	public void mouseDragged(MouseEvent e) {							//拖拉鼠标

		Disk disk = null;
		if (e.getSource() instanceof Disk) {
			disk = (Disk) e.getSource();
			move = true;
			e = SwingUtilities.convertMouseEvent(disk, e, this);			//将鼠标事件从盘子转到当前面板上
		}
		if (e.getSource() == this) {
			if (move && disk != null) {
				x = e.getX();
				y = e.getY();
				if (disk.isTopHaving() == false)
					disk.setLocation(x - disk.getWidth() / 2, y- disk.getHeight() / 2);
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {						//释放鼠标
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
					x = point[i].getX();							//获取塔点的横坐标
					y = point[i].getY();							//获取塔点的纵坐标
					if (rect.contains(x, y)) {						
						containTowerPoint = true;					
						endI = i;									//获取盘子释放时的塔点
						break; 
					}
				}
			}
			if (disk != null && containTowerPoint) {
				if (point[endI].ishaving() == true) {					//盘子没拿走
					
					disk.setLocation(startX, startY);					//放回原地
				} else {
					//如果是塔座的最低点，可直接放上盘子
					if (endI == count - 1 || endI == 2 * count - 1
							|| endI == 3 * count - 1) {
						point[endI].deposit(disk, this);				//在该塔点上放上盘子

						if (startI != count - 1 && startI != 2 * count - 1
								&& startI != 3 * count - 1) {
							(point[startI + 1].getDisk()).setTopHaving(false);			//盘子已经被取走
							point[startI].setHaving(false);								//盘子已经被取走
						} else {
							point[startI].setHaving(false);
						}
					} else {
						//判断下面是否有盘子
						if (point[endI + 1].ishaving() == true) {
							Disk tempDisk = point[endI + 1].getDisk();
							//如果上面的盘子比下面的盘子小，可以放上盘子
							if ((tempDisk.getNumber() - disk.getNumber()) >= 1) {
								point[endI].deposit(disk, this);
								if (startI != count - 1
										&& startI != 2 * count - 1
										&& startI != 3 * count - 1) {
									(point[startI + 1].getDisk()).setTopHaving(false);	//盘子已经被取走
									point[startI].setHaving(false);						//盘子已经被取走
									tempDisk.setTopHaving(true);						//endI+1位置的上方endI的盘子就是刚刚放上的盘子
								} else {
									point[startI].setHaving(false);						//该方向的盘子已经被取完
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
	public void autoCarry(int count, char one, char two, char three) {
		if (count == 1) {
			textArea.append("" + one + "座"+" 到: " + three + "座\n");
			Disk disk = getTopDisk(one);
			int startI = getTopPosition(one);
			int endI = getSupremePosition(three);
			if (disk != null) {
				point[endI].deposit(disk, this);
				point[startI].setHaving(false);
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
		} else {
			autoCarry(count - 1, one, three, two);									//递归
			textArea.append("" + one +"座"+ " 到: " + three + "座\n");
			Disk disk = getTopDisk(one);
			int startI = getTopPosition(one);										//在塔中获取最上面盘子的位置
			int endI = getSupremePosition(three);									//在塔中获取最上面盘子的上方位置
			if (disk != null) {
				point[endI].deposit(disk, this);
				point[startI].setHaving(false);
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			autoCarry(count - 1, two, one, three);								
		}
	}

	public Disk getTopDisk(char name) {												//在塔中获取最上面的盘子
		Disk disk = null;
		if (name == towername[0]) {													//第一个塔座
			for (int i = 0; i < count; i++) {
				if (point[i].ishaving() == true) {
					disk = point[i].getDisk();
					break;
				}
			}
		}
		if (name == towername[1]) {													//第二个塔座
			for (int i = count; i < 2 * count; i++) {
				if (point[i].ishaving() == true) {
					disk = point[i].getDisk();
					break;
				}
			}
		}
		if (name == towername[2]) {													//第三个塔座
			for (int i = 2 * count; i < 3 * count; i++) {
				if (point[i].ishaving() == true) {
					disk = point[i].getDisk();
					break;
				}
			}
		}
		return disk;
	}

	public int getSupremePosition(char name) {										//在塔中获取最上面盘子的上方位置
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

	public int getTopPosition(char name) {											//在塔中获取最上面盘子的位置
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
