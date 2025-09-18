package edu.iuh.fit.bai03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_NAME = "QUANLYDIENTHOAI";
    private static final String URL = "jdbc:mariadb://localhost:3306/" + DB_NAME + "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "sapassword";
    private static final String DRIVER_CLASS = "org.mariadb.jdbc.Driver";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối MariaDB thành công!");
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy MariaDB JDBC Driver! Hãy chắc chắn bạn đã thêm file .jar vào thư viện.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Kết nối MariaDB thất bại! Kiểm tra URL, user, password.");
            e.printStackTrace();
        }
        return connection;
    }
}