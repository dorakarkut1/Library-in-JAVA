package pl.library.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministratorMenu {
    AdministratorMenu(String login, String user_file_path, String book_file_path)  {
        this.login = login;
        this.user_file_path = user_file_path;
        this.book_file_path = book_file_path;
    }
    String login;
    String user_file_path;
    String book_file_path;

    public String readerMain() {
        String decision = "0";
        while (true) {
            System.out.print("1. Add a book \n" +
                    "2. Delete a book \n" +
                    "3. Readers list \n" +
                    "4. Books list \n" +
                    "5. Change your information \n" +
                    "6. Delete an account\n" +
                    "7. Borrow a book\n" +
                    "8. Return a book\n" +
                    "0. Exit\n");
            System.out.println("Enter your decision: \n");
            Scanner input = new Scanner(System.in);
            decision = input.nextLine();
            if (decision.equals("1") || decision.equals("2") || decision.equals("3") || decision.equals("4") || decision.equals("5") || decision.equals("6") || decision.equals("7") || decision.equals("8") || decision.equals("0")){
                return decision;
            }
        }
    }

    public void menu() throws IOException, ClassNotFoundException {
        String decision = "1";
        UserList open_list = new UserList(user_file_path);
        BooksList open_book_list = new BooksList(book_file_path);
        while (decision != "0") {
            decision = this.readerMain();
            switch (decision) {
                case "1":
                    Scanner input = new Scanner(System.in);
                    System.out.println("Enter correct information: \n");
                    System.out.println("Title: \n");
                    String title = input.nextLine();
                    System.out.println("Author: \n");
                    String author = input.nextLine();
                    System.out.println("Publisher: \n");
                    String publisher = input.nextLine();
                    System.out.println("Year: \n");
                    int year = input.nextInt();
                    Book new_book = new Book(title, publisher, author, year);
                    ArrayList<Book> temporary = new ArrayList<>();
                    temporary.add(new_book);
                    open_book_list.writeBook(temporary);
                    break;
                case "2":
                    Scanner input2 = new Scanner(System.in);
                    System.out.println("Enter correct information about book: \n");
                    System.out.println("Title: \n");
                    String title2 = input2.nextLine();
                    System.out.println("Author: \n");
                    String author2 = input2.nextLine();
                    Book temporary2 = open_book_list.lookForBook(title2, author2);
                    open_book_list.deleteBook(temporary2);
                    break;
                case "3":
                    open_list.showReaders();
                    break;
                case "4":
                    open_book_list.showBooks();
                    break;
                case "5":
                    Reader reader = open_list.lookForReader(this.login);
                    open_list.deleteReader(this.login);
                    reader.changeInfo();
                    ArrayList<Reader> temporary4 = new ArrayList<>();
                    temporary4.add(reader);
                    open_list.writeReader(temporary4);
                    break;
                case "6":
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Enter users login you want to delete");
                    String login_temp = input3.nextLine();
                    open_list.deleteReader(login_temp);
                    break;
                case "7":
                    Scanner input4 = new Scanner(System.in);
                    System.out.println("Enter readers login: \n");
                    System.out.println("Login: \n");
                    String login = input4.nextLine();
                    System.out.println("Enter name and author of the book: \n");
                    System.out.println("Name: \n");
                    String name = input4.nextLine();
                    System.out.println("Author: \n");
                    String author3 = input4.nextLine();
                    try{
                        open_book_list.borrowBook(name, author3, login, this.user_file_path);
                    }
                    catch (NullPointerException n){
                        System.out.println("Given information are incorrect or there is no such book in library");
                        menu();
                        break;
                    }
                    break;
                case "8":
                    Scanner input5 = new Scanner(System.in);
                    System.out.println("Enter readers login: \n");
                    System.out.println("Login: \n");
                    String login2 = input5.nextLine();
                    System.out.println("Enter name and author of the book: \n");
                    System.out.println("Name: \n");
                    String name2 = input5.nextLine();
                    System.out.println("Author: \n");
                    String author4 = input5.nextLine();
                    try{
                        open_book_list.returnBook(name2, author4, login2, this.user_file_path);
                    }
                    catch (NullPointerException n){
                        System.out.println("Given information are incorrect or there is no such book in library");
                        menu();
                        break;
                    }
                    break;
                case "0":
                    decision = "0";
                    break;
            }
        }
    }
}
