package Hillel_31.Library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Title One", "Author One");
        book2 = new Book("Title Two", "Author Two");
    }

    @Test
    public void testAddBook() {
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book1));
    }

    @Test
    public void testAddNullBookThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
    }

    @Test
    public void testAddDuplicateBookDoesNotAdd() {
        library.addBook(book1);
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
    }

    @Test
    public void testRemoveBook() {
        library.addBook(book1);
        boolean removed = library.removeBook(book1);
        assertTrue(removed);
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void testRemoveNullBookThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.removeBook(null));
    }

    @Test
    public void testRemoveNonExistingBookReturnsFalse() {
        boolean removed = library.removeBook(book2);
        assertFalse(removed);
    }

    @Test
    public void testGetBooksReturnsUnmodifiableList() {
        library.addBook(book1);
        List<Book> books = library.getBooks();
        assertThrows(UnsupportedOperationException.class, () -> books.add(book2));
    }

    @Test
    public void testGetBookCount() {
        assertEquals(0, library.getBookCount());
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.getBookCount());
    }
}

