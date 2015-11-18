package org.jdbc;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.PreparedStatement;
	public class TestBatch {
		public static void main(String[] args) {
			ResultSet rs = null;
			Connection conn = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			try {
				/* ���ز�ע��MySQL��JDBC����   */
				Class.forName("com.mysql.jdbc.Driver");
				/*  ������MySQL���ݿ������  */
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/xscj", "root", "123456");
				/*  �������ݿ⣬ִ��SQL���  */
				pstmt = conn.prepareStatement("insert into xs values (?, ?, ?)");
				pstmt.setInt(1, 100011);
				pstmt.setString(2, "������");
				pstmt.setString(3, "�����");
				pstmt.addBatch();
				pstmt.setInt(1, 100012);
				pstmt.setString(2, "����");
				pstmt.setString(3, "����ѧ");
				pstmt.addBatch();						// ����һ��SQL���
				pstmt.setInt(1, 100013);
				pstmt.setString(2, "����");
				pstmt.setString(3, "���Ͽ�ѧ");
				pstmt.addBatch();
				pstmt.executeBatch();						// ��������
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
			}finally {
				try {
					if(rs != null) {
						rs.close();						// �ر�ResultSet����
						rs = null;
					}
					if (pstmt != null) {
						pstmt.close();					// �ر�PreparedStatement����
						pstmt = null;
					}
					if(stmt != null) {
						stmt.close();					// �ر�Statement����
						stmt = null;
					}
					if (conn != null) {
						conn.close();					// �ر�Connection����
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

