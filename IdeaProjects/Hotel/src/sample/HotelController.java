package sample;

public class HotelController {
    private Hotel hotels[];
    private HotelDB db;

    public HotelController(){
        db = new HotelDB();
    }
    /*
    public ArrayList<HotelRoom> searchHotels(double minprice, double maxprice,String location) {
        return db.getHotels(minprice, maxprice,location);
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
    */
}
