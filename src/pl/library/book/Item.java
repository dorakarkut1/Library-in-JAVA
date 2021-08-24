package pl.library.book;

abstract public class Item {
    Item(String name, String publisher){
        this.name = name;
        this.publisher = publisher;
        this.borrowed = false;
    }
    private String name;
    private String publisher;
    boolean borrowed;
}
