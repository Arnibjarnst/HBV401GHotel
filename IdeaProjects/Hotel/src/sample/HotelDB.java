package sample;

import java.util.ArrayList;
import java.util.Date;

public interface HotelDB {
    ArrayList<HotelRoom> getHotels(double minprice, double maxprice,String location);
    void insertBooking(String userName, HotelRoom room, String begin, String end);
    void deleteBooking(String userName, HotelRoom room, String begin);
    ArrayList<Booking> getBookings(HotelRoom room);
    void insertReview(Review review,Hotel hotel);
    void deleteReview(String userName,Hotel hotel);
    ArrayList<Review> getReviews(Hotel hotel);
}
