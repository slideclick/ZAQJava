package org.jdbc;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.PreparedStatement;
	public class UseJDBC2 {
		public static void main(String[] args) {
			ResultSet rs = null;
			Statement stmt = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				/**********加载并注册MySQL的JDBC驱动************/
				Class.forName("com.mysql.jdbc.Driver");
				/**********建立到MySQL数据库的URL***************/
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mysql", "root", "123456");
				conn.setAutoCommit(false);		
				/***********访问数据库，执行SQL语句***************/
				stmt = conn.createStatement();
				stmt.executeUpdate("create database bookstore");		// 创建数据库
				stmt.executeUpdate("use bookstore");				// 使bookstore成为当前数据库
				/************创建表结构****************************/
				stmt.executeUpdate("create table books(id int(4) not null primary key,title char(20) not null,price float(4,2) not null)");
				/***********加入sql命令到命令列表中***************/
				stmt.addBatch("insert into books values (1001, 'Java实用教程',39.00)");			
				stmt.addBatch("insert into books values (1002, 'Jsp网站编程',49.00)");
				stmt.addBatch("insert into books values (1003, 'Struts2核心编程',58.00)");
				stmt.addBatch("insert into books values (1004, 'Hibernate必备宝典 ',89.00)");
				stmt.addBatch("insert into books values (1005, 'C程序设计',35.00)");
				stmt.executeBatch();							// 批量处理
				conn.commit();								// 提交事务
				rs = stmt.executeQuery("select * from books");
				while(rs.next()) {
					System.out.print(rs.getInt("id"));
					System.out.print(rs.getString("title"));
					System.out.print(rs.getString("price"));
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
						conn.close();						//关闭Connection对象
						conn = null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

