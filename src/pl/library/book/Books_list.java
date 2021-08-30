package pl.library.book;

import java.io.*;
import java.util.ArrayList;

public class Books_list {
    static private String file_path = "Books.txt";
    static ObjectOutputStream os;
    static ObjectInputStream is;

    public void readBooks() throws ClassNotFoundException, IOException {
        is = new ObjectInputStream(new FileInputStream(file_path));
        ArrayList<Book> input = (ArrayList<Book>) is.readObject();
        System.out.println(input);
        is.close();
    }

    public void writeBook(ArrayList<Book> books) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file_path));
        os.writeObject(books);
        os.close();
    }
}
