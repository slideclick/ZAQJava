package org.swing;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import javax.swing.event.*;
	import javax.swing.tree.*; 				// 树型视图JTree类的定义在javax.swing.tree包中
	public class JTreeTest {
		JFrame f = new JFrame("树型视图JTree的用法");
		JScrollPane jsp = new JScrollPane();
		JPanel jp = new JPanel(new GridLayout(3, 1, 5, 20));
		Font ft = new Font("Serif", Font.BOLD, 18);
		JTree tr; 						// 定义一个树型视图对象
		void go() {
			// 定义节点类的对象，root表示根节点，node1代表子节点，node11代表孙节点
			DefaultMutableTreeNode root, node1, node11;
			f.getContentPane().add("Center", jsp);
			jp.setBackground(Color.white);
			root = new DefaultMutableTreeNode("学校"); 		// 创建根节点
			// 在根节点下面加入子节点node1，其数据为"南京师范大学"
			root.add(node1 = new DefaultMutableTreeNode("南京师范大学"));
			// 在node1下面加入子节点node11，其数据为"数科院"
			node1.add(node11 = new DefaultMutableTreeNode("数科院"));
			// 在node11下面加入子节点，其数据为"计算机系"
			node11.add(new DefaultMutableTreeNode("计算机系"));
			// 在node11下面加入子节点，其数据为"软件工程系"
			node11.add(new DefaultMutableTreeNode("软件工程系"));
			// 在node11下面加入子节点，其数据为"数学系"
			node11.add(new DefaultMutableTreeNode("数学系"));
			node1.add(node11 = new DefaultMutableTreeNode("文学院"));
			node11.add(new DefaultMutableTreeNode("古代文学系"));
			node11.add(new DefaultMutableTreeNode("现代文学系"));
			root.add(node1 = new DefaultMutableTreeNode("东南大学"));
			node1.add(node11 = new DefaultMutableTreeNode("建筑学院"));
			node11.add(new DefaultMutableTreeNode("设计系"));
			node11.add(new DefaultMutableTreeNode("材料系"));
			node11.add(new DefaultMutableTreeNode("力学系"));
			node1.add(node11 = new DefaultMutableTreeNode("计算机学院"));
			node11.add(new DefaultMutableTreeNode("网络系"));
			node11.add(new DefaultMutableTreeNode("计算机安全系"));
			node1 = new DefaultMutableTreeNode("河海大学");
			root.add(node1);
			tr = new JTree(root); 					// 以root作为根节点，创建树型视图
			tr.setFont(ft); 						// 设置树型视图的显示字体
			tr.setShowsRootHandles(true);
			jsp.getViewport().add(tr); 				// 将树型视图加到滚动容器jsp中
			f.setSize(400, 350);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// 关闭窗体
			f.setVisible(true);
		}
		public static void main(String arg[]) {
			JTreeTest that = new JTreeTest();
			that.go();
		}
	}
