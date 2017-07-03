package bookLibrary;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Book {

    private String title;
    private String author;
    private String publisher;
    private String releaseDate;
    private String ISBN;
    private double price;

    public Book(String title, String author, String publisher, String releaseDate, String ISBN, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublisher(publisher);
        this.setReleaseDate(releaseDate);
        this.setISBN(ISBN);
        this.setPrice(price);
    }


    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public double getPrice() {
        return this.price;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    private void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    private void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    private void setPrice(double price) {
        this.price = price;
    }
}
