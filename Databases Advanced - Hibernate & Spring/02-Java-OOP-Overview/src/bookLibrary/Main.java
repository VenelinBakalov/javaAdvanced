package bookLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library();
        int bookCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < bookCount; i++) {
            String[] input = reader.readLine().split("\\s+");
            String title = input[0];
            String author = input[1];
            String publisher = input[2];
            String releaseDate = input[3];
            String ISBN = input[4];
            double price = Double.parseDouble(input[5]);

            Book book = new Book(title, author, publisher, releaseDate, ISBN, price);
            library.addBook(book);
        }

        library.getBooks()
                .stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.summingDouble(Book::getPrice)))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int result = Double.compare(e2.getValue(), e1.getValue());
                    if (result == 0) {
                        result = e1.getKey().compareTo(e2.getKey());
                    }

                    return result;
                }).forEach(author -> {
            System.out.println(String.format("%s -> %.2f", author.getKey(), author.getValue()));
        });
    }
}
