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
				/* 加载并注册MySQL的JDBC驱动   */
				Class.forName("com.mysql.jdbc.Driver");
				/*  建立到MySQL数据库的连接  */
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/xscj", "root", "123456");
				/*  访问数据库，执行SQL语句  */
				pstmt = conn.prepareStatement("insert into xs values (?, ?, ?)");
				pstmt.setInt(1, 100011);
				pstmt.setString(2, "马丽丽");
				pstmt.setString(3, "计算机");
				pstmt.addBatch();
				pstmt.setInt(1, 100012);
				pstmt.setString(2, "王玉");
				pstmt.setString(3, "心理学");
				pstmt.addBatch();						// 加入一条SQL语句
				pstmt.setInt(1, 100013);
				pstmt.setString(2, "孙研");
				pstmt.setString(3, "材料科学");
				pstmt.addBatch();
				pstmt.executeBatch();						// 批量更新
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
						rs.close();						// 关闭ResultSet对象
						rs = null;
					}
					if (pstmt != null) {
						pstmt.close();					// 关闭PreparedStatement对象
						pstmt = null;
					}
					if(stmt != null) {
						stmt.close();					// 关闭Statement对象
						stmt = null;
					}
					if (conn != null) {
						conn.close();					// 关闭Connection对象
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

