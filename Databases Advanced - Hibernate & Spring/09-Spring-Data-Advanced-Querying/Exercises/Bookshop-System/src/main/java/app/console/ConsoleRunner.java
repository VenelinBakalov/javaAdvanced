package app.console;

import app.model.*;
import app.service.api.AuthorService;
import app.service.api.BookService;
import app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private BookService<Book, Long> bookService;

    @Autowired
    private AuthorService<Author, Long> authorService;

    @Autowired
    private CategoryService<Category, Long> categoryService;

    @Override
    public void run(String... strings) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        seedDatabase();

        // 1.	Books Titles by Age Restriction
//        String ageRestrictionType = reader.readLine();
//        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionType.toUpperCase());
//        List<Book> books = this.bookService.findAllByAgeRestriction(ageRestriction);
//
//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }

        // 2.	Golden Books
//        List<String> goldenBooks = this.bookService.findAllGoldenEditionAndLessThan5000Copies();
//        goldenBooks.forEach(System.out::println);

        // 3.	Books by Price
//        List<String> booksByPrice = this.bookService.findBooksWithPriceLessThan5GreaterThan40();
//        booksByPrice.forEach(System.out::println);

        // 4.	Not Released Books
//        int year = Integer.parseInt(reader.readLine());
//        List<String> booksNotReleasedOnYear = this.bookService.findBooksNotReleaseOn(year);
//        booksNotReleasedOnYear.forEach(System.out::println);

        // 5.	Book Titles by Category
        // this doesn't work
//        List<String> categoriesNames = Stream.of(reader.readLine().split("\\s+")).collect(Collectors.toList());
//        Set<Category> categories = this.categoryService.categoriesByName(categoriesNames);

        // this doesn't work as well but gets result closer to the real one :D
//        List<String> categories = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
//        List<String> titles = this.bookService.findBookTitlesByCategories(categories);
//        titles.forEach(System.out::println);

        // 6.	Books Released Before Date
//        String dateStr = reader.readLine();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = sdf.parse(dateStr);
//        List<Book> books = this.bookService.findBooksReleasedBefore(date);
//        books.forEach(b -> System.out.printf("%s %s %s\n",
//                b.getTitle(),
//                b.getEditionType().name(),
//                b.getPrice()));

        // 7.	Authors Search
//        String pattern = reader.readLine();
//        List<Author> authors = authorService.findAllByFirstNameEndsWith(pattern);
//        for (Author author : authors) {
//            System.out.println(author.getFirstName() + " " + author.getLastName());
//        }

        // 8.	Books Search
//        String pattern = reader.readLine();
//        List<String> titles = this.bookService.findAllWhoseTitleContains(pattern);
//        titles.forEach(System.out::println);

        // 9.	Book Titles Search
//        String pattern = reader.readLine();
//        List<Book> books= this.bookService.findBooksWithTitlesWrittenByLastNameEndingWith(pattern);
//        for (Book book : books) {
//            System.out.println(book.getTitle() + " " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
//        }

        // 10.	Count Books
//        Integer titleLength = Integer.parseInt(reader.readLine());
//        int count = this.bookService.findBookCountByTitleLength(titleLength);
//        System.out.println(count);

        // 11.	Total Book Copies
//        List<Object[]> totalCopies = this.authorService.findTotalBookCopiesCountByAuthor();
//        totalCopies.forEach(a -> System.out.printf("%s - %s\n", a[0], a[1]));

        // 12.	Find Profit
//        List<Object[]> totalProfit = this.categoryService.findTotalProfitByCategory();
//        totalProfit.forEach(c -> System.out.printf("%s - $%s\n", c[0], c[1]));

        // 13.	Most Recent Books
//        Calendar calendar = Calendar.getInstance();
//
//        List<Category> categoriesByBookCount = this.categoryService.findAllCategoriesOrderByBookCount();
//        categoriesByBookCount.forEach(c -> {
//            System.out.println(String.format("--%s: %d books",
//                    c.getName(),
//                    c.getBooks().size()));
//            c.getBooks().stream()
//                    .sorted((b1, b2) -> {
//                        int result = b2.getReleaseDate().compareTo(b1.getReleaseDate());
//                        if (result == 0) {
//                            result = b1.getTitle().compareTo(b2.getTitle());
//                        }
//
//                        return result;
//                    })
//                    .limit(3)
//                    .forEach(b -> {
//                        calendar.setTime(b.getReleaseDate());
//                        System.out.println(String.format("%s - (%s)",
//                            b.getTitle(),
//                            calendar.get(Calendar.YEAR)));
//                    });
//        });

        // 14.	Reduced Book
        String title = reader.readLine();
        ReducedBook book = this.bookService.findReducedBookByTitle(title);
        if (book != null) {
            System.out.printf("%s %s %s %s\n",
                    book.getTitle(),
                    book.getEditionType(),
                    book.getAgeRestriction(),
                    book.getPrice());
        }

        // 15.	* Increase Book Copies
//        String dateStr = reader.readLine();
//        int copiesCount = Integer.parseInt(reader.readLine());
//        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
//        Date date = sdf.parse(dateStr);
//        int updatedRows = this.bookService.updateBookCopiesAfterDate(date, copiesCount);
//        System.out.println(updatedRows * copiesCount);

        // 16.	* Remove Books
//        int minCopies = Integer.parseInt(reader.readLine());
//        int deleted = this.bookService.removeBooksWithLessCopiesThan(minCopies);
//        System.out.printf("%d book%s deleted\n",
//                deleted,
//                deleted == 1 ? " was" : "s were");
    }

    private void seedDatabase() throws IOException, ParseException {

        List<Author> authors = new ArrayList<>();

        BufferedReader authorsReader = new BufferedReader(new FileReader("src/authors.txt"));
        String line = authorsReader.readLine();
        while ((line = authorsReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];

            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);

            authors.add(author);

            authorService.save(author);
        }

        List<Category> categories = new ArrayList<>();

        BufferedReader categoriesReader = new BufferedReader(new FileReader("src/categories.txt"));
        while ((line = categoriesReader.readLine()) != null) {
            Category category = new Category();
            category.setName(line);

            categories.add(category);

            categoryService.save(category);
        }

        Random random = new Random();

        BufferedReader booksReader = new BufferedReader(new FileReader("src/books.txt"));
        line = booksReader.readLine();
        while((line = booksReader.readLine()) != null){
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);

            Set<Category> bookCategories = new HashSet<>();

            for (int i = 0; i < random.nextInt(categories.size()); i++) {
                int categoryIndex = random.nextInt(categories.size());
                bookCategories.add(categories.get(categoryIndex));
            }
            book.setCategories(bookCategories);

            bookService.save(book);
        }
    }
}
