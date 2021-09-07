package pl.library.book;

import pl.library.book.UserList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class LoginMenu {

    public String loginMain(){
        String decision = "0";
        while (true) {
            System.out.print("1. Login in \n" +
                    "2. Create account \n");
            System.out.println("Enter your decision: \n");
            Scanner input = new Scanner(System.in);
            decision = input.nextLine();
            if (decision.equals("1") || decision.equals("2")){
                return decision;
            }
        }
    }
    public void menu() throws IOException, ClassNotFoundException {
        String file_path = "User.txt";
        String book_file_path = "Book.txt";
        String decision = loginMain();
        UserList open_list = new UserList(file_path);
        ArrayList<Reader> user_list = open_list.readReaders();

        switch (decision){
            case "1":
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter correct information");
                System.out.println("Login: \n");
                String login = input.nextLine();
                System.out.println("Password: \n");
                String password = input.nextLine();
                Reader checkingInfo = open_list.lookForReader(login);
                if (checkingInfo.getPassword().equals(password)){
                    if (checkingInfo.getProfile().equals("reader")) {
                        ReaderMenu menu = new ReaderMenu(login, file_path);
                        menu.menu();
                    }
                    else{
                        AdministratorMenu menu2 = new AdministratorMenu(login, file_path, book_file_path);
                        menu2.menu();
                    }
                }
                else{
                    System.out.println("Incorrect login or password.\n");
                }
                break;

            case "2":
                Scanner input2 = new Scanner(System.in);
                System.out.print("Please enter your information: \n");
                System.out.print("Login: \n");
                String login2 = input2.nextLine();
                System.out.print("Password: \n");
                String password2 = input2.nextLine();
                System.out.print("Name: \n");
                String name2 = input2.nextLine();
                System.out.print("Surname: \n");
                String surname2 = input2.nextLine();
                System.out.print("Reader or administrator?: \n");
                String profile2 = input2.nextLine().toLowerCase(Locale.ROOT);
                Reader new_user = new Reader(login2, password2, name2, surname2, profile2);
                user_list.add(new_user);
                open_list.writeReader(user_list);
                System.out.println("Created new account");
                System.out.println(new_user);
                if (profile2.equals("reader")) {
                    ReaderMenu menu = new ReaderMenu(login2, file_path);
                    menu.menu();
                }
                else{
                    AdministratorMenu menu2 = new AdministratorMenu(login2, file_path, book_file_path);
                    menu2.menu();
                }
                break;
        }
    }
}
