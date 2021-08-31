package pl.library.book;


import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class User implements Serializable {
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

    public void changeInfo(){
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

    public boolean ifAdministrator(){
        if (this.profile.equals("reader")){
            return false;
        }
        else {
            return true;
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getProfile() {
        return profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        User user = (User) o;
        return login.equals(user.login) && password.equals(user.password) && name.equals(user.name) && surname.equals(user.surname) && profile.equals(user.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, name, surname, profile);
    }

    @Override
    public String toString() {
        return "Login: " + login + '\n' +
                "password: " + password + '\n' +
                "name: " + name + '\n' +
                "surname: " + surname + '\n' +
                "profile: " + profile + '\n';
    }
}

