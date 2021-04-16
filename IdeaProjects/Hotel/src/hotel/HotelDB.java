package hotel;

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

    public static ArrayList<HotelRoom> getHotels(String location, Date begin, Date end, int count, double minprice, double maxprice, String type) {
        Connection conn = connectToDB();
        ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from hotelrooms inner join hotels on hotelid = id where location like " + location +
                                            " and price between " + minprice + " and " + maxprice +
                                            " and roomtype like " + type);
            while (rs.next()) {
                //má bæta (ekki optimal skipting)
                ResultSet reviews = st.executeQuery("select count(*) from bookings where hotelid = " + rs.getString("hotelid") +
                        " and roomtype = " + rs.getString("roomtype") +
                        " and (checkin between " + begin + " and " + end +
                        " or checkout between " + begin + " and " + end + ")");
                if(rs.getInt("roomcount") - reviews.getInt(0) >= count){
                    Hotel hotel = new Hotel(rs.getString("name"),location);
                    rooms.add(new HotelRoom(hotel,rs.getString("roomtype"),rs.getDouble("price")));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return rooms;
    }
}


