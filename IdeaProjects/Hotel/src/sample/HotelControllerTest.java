package sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelControllerTest {
    private HotelController controller;

    @Before
    public void setUp(){
        controller = new HotelController();
    }

    @After
    public void tearDown(){
        controller = null;
    }

    @Test
    public void testSearchHotels1(){
        HotelController controller = new HotelController();
        ArrayList<HotelRoom> rooms = controller.searchHotels(30.0,100.0,"Paris");
        assertEquals(1,rooms.size());
        assertEquals("Saga",rooms.get(0).getHotel().getName());
        assertEquals("Paris",rooms.get(0).getHotel().getLocation());
    }

    @Test
    public void testSearchHotels2(){
        ArrayList<HotelRoom> rooms = controller.searchHotels(40.0,50.0,"");
        assertEquals(2,rooms.size());
        assertEquals("Kea",rooms.get(0).getHotel().getName());
        assertEquals("Hilton",rooms.get(1).getHotel().getName());
        assertEquals("London",rooms.get(1).getHotel().getLocation());
    }

    @Test
    public void testSearchHotels3(){
        ArrayList<HotelRoom> rooms = controller.searchHotels(60.0,Double.POSITIVE_INFINITY,"Akureyri");
        assertEquals(0,rooms.size());
    }

    @Test
    public void testGetReviews1(){
        ArrayList<Review> reviews = controller.getReviews(new Hotel("Hilton","Paris"));
        assertEquals(8,reviews.get(0).getRating());
    }

    @Test
    public void testAddReviews1(){
        Hotel hotel = new Hotel("Saga","Paris");
        controller.addReview(10,"","Hákon",hotel);
        ArrayList<Review> reviews = controller.getReviews(hotel);
        assertEquals(2,reviews.size());
        assertEquals("Hákon",reviews.get(1).getUserName());
    }

    @Test
    public void testRemoveReview1(){
        Hotel hotel = new Hotel("Saga","Paris");
        controller.removeReview("Jón",hotel);
        ArrayList<Review> reviews = controller.getReviews(hotel);
        assertEquals(0,reviews.size());
    }

    @Test
    public void testRemoveReview2(){
        Hotel hotel = new Hotel("Saga","Paris");
        controller.removeReview("Stefán",hotel);
        ArrayList<Review> reviews = controller.getReviews(hotel);
        assertEquals(1,reviews.size());
    }

    @Test
    public void testGetBookings1(){
        ArrayList<Booking> bookings = controller.getBookings(new HotelRoom(new Hotel("Hilton","London"),"single",10,101,40));
        assertEquals(1,bookings.size());
        assertEquals("Árni",bookings.get(0).getUserName());
    }

    @Test
    public void testAddBooking1(){
        controller.addBooking("Ísak",new HotelRoom(new Hotel("Hilton","London"),"single",10,101,40),"2020/02/13","2020/02/30");
        ArrayList<Booking> bookings = controller.getBookings(new HotelRoom(new Hotel("Hilton","London"),"single",10,101,40));
        assertEquals(2,bookings.size());
        assertEquals("Ísak",bookings.get(1).getUserName());
    }

    @Test
    public void testCancelBooking1(){
        controller.cancelBooking("Stefán",new HotelRoom(new Hotel("Kea","Akureyri"),"single",10,201,50),"2011/1/1");
        ArrayList<Booking> bookings = controller.getBookings(new HotelRoom(new Hotel("Kea","Akureyri"),"single",10,201,50));
        assertEquals(0,bookings.size());
    }
}
