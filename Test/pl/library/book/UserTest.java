package pl.library.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User example;
    User example2;

    @BeforeEach
    void setExample(){
        example = new User("One", "Two", "Three", "Four", "reader");
        example2 = new User("One", "Two", "Three", "Four", "reader");
    }

    @Test
    void ifAdministrator(){
        assertFalse(example.ifAdministrator());
    }
    @Test
    void testToString() {
        String toString = example.toString();
        assertTrue(toString.contains("Login: One"));
    }

    @Test
    void getLogin() {
        assertEquals(example.getLogin(), "One");
    }

    @Test
    void getPassword() {
        assertEquals(example.getPassword(), "Two");
    }

    @Test
    void getName() {
        assertEquals(example.getName(), "Three");
    }

    @Test
    void getSurname() {
        assertEquals(example.getSurname(), "Four");
    }

    @Test
    void getProfile() {
        assertEquals(example.getProfile(), "reader");
    }

    @Test
    void testEquals() {
        assertTrue(example.equals(example2));
    }

}