package library;

/**
 * Created by Venelin on 21.3.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library<Book> library = new Library<>(bookOne, bookTwo, bookThree);

        for (Book book : library) {
            System.out.println(book.getTitle());
        }

    }

}
