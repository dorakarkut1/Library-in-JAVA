package pl.library.book;

public class Book extends Item {
    Book(String name, String publisher, String author) {
        super(name, publisher);
        this.author = author;
    }

    private String author;
    private int year;

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear(){ return this.year; }

    public void borrow(){
        this.borrowed = true;
    }

    public boolean isborrowed() { return borrowed; }
}



