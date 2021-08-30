package pl.library.book;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Books_list new_list = new Books_list();
        Book nowa = new Book("Przeminelo", "cos tam", "nie wiem", 0000);
        Book nowa2 = new Book("Z wiatrem", "cos tam", "nie wiem", 0000);
        new_list.writeBook(nowa);
        new_list.writeBook(nowa2);
        new_list.readBooks();
        Book nowa3 = new Book("Przeminelo", "cos tam", "nie wiem", 0000);
        Books_list new_list2 = new Books_list();
        new_list2.writeBook(nowa3);
        ArrayList<Book> books = new_list2.readBooks();
        for(Book book: books){
            System.out.println(book);
        }


        }
    }
