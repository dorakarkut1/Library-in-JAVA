package pl.library.book;

import java.io.Serializable;

public class Book extends Item implements Serializable {
    Book(String name, String publisher, String author, int year) {
        super(name, publisher);
        this.author = author;
        this.year = year;
        this.borrowed = false;
    }

    private String author;
    private int year;

    public void borrow(){
        this.borrowed = true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", year=" + year +
                "} " + super.toString();
    }

    public void return_book(){
        this.borrowed = false;
    }

    public boolean isborrowed() { return borrowed; }
}



