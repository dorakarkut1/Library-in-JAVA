package pl.library.book;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderMenu {

    ReaderMenu(String login, String user_file_path, String books_file_path)  {
        this.login = login;
        this.user_file_path = user_file_path;
        this.books_file_path = books_file_path;
    }
    String login;
    String user_file_path;
    String books_file_path;

    public String readerMain() {
        String decision = "0";
        while (true) {
            System.out.print("1. Check your borrowed books \n" +
                    "2. Change your information and password \n" +
                    "3. Look for a book\n" +
                    "0. Exit\n");
            System.out.println("Enter your decision: \n");
            Scanner input = new Scanner(System.in);
            decision = input.nextLine();
            if (decision.equals("1") || decision.equals("2") || decision.equals("3")|| decision.equals("0")){
                return decision;
            }
        }
    }

    public void menu() throws IOException, ClassNotFoundException {
        UserList open_list = new UserList(user_file_path);
        Reader reader = open_list.lookForReader(this.login);
        String decision = "1";
        while (decision != "0") {
            decision = this.readerMain();
            switch (decision) {
                case "1":
                    System.out.println(reader.getBook_list());
                    break;
                case "2":
                    open_list.deleteReader(this.login);
                    reader.changeInfo();
                    ArrayList<Reader> new_list = new ArrayList<>();
                    new_list.add(reader);
                    open_list.writeReader(new_list);
                    break;
                case "3":
                    Scanner input2 = new Scanner(System.in);
                    System.out.println("Title: ");
                    String name = input2.nextLine();
                    System.out.println("Author: ");
                    String author = input2.nextLine();
                    BooksList open_list2 = new BooksList(books_file_path);
                    System.out.println(open_list2.lookForBook(name, author));
                    break;
                case "0":
                    decision = "0";
                    break;
            }
        }
    }
}
