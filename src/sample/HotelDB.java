package sample;

import java.sql.*;
import java.util.ArrayList;

public class HotelDB {
    private static Connection connectToDB() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:HotelSQL.db");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void insertBooking(String userName,HotelRoom room,String begin, String end){
        Connection conn = connectToDB();
        try {
            Statement st = conn.createStatement();
            //st.executeUpdate("insert into bookings values('"+userName+"','" + ? +"','" + begin + "','" + end + "';");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deleteBooking(String userName, HotelRoom room, String begin){

    }

    public static void insertReview(Review review, Hotel hotel){

    }

    public static void deleteReview(String userName, Hotel hotel){

    }

    public static ArrayList<Review> getReviews(Hotel hotel){
        ArrayList<Review> reviews = new ArrayList<Review>();
        return reviews;
    }

    public static ArrayList<Booking> getBookings(HotelRoom room){
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        return bookings;
    }

    public static void main(String[] args) {

    }
}
