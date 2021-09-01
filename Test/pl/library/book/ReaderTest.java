package pl.library.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
    Reader example;
    Book book_example;
    @BeforeEach
    void setExample(){
        example = new Reader("One", "Two", "Three", "Four", "reader");
        book_example = new Book("First", "Second", "Third", 1999);
        example.add_Book_to_list(book_example);
    }
    @Test
    void getBook_list() {
        ArrayList<Book> temporary = new ArrayList<>();
        temporary.add(book_example);
        assertEquals(temporary, example.getBook_list());
    }

    @Test
    void add_Book_to_list() {
        Book book_example2 = new Book("Second", "Second", "Third", 1999);
        example.add_Book_to_list(book_example2);
        ArrayList<Book> temporary = new ArrayList<>();
        temporary.add(book_example);
        temporary.add(book_example2);
        assertEquals(example.getBook_list(),temporary);
        example.delete_book_from_list(book_example2);
    }

    @Test
    void delete_book_from_list() {
        Book book_example2 = new Book("Second", "Second", "Third", 1999);
        example.add_Book_to_list(book_example2);
        ArrayList<Book> temporary = new ArrayList<>();
        temporary.add(book_example);
        temporary.add(book_example2);
        assertEquals(example.getBook_list(),temporary);
        example.delete_book_from_list(book_example2);
    }

    @Test
    void testEquals() {
        Book book_example2 = new Book("Second", "Second", "Third", 1999);
        example.add_Book_to_list(book_example2);
        ArrayList<Book> temporary = new ArrayList<>();
        temporary.add(book_example);
        temporary.add(book_example2);
        assertEquals(example.getBook_list(),temporary);
        example.delete_book_from_list(book_example2);
    }

    @Test
    void testToString() {
        String toString = example.toString();
        assertTrue(toString.contains("Login: One"));
    }
}