package org.jdbc;
	import java.sql.*;
	public class TestDMLDemo {
		public static void main(String[] args) {
			ResultSet rs = null;
			Statement stmt = null;
			Connection conn = null;
			try {
				/* 加载并注册MySQL的JDBC驱动*/
				Class.forName("com.mysql.jdbc.Driver");
				/*建立到MySQL数据库的连接*/
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/xscj", "root", "123456");
				/* 访问数据库，执行SQL语句*/
				stmt = conn.createStatement();
				/*添加记录*/
				System.out.println("添加记录后:");
				String sql1 = "insert into student values (100019, '李计', 1,80,78)";
				String sql2 = "insert into student values (100022, '王燕', 0,69,85)";
				stmt.executeUpdate(sql1);
				stmt.executeUpdate(sql2);
				rs = stmt.executeQuery("select * from student");
				while(rs.next()) {
					System.out.print("学号:"+rs.getInt("id")+" ");
					System.out.print("姓名:"+rs.getString("name")+" ");
					System.out.print("性别:"+rs.getString("sex"));
					System.out.print("数学成绩:"+rs.getString("math")+" ");
					System.out.print("英语成绩:"+rs.getString("english")+" ");
					System.out.println();
				}
				/*修改记录*/
				System.out.println("修改记录后:");
				String sql3 = "update student set name = '王涛' where id = 100002";
				stmt.executeUpdate(sql3);
				rs = stmt.executeQuery("select * from student");
				while(rs.next()) {
					System.out.print("学号:"+rs.getInt("id")+" ");
					System.out.print("姓名:"+rs.getString("name")+" ");
					System.out.print("性别:"+rs.getString("sex"));
					System.out.print("数学成绩:"+rs.getString("math")+" ");
					System.out.print("英语成绩:"+rs.getString("english")+" ");
					System.out.println();
				}
				System.out.println("删除记录后:");
				/*删除记录*/
				String sql4 = "delete from student where id = 100001";
				stmt.executeUpdate(sql4);
				rs = stmt.executeQuery("select * from student");
				while(rs.next()) {
					System.out.print("学号:"+rs.getInt("id")+" ");
					System.out.print("姓名:"+rs.getString("name")+" ");
					System.out.print("性别:"+rs.getString("sex"));
					System.out.print("数学成绩:"+rs.getString("math")+" ");
					System.out.print("英语成绩:"+rs.getString("english")+" ");
					System.out.println();
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
