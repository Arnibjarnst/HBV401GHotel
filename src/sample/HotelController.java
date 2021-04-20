package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class HotelController {
    private Hotel hotel;
    private ArrayList<HotelRoom> rooms;

    private HotelDB db;

    @FXML
    private ListView<HotelRoom> fxRooms;
    @FXML
    private ListView<Review> fxReviews;
    @FXML
    private Label fxLabel;
    @FXML
    private DatePicker fxStartDate;
    @FXML
    private DatePicker fxEndDate;
    @FXML
    private TextField fxRoomCnt;

    public HotelController(){
        db = new HotelDB();
    }

    public void bookHotelHandler(ActionEvent actionEvent){
        fxLabel.setText("");
        if(MainController.userName.length() == 0){
            fxLabel.setText("Log in to book a room");
            return;
        }
        if(fxStartDate.getValue() == null || fxEndDate.getValue() == null){
            fxLabel.setText("Must pick a booking date and end date");
            return;
        }
        if(fxStartDate.getValue().compareTo(fxEndDate.getValue()) >= 0){
            fxLabel.setText("Start must be before end");
            return;
        }
        String begin = fxStartDate.getValue().toString();
        String end = fxEndDate.getValue().toString();
        if(fxRooms.getSelectionModel().getSelectedItem() == null){
            fxLabel.setText("please select a room type");
            return;
        }
        int x = Integer.MAX_VALUE;
        try{
            x = Integer.parseInt(fxRoomCnt.getText());
            if(fxRoomCnt.getText().equals("") || x <= 0){
                fxLabel.setText("Please specify how many rooms you'd like, must be a positive integer");
                return;
            }
        } catch (Exception e){
            fxLabel.setText("Please specify how many rooms you'd like, must be a positive integer");
            System.out.print(e);
            return;
        }
        HotelRoom room = fxRooms.getSelectionModel().getSelectedItem();
        int status = db.insertBooking(MainController.userName,room,begin,end,x);
        if(status >= x){
            fxLabel.setText("Booking successful");
        }
        else if(status == -1){
            fxLabel.setText("unkown error");
        }
        else if(status == 0){
            fxLabel.setText("no rooms available");
        }
        else{
            fxLabel.setText("only " + status + " rooms available");
        }
    }

    public void logInHandler(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Log In");
        stage.setScene(new Scene(root, 300, 400));
        stage.show();
    }

    public void signUpHandler(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Sign Up");
        stage.setScene(new Scene(root, 300, 400));
        stage.show();
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

    /*
    public void addBooking(String userName, HotelRoom room, String begin, String end){
        db.insertBooking(userName,room,begin,end);
    }
    */

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
        fxRooms.setItems(list);
    }

    public void setReviews(Hotel hotel){
        ArrayList<Review> reviews = getReviews(hotel);
        ObservableList<Review> list = FXCollections.observableArrayList(reviews);
        fxReviews.setItems(list);
    }
}
