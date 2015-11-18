package org.swing;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	public class ListSwitchDemo {
			JFrame f = new JFrame("���������б�����Ŀ");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel(new GridLayout(2, 1, 5, 30));
			JPanel p3 = new JPanel();
			Button b1 = new Button(">>");
			Button b2 = new Button("<<");
			List l1 = new List(10,true);
			List l2 = new List(10,true);
			Font ft = new Font("Serif", Font.BOLD, 18);
			public static void main(String args[]) {
				ListSwitchDemo ls = new ListSwitchDemo();
				ls.go();
			}
			void go() {
				f.setSize(500, 300);
				f.setLayout(new FlowLayout());					// ���ô������ʽ���ֹ�����
				f.add(p1);f.add(p2);f.add(p3);					// ��JPanel������뵽������
				l1.add("desk");l1.add("computer");l1.add("printer");		//���б���м�����Ŀ
				l1.add("pen");l1.add("book");l1.add("paper");			
				l1.setFont(ft);								// �����б������Ŀ������
				l2.add("yellow");l2.add("brown");l2.add("white");
				l2.add("pink");l2.add("red");l2.add("blue");
				l2.setFont(ft);
				p1.add(l1);p2.add(b1);p2.add(b2);
				b1.setFont(ft);b2.setFont(ft);
				p3.add(l2);
				b1.addActionListener(new ButtonHandler(l1, l2));		// ע���¼�������
				b2.addActionListener(new ButtonHandler(l2, l1));			
				l1.addMouseListener(new MouseHandler(l1, l2));
				l2.addMouseListener(new MouseHandler(l2, l1));
				f.addWindowListener(new WindowHandler());
				f.setVisible(true);
			}
			void exchange(List la, List lb) {
				String itm[];
				int idx[];
				itm = la.getSelectedItems();						// ��ȡѡ�е���
				idx = la.getSelectedIndexes();					// ��ȡѡ�е�����
				int i = idx.length;
				for(int k =0; k<i;k++){
					lb.add(itm[k]);
					la.remove(idx[k]);
				}
			}
			class ButtonHandler implements ActionListener {
				List la, lb;
				ButtonHandler(List la, List lb) {
					this.la = la;
					this.lb = lb;
				}
				public void actionPerformed(ActionEvent e) {			// ���������б������Ŀ
					exchange(la, lb);
				}
			}
			class MouseHandler extends MouseAdapter {
				List la, lb;
				MouseHandler(List la, List lb) {
					this.la = la;
					this.lb = lb;
				}
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2)
						exchange(la, lb);
				}
			}	
			class WindowHandler extends WindowAdapter {			// �رմ���
				public void windowClosing(WindowEvent e) {
					System.exit(-1);
				}
			}
	}

