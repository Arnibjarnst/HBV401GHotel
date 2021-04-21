package sample;

import javafx.scene.control.TableView;

import java.sql.*;
import java.util.ArrayList;

public class HotelDB {
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

    public int insertBooking(String userName,HotelRoom room,String begin, String end, int count){
        Connection conn = connectToDB();
        try {
            Statement st = conn.createStatement();
            Statement st2 = conn.createStatement();
            ResultSet rs = st2.executeQuery("select id from hotels where name like '" + room.getHotel().getName() + "'");
            rs.next();
            int id = rs.getInt("id");

            rs = st2.executeQuery("select sum(persons) " +
                    "from bookings natural join hotelrooms " +
                    "where hotelid = " + id +
                    " and roomtype like '" + room.getType() + "' " +
                    " and checkin <= '" + end +
                    "' and checkout >= '" + begin + "';");
            rs.next();
            int num = rs.getInt(1);
            System.out.println(room.getCount() +" " + num);
            if(room.getCount() - num < count){
                return room.getCount()-num;
            }
            for(int i = 0; i < count; i++) {
                System.out.println(i);
                System.out.println(begin + " " + end);
                st.executeUpdate("insert into bookings values( "+ id + " ,'" + userName + "','" + room.getType() + "','" + begin + "','" + end + "');");
            }
            return room.getCount() - num;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally{
            closeConnection(conn);
        }
        return -1;
    }

    public void insertReview(Review review, Hotel hotel){
        Connection conn = connectToDB();
        try {
            Statement st = conn.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally{
            closeConnection(conn);
        }
    }

    public void deleteReview(String userName, Hotel hotel){
        Connection conn = connectToDB();
        try {
            Statement st = conn.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally{
            closeConnection(conn);
        }
    }

    public ArrayList<Review> getReviews(Hotel hotel){
        ArrayList<Review> reviews = new ArrayList<Review>();
        Connection conn = connectToDB();
        try {
            Statement st = conn.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally{
            closeConnection(conn);
        }
        return reviews;
    }

}
