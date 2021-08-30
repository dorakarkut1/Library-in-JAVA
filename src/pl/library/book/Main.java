package pl.library.book;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Books_list new_list = new Books_list();
        Book nowa = new Book("Przeminelo", "cos tam", "nie wiem", 0000);
        Book nowa2 = new Book("Z wiatrem", "cos tam", "nie wiem", 0000);
        ArrayList<Book> lista = new ArrayList<>();
        lista.add(nowa);
        lista.add(nowa2);
        new_list.writeBook(lista);
        new_list.readBooks();

        }
    }
