package pl.library.book;

import java.io.Serializable;
import java.util.Objects;

public class Book extends Item implements Serializable {
    Book(String name, String publisher, String author, int year) {
        super(name, publisher);
        this.author = author;
        this.year = year;
        this.borrowed = false;
    }

    private String author;
    private int year;

    public String getAuthor() {
        return author;
    }

    public void borrow(){
        this.borrowed = true;
    }

    @Override
    public String toString() {
        return "Book named: " + this.getName() + '\n' +
                "- author: " + author + '\n' +
                "- publisher: " + this.getPublisher() + '\n' +
                "- year: " + year + '\n' +
                "- borrowed: " + this.borrowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Book book = (Book) o;
        return year == book.year && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, year);
    }

    public void returnBook(){
        this.borrowed = false;
    }

    public boolean isBorrowed() { return borrowed; }
}



