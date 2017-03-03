package bookShop;

/**
 * Created by Venelin on 3.3.2017 г..
 */
public class Book {

    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }

    private void setTitle(String title) {
        if (title.length() <= 3) {
            throw new IllegalArgumentException("Title not valid!");
        }

        this.title = title;
    }

    private void setAuthor(String author) {
        String[] nameArgs = author.split(" ");
        if (nameArgs.length > 1 && Character.isDigit(nameArgs[1].charAt(0))) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }

        this.price = price;
    }

    private String getTitle() {
        return title;
    }

    private String getAuthor() {
        return author;
    }

    private double getPrice() {
        return price;
    }
}
