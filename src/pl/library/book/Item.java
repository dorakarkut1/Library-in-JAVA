package pl.library.book;

import java.io.Serializable;
import java.util.Objects;

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

    public String getPublisher() {
        return publisher;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Item item = (Item) o;
        return borrowed == item.borrowed && name.equals(item.name) && publisher.equals(item.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, publisher, borrowed);
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
