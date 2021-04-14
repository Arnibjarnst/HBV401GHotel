package sample;

import java.sql.*;
import java.util.ArrayList;

public class DBSetup {
    public static Connection connectToDB() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:HotelSQL.db");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void setup(String filename){

    }

    public static void main(String[] args) {
        Connection conn = connectToDB();
        System.out.println("hey.");
    }
}
