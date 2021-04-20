package sample;

import java.sql.*;
import java.util.ArrayList;

public class MainDB {

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

    public static ArrayList<HotelRoom> getHotels(String location, String begin, String end, int count, double minprice, double maxprice, String type) {
        if(location.equals("")) location = "%";
        if(type.equals("")) type = "%";
        Connection conn = connectToDB();
        ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
        try {
            Statement st = conn.createStatement();
            Statement st2 = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from hotelrooms inner join hotels on hotelid = id where location like '" + location +
                                            "' and price between " + minprice + " and " + maxprice +
                                            " and roomtype like '" + type + "'");
            while (rs.next()) {
                //má bæta (ekki optimal skipting)
                ResultSet reviews = st2.executeQuery("select count(*) from bookings where hotelid = " + rs.getInt("hotelid") +
                        " and roomtype like '" + rs.getString("roomtype") +
                        "' and checkin <= '" + end +
                        "' and checkout >= '" + begin + "'");
                if(rs.getInt("roomcount") - reviews.getInt(1) >= count){
                    Hotel hotel = new Hotel(rs.getString("name"),rs.getString("location"));
                    rooms.add(new HotelRoom(hotel,rs.getString("roomtype"),rs.getInt("roomcount"),rs.getDouble("price")));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return rooms;
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


