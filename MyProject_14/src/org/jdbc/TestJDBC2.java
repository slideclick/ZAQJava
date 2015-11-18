package org.jdbc;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	public class TestJDBC2 {
		public static void main(String[] args) {
			ResultSet rs = null;
			Statement stmt = null;
			Connection conn = null;
			try {
				/**********���ز�ע��MySQL��JDBC����***********/
				Class.forName("com.mysql.jdbc.Driver");
				/**********������MySQL���ݿ������***************/
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/xscj", "root", "123456");
				/***********�������ݿ⣬ִ��SQL���***************/
				stmt = conn.createStatement();
				/**********��Ӽ�¼********************************/
				System.out.println("��Ӽ�¼��:");
				String sql1 = "insert into xs values (100014, '�ۻ�', '��ľ����')";
				stmt.executeUpdate(sql1);
				rs = stmt.executeQuery("select * from xs");
				while(rs.next()) {
					System.out.println(rs.getInt("id"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("profession"));
				}
				/**********�޸ļ�¼*******************************/
				System.out.println("�޸ļ�¼��:");
				String sql2 = "update xs set name = '����' where id = 100014";
				stmt.executeUpdate(sql2);
				rs = stmt.executeQuery("select * from xs");
				while(rs.next()) {
					System.out.println(rs.getInt("id"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("profession"));
				}
				System.out.println("ɾ����¼��:");
				/*********ɾ����¼*****************************/
				String sql3 = "delete from xs where id = 100014";
				stmt.executeUpdate(sql3);
				rs = stmt.executeQuery("select * from xs");
				while(rs.next()) {
					System.out.println(rs.getInt("id"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("profession"));
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) {
						rs.close();						// �ر�ResultSet����
						rs = null;
					}
					if(stmt != null) {
						stmt.close();					// �ر�Statement����
						stmt = null;
					}
					if(conn != null) {
						conn.close();					// �ر�Connection����
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

