package pl.library.book;

import java.io.*;
import java.util.ArrayList;

public class Books_list {
    static final private String file_path = "Books.txt";
    static ObjectOutputStream os;
    static ObjectInputStream is;

    public ArrayList<Book> read_books() throws IOException {
        ArrayList<Book> input = null;
        try {
            is = new ObjectInputStream(new FileInputStream(file_path));
            input = (ArrayList<Book>) is.readObject();
            is.close();
            return input;
        } catch (IOException | ClassNotFoundException g) {
            g.printStackTrace();
            return input;
        }
    }




    public void write_book(Book book) throws IOException {
        ArrayList<Book> temporary = read_books();
        temporary.add(book);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file_path));
        os.writeObject(temporary);
        os.close();
    }
    public Book look_for_book(String name, String author) throws IOException {
        Books_list open_list = new Books_list();
        ArrayList<Book> new_list = open_list.read_books();
        Book temporary = null;
        for (Book book: new_list) {
            if (book.getName().equals(name) & book.getAuthor().equals(author)) {
                return book;
            }
        }
        return temporary;
    }

}
