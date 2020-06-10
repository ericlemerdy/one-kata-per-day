package name.lemerdy.eric.solid;

import name.lemerdy.eric.solid.model.Basket;
import name.lemerdy.eric.solid.model.book.Book;

import java.util.logging.Logger;

import static name.lemerdy.eric.solid.model.book.BookType.*;

public class Application {
    private static Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        Book fantasyBook1 = new Book("The Hobbit", FANTASY, 20.00);
        Book fantasyBook2 = new Book("Game of Thrones", FANTASY, 15.00);
        Book itBook1 = new Book("Software Craftsmanship", IT, 18.00);
        Book itBook2 = new Book("GOOS", IT, 25.00);
        Book itBook3 = new Book("Clean Code", IT, 28.00);
        Book travelBook1 = new Book("Notes from a Small Island", TRAVEL, 10.00);
        Book cookingBook1 = new Book("Brazilian Flavours", COOKING, 10.00);

        Basket basket = new Basket();
        basket.add(fantasyBook1);
        basket.add(fantasyBook2);
        basket.add(itBook1);
        basket.add(itBook2);
        basket.add(itBook3);
        basket.add(travelBook1);
        basket.add(cookingBook1);

        basket.books().forEach(Application::println);
        println("Full price: " + basket.fullPrice());
        println("Price with discount: " + basket.priceWithDiscount());
    }

    private static void println(String text) {
        logger.info(text);
    }

    private static void println(Book book) {
        println(book.toString());
    }

}
