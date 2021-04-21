package sample;

import java.sql.*;

public class UserDB {
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

    public String insertUser(String userName, String email, String password){
        Connection conn = connectToDB();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            boolean available_email = true;
            boolean available_password = true;
            boolean available_username = true;
            while(rs.next()){
                if(rs.getString("username").equals(userName)) available_username = false;
                if(rs.getString("email").equals(email)) available_email = false;
                if(rs.getString("password").equals(password)) available_password = false;
            }
            if(available_email && available_password && available_username) {
                st.executeUpdate("insert into users values('" + userName + "','" + email + "','" + password + "');");
                return "0";
            }
            String status = "1";
            if(!available_username) status += 'u';
            if(!available_email) status += 'e';
            if(!available_password) status += 'p';
            return status;
        }  catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally{
            closeConnection(conn);
        }
        return "-1";
    }

    public boolean logInUser(String userName, String password){
        Connection conn = connectToDB();
        boolean logInStatus = false;
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from users where username like '" + userName + "' and password like '" + password + "';");
            while(rs.next()){
                logInStatus = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally{
            closeConnection(conn);
        }
        return logInStatus;
    }

    public static void main(String[] args) {

    }
}
