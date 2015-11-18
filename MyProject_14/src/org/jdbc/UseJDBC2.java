package org.jdbc;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.PreparedStatement;
	public class UseJDBC2 {
		public static void main(String[] args) {
			ResultSet rs = null;
			Statement stmt = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/**********���ز�ע��MySQL��JDBC����************/
				Class.forName("com.mysql.jdbc.Driver");
				/**********������MySQL���ݿ��URL***************/
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mysql", "root", "123456");
				conn.setAutoCommit(false);		
				/***********�������ݿ⣬ִ��SQL���***************/
				stmt = conn.createStatement();
				stmt.executeUpdate("create database bookstore");		// �������ݿ�
				stmt.executeUpdate("use bookstore");				// ʹbookstore��Ϊ��ǰ���ݿ�
				/************������ṹ****************************/
				stmt.executeUpdate("create table books(id int(4) not null primary key,title char(20) not null,price float(4,2) not null)");
				/***********����sql��������б���***************/
				stmt.addBatch("insert into books values (1001, 'Javaʵ�ý̳�',39.00)");			
				stmt.addBatch("insert into books values (1002, 'Jsp��վ���',49.00)");
				stmt.addBatch("insert into books values (1003, 'Struts2���ı��',58.00)");
				stmt.addBatch("insert into books values (1004, 'Hibernate�ر����� ',89.00)");
				stmt.addBatch("insert into books values (1005, 'C�������',35.00)");
				stmt.executeBatch();							// ��������
				conn.commit();								// �ύ����
				rs = stmt.executeQuery("select * from books");
				while(rs.next()) {
					System.out.print(rs.getInt("id"));
					System.out.print(rs.getString("title"));
					System.out.print(rs.getString("price"));
					System.out.println();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					if (conn != null) {
						conn.rollback();				  		// ����ع�
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
						conn.close();						//�ر�Connection����
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

