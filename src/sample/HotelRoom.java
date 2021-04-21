package sample;

import java.util.ArrayList;

public class HotelRoom {
    Hotel hotel;
    String type;
    int count;
    double price;

    public HotelRoom(Hotel hotel, String type, int count, double price) {
        this.hotel = hotel;
        this.type = type;
        this.count = count;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getCount() {
        return count;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %1.0f kr/night",type,price);
    }
}
