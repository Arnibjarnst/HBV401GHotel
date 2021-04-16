package sample;

/*
@Authors:
    Árni Bjarnsteinsson
    Hákon Örn Harðarson
    Ísak Loftsson
    Jón Alex Pétursson

    Use:    db = new HotelDBMock();
    Pre:    Nothing
    Post:   db contains a new HotelDBMock instance

    Use:    getHotels(lo,hi,loc)
    Pre:    lo,hi are doubles and loc is a String
    Post:   returns all HotelRooms with price c, lo <= c <= hi
            and are in a hotel at location loc. If loc is ""
            then the hotel could be at any location.

    Use:    insertBooking(userName, room, begin, end)
    Pre:    userName is a String, room is of type HotelRoom and
            begin and end are Strings of the date format "yyyy/mm/dd"
    Post:   a Booking for HotelRoom room from begin to end
            has been inserted into the database in the name of userName

    Use:    deleteBooking(userName, room, begin)
    Pre:    userName is a String, room is of type HotelRoom and
            end is a String of the date format "yyyy/mm/dd"
    Post:   a Booking for HotelRoom room from begin to some end date
            in the name of userName has been deleted from the database

    Use:    getBookings(room)
    Pre:    room is of type HotelRoom
    Post:   returns all Bookings for room

    Use:    insertReview(review, hotel)
    Pre:    review is a Review and hotel is a Hotel
    Post:   review has been added to the ArrayList<Review> hotel.reviews
            if a Review by the same User has been written for hotel then
            the old Review is deleted.

    Use:    deleteReview(userName, hotel)
    Pre:    userName is a String, hotel is a Hotel
    Post:   a Review in the hotel.reviews by a User with userName userName
            has been deleted if it existed else nothing happened.

    Use:    getReviews(hotel)
    Pre:    hotel is a Hotel
    Post:   returns hotel.reviews

*/



/*
public class HotelDBMock implements HotelDB{
    private ArrayList<HotelRoom> rooms;

    public HotelDBMock() {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel("Kea","Akureyri"));
        hotels.add(new Hotel("Hilton","London"));
        hotels.add(new Hotel("Hilton","Paris"));
        hotels.add(new Hotel("Saga","Paris"));

        ArrayList<Review> review2 = new ArrayList<Review>();
        review2.add(new Review(8,"nice","Stefán"));
        ArrayList<Review> review3 = new ArrayList<Review>();
        review3.add(new Review(3,"bad","Jón"));

        hotels.get(2).setReviews(review2);
        hotels.get(3).setReviews(review3);

        rooms = new ArrayList<HotelRoom>();


        rooms.add(new HotelRoom(hotels.get(0),"single",10,201,50));
        rooms.add(new HotelRoom(hotels.get(1),"single",10,101,40));
        rooms.add(new HotelRoom(hotels.get(1),"double",50,201,110));
        rooms.add(new HotelRoom(hotels.get(2),"suite",100,1,130));
        rooms.add(new HotelRoom(hotels.get(3),"double",5,1,20));
        rooms.add(new HotelRoom(hotels.get(3),"single",10,2,80));

        ArrayList<Booking> book2 = new ArrayList<Booking>();
        book2.add(new Booking("Árni","2013/10/12","2013/10/17",200));
        ArrayList<Booking> book1 = new ArrayList<Booking>();
        book1.add(new Booking("Stefán", "2011/1/1","2020/12/12",12));

        rooms.get(0).setBookings(book1);
        rooms.get(1).setBookings(book2);

    }

    public ArrayList<HotelRoom> getHotels(double minprice, double maxprice,String location){
        ArrayList<HotelRoom> l = new ArrayList<HotelRoom>();
        for(int i=0; i < rooms.size(); i++){
            HotelRoom r = rooms.get(i);
            if((r.getHotel().getLocation().equals(location) || location.equals("")) && r.getPrice() <= maxprice && r.getPrice() >= minprice){
                l.add(r);
            }
        }
        return l;
    }

    public void insertBooking(String userName, HotelRoom room, String begin,String end){
        Booking booking = new Booking(userName,begin,end,100);
        for(int i=0; i < rooms.size(); i++){
            if(rooms.get(i).getPrice() == room.getPrice()){
                rooms.get(i).addBooking(booking);
                return;
            }
        }
        return;
    }

    public void deleteBooking(String userName, HotelRoom room, String begin){
        for(int i=0; i < rooms.size(); i++){
            if(rooms.get(i).getPrice() == room.getPrice()){
                ArrayList<Booking> bookings = rooms.get(i).getBookings();
                for(int j=0; j<bookings.size();j++){
                    if(bookings.get(j).getUserName().equals(userName)){
                        rooms.get(i).getBookings().remove(j);
                        return;
                    }
                }
            }
        }
        return;
    }

    public ArrayList<Booking> getBookings(HotelRoom room){
        for(int i=0; i<rooms.size();i++){
            if(rooms.get(i).getPrice() == room.getPrice()){
                return rooms.get(i).getBookings();
            }
        }
        ArrayList<Booking> empty = new ArrayList<Booking>();
        return empty;
    }

    public void insertReview(Review review,Hotel hotel){
        for(int i=0; i<rooms.size();i++){
            Hotel h = rooms.get(i).getHotel();
            if(h.getName().equals(hotel.getName()) && h.getLocation().equals(hotel.getLocation())){
                deleteReview(review.getUserName(),h);
                h.getReviews().add(review);
                return;
            }
        }
    }

    public void deleteReview(String userName,Hotel hotel){
        for(int i=0; i<rooms.size();i++) {
            Hotel h = rooms.get(i).getHotel();
            if(h.getName().equals(hotel.getName()) && h.getLocation().equals(hotel.getLocation())){
                for(int j=0;j<h.getReviews().size(); j++){
                    if (h.getReviews().get(j).getUserName().equals(userName)) {
                        rooms.get(i).getHotel().getReviews().remove(j);
                        return;
                    }
                }
            }
        }
    }

    public ArrayList<Review> getReviews(Hotel hotel){
        for(int i=0;i<rooms.size();i++){
            Hotel h = rooms.get(i).getHotel();
            if(h.getName().equals(hotel.getName()) && h.getLocation().equals(hotel.getLocation())){
                return h.getReviews();
            }
        }
        ArrayList<Review> empty = new ArrayList<Review>();
        return empty;
    }
}

*/
