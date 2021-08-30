package pl.library.book;

import java.io.IOException;
import java.util.ArrayList;

public class Administrator extends User{
    Administrator(String login, String password, String name, String surname, String profile) {
        super(login, password, name, surname, profile);
    }

    public void add_book(Book book) throws IOException {
        Books_list open_list = new Books_list();
        open_list.write_book(book);
    }

    public void delete_book(Book book) throws IOException {
        Books_list open_list = new Books_list();
        ArrayList<Book> books_list = open_list.read_books();
        if (books_list.contains(book)){
            books_list.remove(book);
            System.out.println("The book has been deleted");
        }
        else {
            System.out.println("There is no such book in the library");
        }
    }

    public void borrow_book(String name, String author, String login) throws IOException {

        //updating list of books
        Books_list open_list2 = new Books_list();
        ArrayList<Book> new_list2 = open_list2.read_books();
        Book temporary2 = null;
        for (Book one_book: new_list2) {
            if ((one_book.getName().equals(name)) & (one_book.getAuthor().equals(author))) {
                temporary2 = one_book;
                break;
            }
        }
        new_list2.remove(temporary2);
        temporary2.borrow();
        new_list2.add(temporary2);

        //updating list of readers
        User_list open_list = new User_list();
        ArrayList<Reader> new_list = open_list.read_readers();
        Reader temporary = null;
        for (Reader reader: new_list){
            if (reader.login.equals(login)){
                temporary = reader;
                break;
            }
        }
        new_list.remove(temporary);
        temporary.add_Book_to_list(temporary2);
        new_list.add(temporary);
        }

    public void return_book(String name, String author, String login) throws IOException {

        //updating list of books
        Books_list open_list2 = new Books_list();
        ArrayList<Book> new_list2 = open_list2.read_books();
        Book temporary2 = null;
        for (Book one_book: new_list2) {
            if ((one_book.getName().equals(name)) & (one_book.getAuthor().equals(author))) {
                temporary2 = one_book;
                break;
            }
        }
        new_list2.remove(temporary2);
        temporary2.return_book();
        new_list2.add(temporary2);

        //updating list of readers
        User_list open_list = new User_list();
        ArrayList<Reader> new_list = open_list.read_readers();
        Reader temporary = null;
        for (Reader reader: new_list){
            if (reader.login.equals(login)){
                temporary = reader;
                break;
            }
        }
        new_list.remove(temporary);
        temporary.delete_book_from_list(temporary2);
        new_list.add(temporary);
    }
    public void show_books() throws IOException {
        Books_list open_list = new Books_list();
        ArrayList<Book> new_list = open_list.read_books();
        for (Book book: new_list) {
            System.out.println(book.toString());
        }
    }
    public void show_readers() {
        User_list open_list = new User_list();
        ArrayList<Reader> new_list = open_list.read_readers();
        for (Reader reader: new_list) {
            System.out.println(reader.toString());
        }
    }
    public void delete_reader(String login)  {
        User_list open_list = new User_list();
        ArrayList<Reader> new_list = open_list.read_readers();
        Reader reader = open_list.look_for_reader(login);
        new_list.remove(reader);
        System.out.println("Reader deleted");
    }
    }


