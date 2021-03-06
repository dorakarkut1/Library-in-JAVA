package pl.library.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book example;

    @BeforeEach
    void setExample(){
       example = new Book("One", "Two", "Three", 1999);
    }

    @Test
    void getAuthor() {
        assertEquals(example.getAuthor(),"Three");
    }

    @Test
    void borrow() {
        example.borrow();
        assertTrue(example.isBorrowed());
    }

    @Test
    void return_book() {
        example.borrow();
        example.returnBook();
        assertFalse(example.borrowed);
    }

    @Test
    void isBorrowed() {
        assertFalse(example.isBorrowed());
    }
}