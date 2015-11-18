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
				/*  加载并注册MySQL的JDBC驱动  */
				Class.forName("com.mysql.jdbc.Driver");
				/* 建立到MySQL数据库的连接  */
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/xscj", "root", "123456");
				conn.setAutoCommit(false);						// 禁用自动提交
				/*  访问数据库，执行SQL语句  */
				stmt = conn.createStatement();
				stmt.addBatch("insert into xs values (100006, '李明', '计算机')");
				stmt.addBatch("insert into xs values (100007, '赵琳', '通信工程')");
				stmt.addBatch("insert into xs values (100008, '吴伟', '临床医学')");
				stmt.addBatch("insert into xs values (100009, '张薇', '生物化学')");
				stmt.addBatch("insert into xs values (100010, '罗峰', '机械设计')");
				stmt.executeBatch();							// 提交一批命令
				conn.commit();												
				conn.setAutoCommit(true);						// 开启自动提交
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
						conn.rollback();						// 回滚事务
						conn.setAutoCommit(true);				// 开启自动提交
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					if(rs != null) {
						rs.close();							// 关闭ResultSet对象
						rs = null;
					}
					if(stmt != null) {
						stmt.close();						// 关闭Statement对象
						stmt = null;
					}
					if(conn != null) {
						conn.close();						// 关闭Connection对象
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

