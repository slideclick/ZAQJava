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
				/**********加载并注册MySQL的JDBC驱动***********/
				Class.forName("com.mysql.jdbc.Driver");
				/**********建立到MySQL数据库的连接***************/
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/xscj", "root", "123456");
				/***********访问数据库，执行SQL语句***************/
				stmt = conn.createStatement();
				/**********添加记录********************************/
				System.out.println("添加记录后:");
				String sql1 = "insert into xs values (100014, '邵辉', '土木工程')";
				stmt.executeUpdate(sql1);
				rs = stmt.executeQuery("select * from xs");
				while(rs.next()) {
					System.out.println(rs.getInt("id"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("profession"));
				}
				/**********修改记录*******************************/
				System.out.println("修改记录后:");
				String sql2 = "update xs set name = '王涛' where id = 100014";
				stmt.executeUpdate(sql2);
				rs = stmt.executeQuery("select * from xs");
				while(rs.next()) {
					System.out.println(rs.getInt("id"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("profession"));
				}
				System.out.println("删除记录后:");
				/*********删除记录*****************************/
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
						rs.close();						// 关闭ResultSet对象
						rs = null;
					}
					if(stmt != null) {
						stmt.close();					// 关闭Statement对象
						stmt = null;
					}
					if(conn != null) {
						conn.close();					// 关闭Connection对象
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

