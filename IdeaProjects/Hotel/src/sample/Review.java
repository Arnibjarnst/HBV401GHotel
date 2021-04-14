package sample;

public class Review {
    private int rating;
    private String comment;
    private String userName;

    public Review(int rating, String comment, String userName) {
        this.rating = rating;
        this.comment = comment;
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

}
