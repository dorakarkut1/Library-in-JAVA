package pl.library.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    User(String login, String password, String name, String surname, String profile ){
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.profile = profile;
    }
    protected String login;
    protected String password;
    protected String name;
    protected String surname;
    protected String profile;

    public void change_info(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your information: \n");
        System.out.print("Login: \n");
        this.login = input.nextLine();
        System.out.print("Password: \n");
        this.password = input.nextLine();
        System.out.print("Name: \n");
        this.name = input.nextLine();
        System.out.print("Surname: \n");
        this.surname = input.nextLine();
    }

    public void look_for_book(String name, String author) throws IOException {
        Books_list open_list = new Books_list();
        ArrayList<Book> list_of_books = open_list.read_books();
        for(Book book: list_of_books){
            if ((book.getName().equals(name)) & (book.getAuthor().equals(author))){
                System.out.print("Book title: " + name + "\nBook author: " + author +"\nBook is borrowed: "+ book.isborrowed());
            }
            else{
                System.out.println("Book not found");
            }
        }
    }
    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}

