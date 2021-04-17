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
        MainDB test = new MainDB();
        ArrayList<HotelRoom> rooms = test.getHotels("Las Vegas","2020-12-21","2020-12-25",1,10000,120000,"%");
        for(int i=0; i < rooms.size(); i++){
            Hotel hotel = rooms.get(i).hotel;
            System.out.println(rooms.get(i));
        }
    }
}
