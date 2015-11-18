package org.jdbc;
	import java.sql.*;
	public class TestDMLDemo {
		public static void main(String[] args) {
			ResultSet rs = null;
			Statement stmt = null;
			Connection conn = null;
			try {
				/* ���ز�ע��MySQL��JDBC����*/
				Class.forName("com.mysql.jdbc.Driver");
				/*������MySQL���ݿ������*/
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/xscj", "root", "123456");
				/* �������ݿ⣬ִ��SQL���*/
				stmt = conn.createStatement();
				/*��Ӽ�¼*/
				System.out.println("��Ӽ�¼��:");
				String sql1 = "insert into student values (100019, '���', 1,80,78)";
				String sql2 = "insert into student values (100022, '����', 0,69,85)";
				stmt.executeUpdate(sql1);
				stmt.executeUpdate(sql2);
				rs = stmt.executeQuery("select * from student");
				while(rs.next()) {
					System.out.print("ѧ��:"+rs.getInt("id")+" ");
					System.out.print("����:"+rs.getString("name")+" ");
					System.out.print("�Ա�:"+rs.getString("sex"));
					System.out.print("��ѧ�ɼ�:"+rs.getString("math")+" ");
					System.out.print("Ӣ��ɼ�:"+rs.getString("english")+" ");
					System.out.println();
				}
				/*�޸ļ�¼*/
				System.out.println("�޸ļ�¼��:");
				String sql3 = "update student set name = '����' where id = 100002";
				stmt.executeUpdate(sql3);
				rs = stmt.executeQuery("select * from student");
				while(rs.next()) {
					System.out.print("ѧ��:"+rs.getInt("id")+" ");
					System.out.print("����:"+rs.getString("name")+" ");
					System.out.print("�Ա�:"+rs.getString("sex"));
					System.out.print("��ѧ�ɼ�:"+rs.getString("math")+" ");
					System.out.print("Ӣ��ɼ�:"+rs.getString("english")+" ");
					System.out.println();
				}
				System.out.println("ɾ����¼��:");
				/*ɾ����¼*/
				String sql4 = "delete from student where id = 100001";
				stmt.executeUpdate(sql4);
				rs = stmt.executeQuery("select * from student");
				while(rs.next()) {
					System.out.print("ѧ��:"+rs.getInt("id")+" ");
					System.out.print("����:"+rs.getString("name")+" ");
					System.out.print("�Ա�:"+rs.getString("sex"));
					System.out.print("��ѧ�ɼ�:"+rs.getString("math")+" ");
					System.out.print("Ӣ��ɼ�:"+rs.getString("english")+" ");
					System.out.println();
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
