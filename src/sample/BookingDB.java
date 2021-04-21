package sample;

import java.sql.*;
import java.util.ArrayList;

public class BookingDB {
    private Connection connectToDB() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:HotelSQL.db");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    private void closeConnection(Connection conn){
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
            ResultSet rs = st.executeQuery("select *,julianday(checkout)-julianday(checkin) as length" +
                                            " from bookings where username like '" + userName + "';");
            while(rs.next()){
                ResultSet rs2 = st2.executeQuery("select name,location from hotels where id = " + rs.getInt("hotelid"));
                rs2.next();
                Hotel hotel = new Hotel(rs2.getString("name"),rs2.getString("location"));
                rs2 = st2.executeQuery("select * from hotelrooms where hotelid = " + rs.getInt("hotelid") +
                                        " and roomtype like '" + rs.getString("roomtype") + "';");
                rs2.next();
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

    public void deleteBooking(String userName, HotelRoom room, String begin, String end){
        Connection conn = connectToDB();
        try {
            Statement st = conn.createStatement();
            Statement st2 = conn.createStatement();
            ResultSet rs = st2.executeQuery("select id from hotels where name like '" + room.getHotel().getName() + "'");
            rs.next();
            int id = rs.getInt("id");
            st.executeUpdate("delete from bookings where rowid = (select rowid from bookings where username like '" + userName + "' and hotelid = " + id +
                             " and roomtype like '" + room.getType() + "' and checkin = '" + begin + "' and checkout = '" + end + "');");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally{
            closeConnection(conn);
        }
    }
}
