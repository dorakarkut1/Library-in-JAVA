package pl.library.book;

import java.io.*;
import java.util.ArrayList;

public class BooksList {
    BooksList(String file_path){
        this.file_path = file_path;
    }
    private String file_path;
    private ObjectOutputStream os;
    private ObjectInputStream is;

    public ArrayList<Book> readBooks() {
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

    public void writeBook(ArrayList<Book> books) {
        try {
            ArrayList<Book> temporary = readBooks();
            temporary.addAll(books);
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.file_path));
            os.writeObject(temporary);
            os.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void rewriteBook(ArrayList<Book> books) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.file_path));
            os.writeObject(books);
            os.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Book lookForBook(String name, String author) throws IOException, ClassNotFoundException {
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
        return null;
    }

    public void deleteBook(Book book) throws IOException, ClassNotFoundException {
        is = new ObjectInputStream(new FileInputStream(file_path));
        ArrayList<Book> books_list = (ArrayList<Book>) is.readObject();
        is.close();
        if (books_list.contains(book)){
            books_list.remove(book);
            System.out.println("The book has been deleted");
        }
        else {
            System.out.println("There is no such book in the library");
        }
        this.rewriteBook(books_list);
    }
    public void borrowBook(String name, String author, String login, String user_file_path) throws IOException, ClassNotFoundException {

        //updating list of books
        ArrayList<Book> books_list = (ArrayList<Book>) is.readObject();
        Book temporary2 = null;
        for (Book one_book: books_list) {
            if ((one_book.getName().equals(name)) & (one_book.getAuthor().equals(author))) {
                temporary2 = one_book;
                break;
            }
        }
        books_list.remove(temporary2);
        temporary2.borrow();
        books_list.add(temporary2);
        this.rewriteBook(books_list);

        //updating list of readers
        UserList open_list = new UserList(user_file_path);
        ArrayList<Reader> new_list = open_list.readReaders();
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
        open_list.rewriteReader(new_list);
    }

    public void returnBook(String name, String author, String login, String user_file_path) {

        //updating list of books
        ArrayList<Book> new_list2 = this.readBooks();
        Book temporary2 = null;
        for (Book one_book: new_list2) {
            if ((one_book.getName().equals(name)) & (one_book.getAuthor().equals(author))) {
                temporary2 = one_book;
                break;
            }
        }
        new_list2.remove(temporary2);
        temporary2.returnBook();
        new_list2.add(temporary2);
        this.rewriteBook(new_list2);

        //updating list of readers
        UserList open_list = new UserList(user_file_path);
        ArrayList<Reader> new_list = open_list.readReaders();
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
        open_list.rewriteReader(new_list);
    }

    public void showBooks() {
        ArrayList<Book> new_list = this.readBooks();
        for (Book book: new_list) {
            System.out.println("------------------");
            System.out.println(book.toString());
            System.out.println("------------------");
        }
    }

}
