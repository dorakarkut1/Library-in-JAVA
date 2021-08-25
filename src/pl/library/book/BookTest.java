package pl.library.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book example = new Book("Example", "Publisher", "None");

    @Test
    public void ifBorrowedSetToTrue(){
        Assertions.assertFalse(example.isborrowed());
    }

    @Test
    public void ifYearWasSet(){
        example.setYear(1999);
        Assertions.assertEquals(1999, example.getYear());
    }
}