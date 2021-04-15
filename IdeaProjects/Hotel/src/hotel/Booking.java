package hotel;

public class Booking {
    String userName;
    String begin;
    String end;
    double price;

    public Booking(String userName, String begin, String end, double price) {
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
}
