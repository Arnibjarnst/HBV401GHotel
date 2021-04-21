package sample;

import java.sql.*;
import java.util.ArrayList;

public class BookingDB {
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

    private static void closeConnection(Connection conn){
        try{
            if(conn != null)
                conn.close();
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }

    public ArrayList<Booking> getBookings(String userName){
        Connection conn = connectToDB();
        ArrayList<Booking> bookings = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            Statement st2 = conn.createStatement();
            ResultSet rs = st.executeQuery("select *,julianday(checkout)-julianday(checkout) as length" +
                                            " from bookings where username like '" + userName + "';");
            while(rs.next()){
                System.out.println(rs.getString("hotelid"));
                ResultSet rs2 = st2.executeQuery("select name,location from hotels where id = " + rs.getInt("hotelid"));
                rs2.next();
                Hotel hotel = new Hotel(rs2.getString("name"),rs2.getString("location"));
                System.out.println(hotel + " " + rs.getString("roomtype"));
                rs2 = st2.executeQuery("select * from hotelrooms where hotelid = " + rs.getInt("hotelid") +
                                        " and roomtype like '" + rs.getString("roomtype") + "';");
                rs2.next();
                System.out.println(rs2.getString("price"));
                HotelRoom room = new HotelRoom(hotel,rs2.getString("roomtype"),rs2.getInt("roomcount"),rs2.getDouble("price"));
                bookings.add(new Booking(room,userName,rs.getString("checkin"),rs.getString("checkout"),rs.getInt("length")*room.getPrice()));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally{
            closeConnection(conn);
        }
        return bookings;
    }
}
