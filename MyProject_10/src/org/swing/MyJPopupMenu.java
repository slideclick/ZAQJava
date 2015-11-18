package org.swing;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MyJPopupMenu extends JFrame {
		JMenu fileMenu;
		JPopupMenu jPopupMenuOne;
		JMenuItem openFile, closeFile, exit;
		JRadioButtonMenuItem copyFile, pasteFile;
		ButtonGroup buttonGroupOne;
		public MyJPopupMenu() {
			jPopupMenuOne = new JPopupMenu();		// 创建jPopupMenuOne对象
			buttonGroupOne = new ButtonGroup();
			// 创建文件菜单及子菜单，并将子菜单添加到文件菜单中
			fileMenu = new JMenu("文件");
			openFile = new JMenuItem("打开");
			closeFile = new JMenuItem("关闭");
			fileMenu.add(openFile);
			fileMenu.add(closeFile);
			jPopupMenuOne.add(fileMenu);			// 将fileMenu菜单添加到弹出式菜单中
			jPopupMenuOne.addSeparator();			// 添加分割符
			copyFile = new JRadioButtonMenuItem("复制");
			pasteFile = new JRadioButtonMenuItem("粘贴");
			buttonGroupOne.add(copyFile);
			buttonGroupOne.add(pasteFile);
			jPopupMenuOne.add(copyFile);			// 将copyFile添加到jPopupMenuOne中
			jPopupMenuOne.add(pasteFile);			// 将pasteFile添加到jPopupMenuOne中
			jPopupMenuOne.addSeparator();
			exit = new JMenuItem("退出");
			jPopupMenuOne.add(exit);				// 将exit添加到jPopupMenuOne中
			MouseListener popupListener = new PopupListener(jPopupMenuOne);
			this.addMouseListener(popupListener);		// 向主窗口注册监听器
			this.setTitle("This is a JPopupMenu");
			this.setBounds(100, 100, 250, 150);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public static void main(String args[]) {
			new MyJPopupMenu();
		}
		//***********添加内部类，其扩展了MouseAdapter类，用来处理鼠标事件**********
		class PopupListener extends MouseAdapter {
			JPopupMenu popupMenu;
			PopupListener(JPopupMenu popupMenu) {
				this.popupMenu = popupMenu;
			}
			public void mousePressed(MouseEvent e) {
				showPopupMenu(e);
			}
			public void mouseReleased(MouseEvent e) {
				showPopupMenu(e);
			}
			private void showPopupMenu(MouseEvent e) {
				if (e.isPopupTrigger()) {			// 如果当前事件与鼠标事件相关，则弹出菜单
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}		
			}
		} 
}

