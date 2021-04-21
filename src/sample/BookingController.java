package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class BookingController {
    BookingDB db;

    @FXML
    private ListView fxBookings;
    @FXML
    private Label fxLabel;

    public BookingController(){
        db = new BookingDB();
    }

    public void setBookings(String userName){
        ArrayList<Booking> bookings = db.getBookings(userName);
        ObservableList<Booking> list = FXCollections.observableArrayList(bookings);
        fxBookings.setItems(list);
    }

    public void cancelBookingHandler(ActionEvent actionEvent){
        if(fxBookings.getSelectionModel().getSelectedItem() == null){
            fxLabel.setText("please select a booking to cancel");
            return;
        }
    }
}
