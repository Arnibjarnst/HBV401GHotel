package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class HotelController {
    private ArrayList<Hotel> hotels;
    private ArrayList<HotelRoom> rooms;

    private HotelDB db;

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

    public HotelController(){
        db = new HotelDB();
    }

    public void searchHotelHandler(ActionEvent actionEvent){
        String loc = fxlocation.getText();

        int count = 1;
        try{
            count = Integer.parseInt(fxadults.getText());
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }

        String begin = "1970-01-02";
        try{
            begin = fxcheckin.getValue().toString();
        } catch (NullPointerException e){
            System.out.println(e);
        }

        String end = "1970-01-01";
        try{
            end = fxcheckout.getValue().toString();
        } catch (NullPointerException e){
            System.out.println(e);
        }

        rooms = searchHotels(loc,begin,end,count,0,Integer.MAX_VALUE, "");
        hotels = new ArrayList<Hotel>();
        for(int i=0;i<rooms.size();i++){
            if(!hotels.contains(rooms.get(i).getHotel())){
                hotels.add(rooms.get(i).getHotel());
            }
        }
        ObservableList<Hotel> list = FXCollections.observableArrayList(hotels);
        fxhotels.setItems(list);
    }

    public ArrayList<HotelRoom> searchHotels(String location, String begin, String end, int count, double minprice, double maxprice, String type) {
        return db.getHotels(location, begin, end, count, minprice, maxprice, type);
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
