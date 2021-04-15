package sample;

import java.sql.*;
import java.util.ArrayList;



public class HotelDBold {

    private static Connection connectToDB() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:OurDataBase.db");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static ArrayList<Hotel> getHotels(int minprice, int maxprice) {
        Connection conn = connectToDB();
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Hotels where price between " + minprice + " and " + maxprice);
            while (rs.next()) {
                Hotel hotel = new Hotel(rs.getString(1));
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return hotels;
    }

}


