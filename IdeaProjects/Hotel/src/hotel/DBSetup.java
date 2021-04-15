package hotel;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

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
        File file = new File("Database.sql");
        Scanner myReader = null;
        try {
            myReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        myReader.useDelimiter("\\Z");
        String setupText = myReader.next();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(setupText);
            System.out.println("Database has been set up");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
