package com.farmdirect.util;
import java.sql.*;
public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/farm_direct?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Change this to your MySQL password.
    static { try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException e) { throw new RuntimeException(e); } }
    public static Connection getConnection() throws SQLException { return DriverManager.getConnection(URL, USER, PASSWORD); }
}