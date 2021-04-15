package hotel;

import java.util.ArrayList;

public class Hotel {
    String name;
    String location;
    ArrayList<Review> reviews;
    int stars;

    public Hotel(String name, String location ) {
        this.name = name;
        this.location = location;
        this.reviews = new ArrayList<Review>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public String getLocation() {
        return location;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
