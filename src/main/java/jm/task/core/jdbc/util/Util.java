package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "58707851zss";
    static Connection connection = null;

    public Util() {
    }
    public String getURL() {
        return URL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
    public static Connection connect() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Подключено");
        } catch (SQLException var2) {
            System.err.println("Не подключено");
        }
        return connection;
    }
}
