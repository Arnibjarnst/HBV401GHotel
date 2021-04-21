package sample;

public class Booking {
    HotelRoom room;
    String userName;
    String begin;
    String end;
    double price;

    public Booking(HotelRoom room, String userName, String begin, String end, double price) {
        this.room = room;
        this.userName = userName;
        this.begin = begin;
        this.end = end;
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return room.getHotel().toString() +
                "  " + room.getType() +
                "  " + begin + '/' + end +
                "     " + price;
    }
}
