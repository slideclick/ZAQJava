package org.jdbc;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.PreparedStatement;
	public class UseJDBC {
		public static void main(String[] args) {
			ResultSet rs = null;
			Statement stmt = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/*  ���ز�ע��MySQL��JDBC����  */
				Class.forName("com.mysql.jdbc.Driver");
				/* ������MySQL���ݿ��URL   */
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mysql", "root", "123456");
				/*  �������ݿ⣬ִ��SQL���  */
				stmt = conn.createStatement();
				stmt.executeUpdate("create database company");	// �������ݿ�
				stmt.executeUpdate("use company");			// ʹcompany��Ϊ��ǰ���ݿ�
				/*  ������ṹ   */
				stmt.executeUpdate("create table employee(id int(6) not null primary key,name char(10) not null,salary float(10))");
				/*����sql��������б��� */
				stmt.addBatch("insert into employee values (200001, '����',3000)");			
				stmt.addBatch("insert into employee values (200002, '����',3200)");
				stmt.addBatch("insert into employee values (200003, '�����',4000)");
				stmt.addBatch("insert into employee values (200004, '����',2500)");
				stmt.addBatch("insert into employee values (200005, '��ǿ',2800)");
				stmt.executeBatch();							// ��������
				conn.commit();								// �ύ����
				rs = stmt.executeQuery("select * from employee");
				while(rs.next()) {
					System.out.print(rs.getInt("id"));
					System.out.print(rs.getString("name"));
					System.out.print(rs.getString("salary"));
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
						conn.close();						// �ر�Connection����
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

