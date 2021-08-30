package pl.library.book;

import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Books_listTest {
    Books_list example;
    Book book1, book2;

    @BeforeAll
    void setExample() {
        example = new Books_list("Books_example.txt");
        book1 = new Book("One", "Two", "Three", 1999);
        book2 = new Book("Three", "Two", "One", 1989);
        example.write_book(book1);
        example.write_book(book2);
    }

    @Test
    void read_books() throws IOException, ClassNotFoundException {
        Book result = example.look_for_book(book1.getName(), book1.getAuthor());
        assertEquals(book1.toString(), result.toString());
    }

    @Test
    void write_book() throws IOException, ClassNotFoundException {
        Book book3 = new Book("Two", "One", "Three", 1989);
        example.write_book(book3);
        Book result = example.look_for_book(book3.getName(), book3.getAuthor());
        assertEquals(book3.toString(), result.toString());
    }

    @Test
    void look_for_book() throws IOException, ClassNotFoundException {
        Book result = example.look_for_book(book2.getName(), book2.getAuthor());
        assertEquals(book2.toString(), result.toString());
    }

    @AfterAll
    void delete_example(){
        File f = new File("Books_example.txt");
        f.delete();
    }
}