package pl.library.book;

import java.io.Serializable;

abstract public class Item implements Serializable {
    Item(String name, String publisher){
        this.name = name;
        this.publisher = publisher;
        this.borrowed = false;
    }
    private String name;
    private String publisher;
    boolean borrowed;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", borrowed=" + borrowed +
                '}';
    }
}
