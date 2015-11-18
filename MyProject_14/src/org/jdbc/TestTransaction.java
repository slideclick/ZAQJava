package org.jdbc;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	public class TestTransaction {
		public static void main(String[] args) {
			ResultSet rs = null;
			Connection conn = null;
			Statement stmt = null;
			try {
				/*  ���ز�ע��MySQL��JDBC����  */
				Class.forName("com.mysql.jdbc.Driver");
				/* ������MySQL���ݿ������  */
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/xscj", "root", "123456");
				conn.setAutoCommit(false);						// �����Զ��ύ
				/*  �������ݿ⣬ִ��SQL���  */
				stmt = conn.createStatement();
				stmt.addBatch("insert into xs values (100006, '����', '�����')");
				stmt.addBatch("insert into xs values (100007, '����', 'ͨ�Ź���')");
				stmt.addBatch("insert into xs values (100008, '��ΰ', '�ٴ�ҽѧ')");
				stmt.addBatch("insert into xs values (100009, '��ޱ', '���ﻯѧ')");
				stmt.addBatch("insert into xs values (100010, '�޷�', '��е���')");
				stmt.executeBatch();							// �ύһ������
				conn.commit();												
				conn.setAutoCommit(true);						// �����Զ��ύ
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from xs");
				while(rs.next()) {
					System.out.print(rs.getInt("id"));
					System.out.print(rs.getString("name"));
					System.out.print(rs.getString("profession"));
					System.out.println();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					if (conn != null) {
						conn.rollback();						// �ع�����
						conn.setAutoCommit(true);				// �����Զ��ύ
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					if(rs != null) {
						rs.close();							// �ر�ResultSet����
						rs = null;
					}
					if(stmt != null) {
						stmt.close();						// �ر�Statement����
						stmt = null;
					}
					if(conn != null) {
						conn.close();						// �ر�Connection����
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

