package org.jdbc;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	public class TestJDBC {
		public static void main(String[] args) {
			ResultSet rs = null;
			Statement stmt = null;
			Connection conn = null;
			try {
				/* ���ز�ע��MySQL��JDBC���� */
				Class.forName("com.mysql.jdbc.Driver");
				/* ������MySQL���ݿ������*/
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/xscj", "root", "123456");
				/* �������ݿ⣬ִ��SQL���	*/
				stmt = conn.createStatement();
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
						rs.close();					// �ر�ResultSet����
						rs = null;
					}
					if(stmt != null) {
						stmt.close();				// �ر�Statement����
						stmt = null;
					}
					if(conn != null) {
						conn.close();				// �ر�Connection����
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

