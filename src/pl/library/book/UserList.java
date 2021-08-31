package pl.library.book;

import java.io.*;
import java.util.ArrayList;

public class UserList {
    UserList(String file_path){this.file_path = file_path;}
    private String file_path;
    private ObjectOutputStream os;
    private ObjectInputStream is;

    public ArrayList<Reader> readReaders() {
        ArrayList<Reader> input = new ArrayList<>();
        try {
            File new_file = new File(this.file_path);
            if (!new_file.exists()) {
                new_file.createNewFile();
            }
            is = new ObjectInputStream(new FileInputStream(new_file));
            input = (ArrayList<Reader>) is.readObject();
            is.close();
            return input;
        }
        catch (ClassNotFoundException | IOException g) {
            return input;
        }

    }

    public void writeReader(ArrayList<Reader> readers){
        ArrayList<Reader> temporary;
        temporary = this.readReaders();
        temporary.addAll(readers);
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.file_path));
            os.writeObject(temporary);
            os.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void rewriteReader(ArrayList<Reader> readers){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.file_path));
            os.writeObject(readers);
            os.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Reader lookForReader(String login)  {
        ArrayList<Reader> new_list = this.readReaders();
        for (Reader reader: new_list) {
            if (reader.getLogin().equals(login)) {
                return reader;
            }
        }
        return null;
    }
    public void showReaders() {
        ArrayList<Reader> new_list = this.readReaders();
        for (Reader reader: new_list) {
            System.out.println("-------------------");
            System.out.println(reader.toString());
            System.out.println("-------------------");
        }
    }

    public void deleteReader(String login) {
        ArrayList<Reader> new_list = new ArrayList<>();
        new_list = this.readReaders();
        Reader reader = this.lookForReader(login);
        boolean remove = new_list.remove(reader);
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.file_path));
            os.writeObject(new_list);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reader deleted");
    }
}
