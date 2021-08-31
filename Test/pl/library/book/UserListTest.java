package pl.library.book;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserListTest {
    UserList user_list;
    Reader user1;
    Reader user2;
    Reader user3;
    ArrayList<Reader> temporary;
    ArrayList<Reader> temporary2 = new ArrayList<>();

    @BeforeAll
    void setUser_list(){
        user_list = new UserList("User_example.txt");
        user1 = new Reader("One", "Two", "Three", "Four", "reader" );
        user2 = new Reader("Two", "Two", "Three", "Four", "administrator");
        temporary = new ArrayList<>();
        temporary.add(user1);
        temporary.add(user2);
        user_list.writeReader(temporary);
    }
    @AfterAll
    void delete_example(){
        File f = new File("User_example.txt");
        f.delete();
    }

    @Test
    void readReaders() {
        assertEquals(user2.toString(), user_list.lookForReader("Two").toString());
    }

    @Test
    void writeReader() {
        user3 = new Reader("Three", "Two", "Three", "Four", "administrator");
        temporary2.add(user3);
        user_list.writeReader(temporary2);
        Reader result = user_list.lookForReader("Three");
        assertEquals(result.toString(), user3.toString());
    }

    @Test
    void lookForReader() {
        assertEquals(user2.toString(), user_list.lookForReader("Two").toString());
    }

    @Test
    void showReaders() {
        System.out.println("Example of users list");
        user_list.showReaders();
    }

    @Test
    void deleteReader() {
        user_list.deleteReader("One");
    }

    @Test
    void rewriteReader() {
        user1 = new Reader("Five", "Two", "Three", "Four", "reader" );
        user2 = new Reader("Two", "Two", "Three", "Four", "administrator");
        temporary = new ArrayList<>();
        temporary.add(user1);
        temporary.add(user2);
        user_list.rewriteReader(temporary);
        Reader result = user_list.lookForReader("Five");
        assertEquals(result.toString(), user1.toString());
    }
}