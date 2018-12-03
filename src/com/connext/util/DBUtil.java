package com.connext.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private DBUtil() {}
	private final static String URL = "jdbc:mysql://localhost:3306/javademo?useUnicode=true&characterEncoding=UTF8";
	private final static String NAME = "root";
	private final static String PWD = "123456";
	
	public static Connection getConnection()
	{
		Connection conn = null;
		try{
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(URL, NAME, PWD);
            return conn;
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return null;
	}
	public static void  main(String[] args) {
		DBUtil db=new DBUtil();
		db.getConnection();
	}
}
