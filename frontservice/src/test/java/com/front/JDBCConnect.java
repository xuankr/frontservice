package com.front;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by XKR on 2017/8/15.
 */
public class JDBCConnect {
    private static Connection connection;
    public static Connection  create(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/shop";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = conn;
        return conn;
    }
    public static Connection getConn() throws Exception {
        if(connection == null){
            create();
        }
        if(connection == null)
            throw new Exception("创建jdbc连接错误");
        return connection;
    }
}
