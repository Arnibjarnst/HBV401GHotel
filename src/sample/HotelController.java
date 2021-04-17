package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.input.*;
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
    @FXML
    private TextField fxminprice;
    @FXML
    private TextField fxmaxprice;

    public HotelController(){
        db = new HotelDB();
    }

    public void searchHotelHandler(ActionEvent actionEvent){
        String loc = fxlocation.getText();

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

        int count = 1;
        try{
            count = Integer.parseInt(fxadults.getText());
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }

        double minprice = 0;
        try{
            minprice = Integer.parseInt(fxminprice.getText());
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }

        double maxprice = Integer.MAX_VALUE;
        try{
            maxprice = Integer.parseInt(fxmaxprice.getText());
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }

        rooms = searchHotels(loc,begin,end,count,minprice,maxprice, "");
        hotels = new ArrayList<Hotel>();
        for(int i=0;i<rooms.size();i++){
            if(!hotels.contains(rooms.get(i).getHotel())){
                hotels.add(rooms.get(i).getHotel());
            }
        }
        ObservableList<Hotel> list = FXCollections.observableArrayList(hotels);
        fxhotels.setItems(list);
    }

    /*
    fxhotels.setOnMouseClicked(new EventHandler<MouseEvent>)() {

        @Override
        public void handle(MouseEvent click) {

            if (click.getClickCount() == 2) {
                //Use ListView's getSelected Item
                Hotel currentItemSelected = fxhotels.getSelectionModel().getSelectedItem();
                //use this to do whatever you want to. Open Link etc.
            }
        }
    });
    */

    @FXML
    public void chooseHotelHandler(MouseEvent click){
        if(click.getClickCount() == 2) {
            Hotel currHotel = fxhotels.getSelectionModel().getSelectedItem();
            System.out.println(currHotel);
        }
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
