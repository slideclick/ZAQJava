package org.jdbc;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	public class TestPrepareStatement {
		public static void main(String[] args) {
			ResultSet rs = null;
			Statement stmt = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/* 加载并注册MySQL的JDBC驱动*/
				Class.forName("com.mysql.jdbc.Driver");
				/*  建立到MySQL数据库的连接  */
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/xscj", "root", "123456");
				/*  访问数据库，执行SQL语句 */
				stmt = conn.createStatement();
				pstmt = conn.prepareStatement("insert into xs values (?, ?, ?)");
				/*  添加第一条记录   */
				pstmt.setInt(1, 100003);
				pstmt.setString(2, "夏卫国");
				pstmt.setString(3, "基础物理");
				pstmt.executeUpdate();
				/*  添加第二条记录   */
				pstmt.setInt(1, 100004);
				pstmt.setString(2, "李方方");
				pstmt.setString(3, "通信工程");
				pstmt.executeUpdate();
				/*  添加第三条记录  */
				pstmt.setInt(1, 100005);
				pstmt.setString(2, "刘燕敏");
				pstmt.setString(3, "生物学");
				pstmt.executeUpdate();
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

