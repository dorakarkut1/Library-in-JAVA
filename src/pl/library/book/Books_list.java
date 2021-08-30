package pl.library.book;

import java.io.*;
import java.util.ArrayList;

public class Books_list {
    static private String file_path = "Books.txt";
    static ObjectOutputStream os;
    static ObjectInputStream is;

    public ArrayList<Book> readBooks() throws ClassNotFoundException, IOException {
        try {
            is = new ObjectInputStream(new FileInputStream(file_path));
            ArrayList<Book> input = (ArrayList<Book>) is.readObject();
            is.close();
            return input;
        }
        catch (FileNotFoundException e){
            ArrayList<Book> nowa = new ArrayList<>();
            return nowa;
        }

    }

    public void writeBook(Book book) throws IOException, ClassNotFoundException {
        ArrayList<Book> temporary = readBooks();
        temporary.add(book);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file_path));
        os.writeObject(temporary);
        os.close();
    }

}
