package sample;

import java.util.ArrayList;

public class HotelController {
    private ArrayList<Hotel> hotels;
    private ArrayList<HotelRoom> rooms;

    private HotelDB db;

    public HotelController(){
        db = new HotelDB();

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
