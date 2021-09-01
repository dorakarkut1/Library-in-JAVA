package pl.library.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ItemTest {
    Item example, example2;
    @BeforeAll
    void setExample(){
        example = new Item("One", "Two") {
            @Override
            public String getName() {
                return super.getName();
            }

            @Override
            public String getPublisher() {
                return super.getPublisher();
            }

            @Override
            public boolean isBorrowed() {
                return super.isBorrowed();
            }

            @Override
            public boolean equals(Object o) {
                return super.equals(o);
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
        example.borrowed = false;
        example2 = example;
        example2.borrowed = false;
    }
    @Test
    void getName() {
        assertTrue(example.getName().equals("One"));
    }

    @Test
    void getPublisher() {
        assertTrue(example.getPublisher().equals("Two"));
    }

    @Test
    void isBorrowed() {
        assertFalse(example.isBorrowed());
    }

    @Test
    void testEquals() {
        assertTrue(example.toString().equals(example2.toString()));
    }

    @Test
    void testToString() {
        String toString = example.toString();
        assertTrue(toString.contains("Name: One"));
    }
}