package name.lemerdy.eric.solid;

import name.lemerdy.eric.solid.model.book.Book;
import org.junit.Test;

import static name.lemerdy.eric.solid.builders.BookBuilder.aCookingBook;
import static org.junit.Assert.assertEquals;

public class BookShouldTest {

    @Test
    public void be_named() {
        Book book = aCookingBook().build();

        assertEquals("book name", book.name());
    }

    @Test
    public void print_itself() {
        Book book = aCookingBook().costing(5.0d).build();

        assertEquals("Book{name='book name', type='COOKING', price=5.0}", book.toString());
    }
}
