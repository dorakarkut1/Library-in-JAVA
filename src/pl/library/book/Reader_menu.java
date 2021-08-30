package pl.library.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader_menu {
    Reader_menu(String login)  {
        this.login = login;
    }
    String login;
    public void reader_main(String[] args) throws IOException, ClassNotFoundException {
        User_list open_list = new User_list();
        ArrayList<Reader> new_list = open_list.read_readers();
        Reader reader = open_list.look_for_reader(this.login);
        System.out.println("Enter your decision: \n");
        System.out.print("1. Check your borrowed books \n" +
                "2. Change your information and password \n" +
                "3. Look for a book\n");
        Scanner input = new Scanner(System.in);
        String decision = input.nextLine();

        switch (decision) {
            case "1":
                System.out.println(reader.getBook_list());
                break;
            case "2":
                new_list.remove(reader);
                reader.change_info();
                open_list.write_reader(reader);
            case "3":
                Scanner input2 = new Scanner(System.in);
                System.out.println("Title: ");
                String name = input2.nextLine();
                System.out.println("Author: ");
                String author = input2.nextLine();
                Books_list open_list2 = new Books_list("Books_example.txt");
                System.out.println(open_list2.look_for_book(name,author));

        }
    }
    }
