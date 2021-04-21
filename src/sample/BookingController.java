package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.awt.print.Book;
import java.util.ArrayList;

public class BookingController {
    BookingDB db;

    @FXML
    private ListView<Booking> fxBookings;
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
            fxLabel.setText("Select a booking to cancel");
            return;
        }
        Booking booking = fxBookings.getSelectionModel().getSelectedItem();
        db.deleteBooking(booking.getUserName(),booking.getRoom(),booking.getBegin(),booking.getEnd());
        setBookings(MainController.userName);
    }
}
