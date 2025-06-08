package com.example.projectmysql.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.43.65:3306/telescope_store",
                    "androiduser1", "123456"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}