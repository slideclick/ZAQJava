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
				/*  加载并注册MySQL的JDBC驱动  */
				Class.forName("com.mysql.jdbc.Driver");
				/* 建立到MySQL数据库的URL   */
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mysql", "root", "123456");
				/*  访问数据库，执行SQL语句  */
				stmt = conn.createStatement();
				stmt.executeUpdate("create database company");	// 创建数据库
				stmt.executeUpdate("use company");			// 使company成为当前数据库
				/*  创建表结构   */
				stmt.executeUpdate("create table employee(id int(6) not null primary key,name char(10) not null,salary float(10))");
				/*加入sql命令到命令列表中 */
				stmt.addBatch("insert into employee values (200001, '王林',3000)");			
				stmt.addBatch("insert into employee values (200002, '程明',3200)");
				stmt.addBatch("insert into employee values (200003, '李红庆',4000)");
				stmt.addBatch("insert into employee values (200004, '王敏',2500)");
				stmt.addBatch("insert into employee values (200005, '林强',2800)");
				stmt.executeBatch();							// 批量处理
				conn.commit();								// 提交事务
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
						conn.rollback();				  		// 事务回滚
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

