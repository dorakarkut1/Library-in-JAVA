package pl.library.book;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BooksListTest {
    BooksList example;
    Book book1, book2;

    @BeforeAll
    void setExample() {
        example = new BooksList("Books_example.txt");
        book1 = new Book("One", "Two", "Three", 1999);
        book2 = new Book("Three", "Two", "One", 1989);
        ArrayList<Book> temporary = new ArrayList<>();
        temporary.add(book1);
        temporary.add(book2);
        example.writeBook(temporary);
    }

    @Test
    void readBooks() throws IOException, ClassNotFoundException {
        Book result = example.lookForBook(book1.getName(), book1.getAuthor());
        assertEquals(book1.toString(), result.toString());
    }

    @Test
    void writeBook() throws IOException, ClassNotFoundException {
        Book book3 = new Book("Two", "One", "Three", 1989);
        ArrayList<Book> temporary2 = new ArrayList<>();
        temporary2.add(book3);
        example.writeBook(temporary2);
        Book result = example.lookForBook(book3.getName(), book3.getAuthor());
        assertEquals(book3.toString(), result.toString());
    }

    @Test
    void lookForBook() throws IOException, ClassNotFoundException {
        Book result = example.lookForBook(book2.getName(), book2.getAuthor());
        assertEquals(book2.toString(), result.toString());
    }

    @AfterAll
    void delete_example(){
        File f = new File("Books_example.txt");
        f.delete();
    }

    @Test
    void deleteBook() throws IOException, ClassNotFoundException {
        example.deleteBook(book2);
        assertNull(example.lookForBook("Three", "One"));
    }

    @Test
    void borrowBook() {

    }

    @Test
    void returnBook() {
    }

    @Test
    void showBooks() {
        example.showBooks();
    }

    @Test
    void rewriteBook() throws IOException, ClassNotFoundException {
        book1 = new Book("Five", "Two", "Three", 1999);
        book2 = new Book("Three", "Two", "One", 1989);
        ArrayList<Book> temporary = new ArrayList<>();
        temporary.add(book1);
        temporary.add(book2);
        example.rewriteBook(temporary);
        Book result = example.lookForBook(book1.getName(), book1.getAuthor());
        assertEquals(book1.toString(), result.toString());
    }
}