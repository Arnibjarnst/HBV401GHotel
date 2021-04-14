package sample;

import java.sql.*;
import java.util.ArrayList;

public class DBSetup {
    public static Connection connectToDB() {
        Connection conn = null;
        System.out.println("a");
        System.out.println("a");
        try {
            System.out.println("a");
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("a");
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = connectToDB();
    }
}
