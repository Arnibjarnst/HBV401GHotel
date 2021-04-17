package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class HotelController {
    private ArrayList<Hotel> hotels;
    private ArrayList<HotelRoom> rooms;

    private MainDB db;

    @FXML
    private TextField fxlocation;
    @FXML
    private TextField fxadults;
    @FXML
    private DatePicker fxcheckin;
    @FXML
    private DatePicker fxcheckout;
    @FXML
    private ListView<Hotel> fxhotels;
    @FXML
    private TextField fxminprice;
    @FXML
    private TextField fxmaxprice;

    public HotelController(){
        db = new MainDB();
    }

    public void addReview(int rating, String comment, String userName,Hotel hotel){
        Review review = new Review(rating,comment,userName);
        db.insertReview(review, hotel);
    }

    public void removeReview(String userName,Hotel hotel){
        db.deleteReview(userName,hotel);
    }

    public ArrayList<Review> getReviews(Hotel hotel){
        return db.getReviews(hotel);
    }

    public void addBooking(String userName, HotelRoom room, String begin, String end){
        db.insertBooking(userName,room,begin,end);
    }

    public void cancelBooking(String userName, HotelRoom room, String begin){
        db.deleteBooking(userName,room,begin);
    }

    public ArrayList<Booking> getBookings(HotelRoom room){
        return db.getBookings(room);
    }

}
