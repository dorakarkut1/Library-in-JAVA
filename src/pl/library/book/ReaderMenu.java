package pl.library.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderMenu {
    ReaderMenu(String login, String user_file_path)  {
        this.login = login;
        this.user_file_path = user_file_path;
    }
    String login;
    String user_file_path;
    public void readerMain(String[] args) throws IOException, ClassNotFoundException {
        UserList open_list = new UserList(user_file_path);
        ArrayList<Reader> new_list = open_list.readReaders();
        Reader reader = open_list.lookForReader(this.login);
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
                reader.changeInfo();
                new_list.add(reader);
                open_list.writeReader(new_list);
            case "3":
                Scanner input2 = new Scanner(System.in);
                System.out.println("Title: ");
                String name = input2.nextLine();
                System.out.println("Author: ");
                String author = input2.nextLine();
                BooksList open_list2 = new BooksList("Books_example.txt");
                System.out.println(open_list2.lookForBook(name,author));

        }
    }
    }
