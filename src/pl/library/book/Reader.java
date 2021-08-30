package pl.library.book;

import java.util.ArrayList;

public class Reader extends User{

    Reader(String login, String password, String name, String surname, String profile) {
        super(login, password, name, surname, profile);
    }
    private ArrayList<Book> book_list = new ArrayList<>();

    public ArrayList<Book> getBook_list() {
        return book_list;
    }
    public void add_Book_to_list(Book book) {
        this.book_list.add(book);
    }
    public void delete_book_from_list(Book book){
        for (Book one_book: this.book_list){
            if (one_book == book){
                book_list.remove(book);
            }
            else{
                System.out.println("Book was not borrowed by this reader.");
            }
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "book_list=" + book_list +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", profile='" + profile + '\'' +
                "} " + super.toString();
    }
}
