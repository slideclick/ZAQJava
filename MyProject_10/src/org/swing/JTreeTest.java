package org.swing;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import javax.swing.event.*;
	import javax.swing.tree.*; 				// ������ͼJTree��Ķ�����javax.swing.tree����
	public class JTreeTest {
		JFrame f = new JFrame("������ͼJTree���÷�");
		JScrollPane jsp = new JScrollPane();
		JPanel jp = new JPanel(new GridLayout(3, 1, 5, 20));
		Font ft = new Font("Serif", Font.BOLD, 18);
		JTree tr; 						// ����һ��������ͼ����
		void go() {
			// ����ڵ���Ķ���root��ʾ���ڵ㣬node1�����ӽڵ㣬node11������ڵ�
			DefaultMutableTreeNode root, node1, node11;
			f.getContentPane().add("Center", jsp);
			jp.setBackground(Color.white);
			root = new DefaultMutableTreeNode("ѧУ"); 		// �������ڵ�
			// �ڸ��ڵ���������ӽڵ�node1��������Ϊ"�Ͼ�ʦ����ѧ"
			root.add(node1 = new DefaultMutableTreeNode("�Ͼ�ʦ����ѧ"));
			// ��node1��������ӽڵ�node11��������Ϊ"����Ժ"
			node1.add(node11 = new DefaultMutableTreeNode("����Ժ"));
			// ��node11��������ӽڵ㣬������Ϊ"�����ϵ"
			node11.add(new DefaultMutableTreeNode("�����ϵ"));
			// ��node11��������ӽڵ㣬������Ϊ"�������ϵ"
			node11.add(new DefaultMutableTreeNode("�������ϵ"));
			// ��node11��������ӽڵ㣬������Ϊ"��ѧϵ"
			node11.add(new DefaultMutableTreeNode("��ѧϵ"));
			node1.add(node11 = new DefaultMutableTreeNode("��ѧԺ"));
			node11.add(new DefaultMutableTreeNode("�Ŵ���ѧϵ"));
			node11.add(new DefaultMutableTreeNode("�ִ���ѧϵ"));
			root.add(node1 = new DefaultMutableTreeNode("���ϴ�ѧ"));
			node1.add(node11 = new DefaultMutableTreeNode("����ѧԺ"));
			node11.add(new DefaultMutableTreeNode("���ϵ"));
			node11.add(new DefaultMutableTreeNode("����ϵ"));
			node11.add(new DefaultMutableTreeNode("��ѧϵ"));
			node1.add(node11 = new DefaultMutableTreeNode("�����ѧԺ"));
			node11.add(new DefaultMutableTreeNode("����ϵ"));
			node11.add(new DefaultMutableTreeNode("�������ȫϵ"));
			node1 = new DefaultMutableTreeNode("�Ӻ���ѧ");
			root.add(node1);
			tr = new JTree(root); 					// ��root��Ϊ���ڵ㣬����������ͼ
			tr.setFont(ft); 						// ����������ͼ����ʾ����
			tr.setShowsRootHandles(true);
			jsp.getViewport().add(tr); 				// ��������ͼ�ӵ���������jsp��
			f.setSize(400, 350);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// �رմ���
			f.setVisible(true);
		}
		public static void main(String arg[]) {
			JTreeTest that = new JTreeTest();
			that.go();
		}
	}
