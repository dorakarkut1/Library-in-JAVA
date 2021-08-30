package pl.library.book;

import java.io.*;
import java.util.ArrayList;

public class Books_list {
    Books_list(String file_path){
        this.file_path = file_path;
    }
    private String file_path;
    private ObjectOutputStream os;
    private ObjectInputStream is;

    public ArrayList<Book> read_books() {
        ArrayList<Book> input = new ArrayList<>();
        try {
            File new_file = new File(file_path);
            if (!new_file.exists()){
                new_file.createNewFile();
            }
            is = new ObjectInputStream(new FileInputStream(new_file));
            input = (ArrayList<Book>) is.readObject();
            is.close();
            return input;
        } catch (IOException | ClassNotFoundException g) {

            return input;
        }
    }

    public void write_book(Book book) {
        try {
            ArrayList<Book> temporary = read_books();
            temporary.add(book);
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.file_path));
            os.writeObject(temporary);
            os.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Book look_for_book(String name, String author) throws IOException, ClassNotFoundException {
        File new_file = new File(file_path);
        is = new ObjectInputStream(new FileInputStream(new_file));
        ArrayList<Book> new_list = (ArrayList<Book>) is.readObject();
        is.close();
        Book temporary = null;
        for (Book book: new_list) {
            if (book.getName().equals(name) & book.getAuthor().equals(author)) {
                return book;
            }
        }
        return temporary;
    }

}
