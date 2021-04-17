package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class HotelController {
    private Hotel hotel;
    private ArrayList<HotelRoom> rooms;

    private HotelDB db;

    @FXML
    private ListView<HotelRoom> fxrooms;

    public HotelController(){
        db = new HotelDB();
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

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;

    }

    public void setRooms(ArrayList<HotelRoom> rooms) {
        this.rooms = rooms;
        ObservableList<HotelRoom> list = FXCollections.observableArrayList(rooms);
        fxrooms.setItems(list);
    }
}
