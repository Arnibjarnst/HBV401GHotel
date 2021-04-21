package sample;

import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.input.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainController {
    public static String userName;

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
    @FXML
    private CheckBox fxSingle;
    @FXML
    private CheckBox fxDouble;
    @FXML
    private CheckBox fxSuite;
    @FXML
    private CheckBox fxKing;
    @FXML
    private Button fxLogIn;
    @FXML
    private Button fxLogOut;
    @FXML
    private Button fxSignUp;
    @FXML
    private Button fxBookings;

    public MainController(){
        db = new MainDB();
        userName = "";
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
        CheckBox types[] = {fxSingle,fxDouble,fxSuite,fxKing};
        rooms = new ArrayList<>();
        for(int i=0;i<types.length;i++){
            if(types[i].isSelected()){
                rooms.addAll(searchHotels(loc,begin,end,count,minprice,maxprice, types[i].getText()));
            }
        }
        hotels = new ArrayList<Hotel>();
        for(int i=0;i<rooms.size();i++){
            if(!hotels.contains(rooms.get(i).getHotel())){
                hotels.add(rooms.get(i).getHotel());
            }
        }
        fxhotels.setItems(FXCollections.observableArrayList(hotels));
    }

    @FXML
    public void chooseHotelHandler(MouseEvent click) throws Exception {
        if(click.getClickCount() == 2) {
            Hotel currHotel = fxhotels.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HotelView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(currHotel.toString());
            stage.setScene(new Scene(root, 600, 600));
            stage.show();

            HotelController contr = loader.getController();
            ArrayList<HotelRoom> currRooms = new ArrayList<>();
            for(int i=0;i<rooms.size();i++){
                if(rooms.get(i).getHotel().toString().equals(currHotel.toString())){
                    currRooms.add(rooms.get(i));
                }
            }
            contr.setHotel(currHotel);
            contr.setRooms(currRooms);
        }
    }


    public ArrayList<HotelRoom> searchHotels(String location, String begin, String end, int count, double minprice, double maxprice, String type) {
        return db.getHotels(location, begin, end, count, minprice, maxprice, type);
    }

    public void logInHandler(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Log In");
        stage.setScene(new Scene(root, 300, 400));
        stage.show();
        stage.setOnHidden(e -> {
            if(userName.length() > 0){
                setState(true);
            }
            else{
                setState(false);
            }
            stage.close();
        });
    }

    public void signUpHandler(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Sign Up");
        stage.setScene(new Scene(root, 300, 400));
        stage.show();
        stage.setOnHidden(e -> {
            if(userName.length() > 0){
                setState(true);
            }
            else{
                setState(false);
            }
            stage.close();
        });
    }

    public void logOutHandler(ActionEvent actionEvent){
        userName = "";
        setState(false);
    }

    private void setState(boolean state){
        fxLogIn.setVisible(!state);
        fxLogOut.setVisible(state);
        fxSignUp.setVisible(!state);
        fxBookings.setVisible(state);
    }

    public void openBookingsHandler(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BookingView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Bookings");
        stage.setScene(new Scene(root, 650, 400));
        stage.show();

        BookingController contr = loader.getController();
        contr.setBookings(userName);
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
