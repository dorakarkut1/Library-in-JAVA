package pl.library.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Reader extends User implements Serializable {

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
            if (one_book.equals(book)){
                book_list.remove(book);
            }
            else{
                System.out.println("Book was not borrowed by this reader.");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return book_list.equals(reader.book_list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), book_list);
    }

    @Override
    public String toString() {
        return "Login: " + login + '\n' +
                "password: " + password + '\n' +
                "name: " + name + '\n' +
                "surname: " + surname + '\n' +
                "profile: " + profile + '\n' +
                "List of books: " + book_list;
    }
}
