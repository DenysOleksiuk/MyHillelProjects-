package Hillel_31.Library;

import Projectc_21.Anotation.Author;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (books.contains(book)) {
            System.out.println("The book is already in the library: " + book);
            return;
        }
        books.add(book);
    }

    public boolean removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        return books.remove(book);
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public int getBookCount() {
        return books.size();
    }
}


