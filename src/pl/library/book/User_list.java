package pl.library.book;

import java.io.*;
import java.util.ArrayList;

public class User_list {
    static final private String file_path = "Users.txt";
    static ObjectOutputStream os;
    static ObjectInputStream is;

    public ArrayList<Reader> read_readers() {
        ArrayList<Reader> input = null;
        try {
            is = new ObjectInputStream(new FileInputStream(file_path));
            input = (ArrayList<Reader>) is.readObject();
            is.close();
            return input;
        }
        catch (IOException | ClassNotFoundException g) {
            g.printStackTrace();
            return input;
        }

    }

    public void write_reader(Reader reader) {
        ArrayList<Reader> temporary = read_readers();
        temporary.add(reader);
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file_path));
            os.writeObject(temporary);
            os.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Reader look_for_reader(String login) {
        User_list open_list = new User_list();
        ArrayList<Reader> new_list = open_list.read_readers();
        Reader temporary = null;
        for (Reader reader: new_list) {
            if (reader.login.equals(login)) {
                return reader;
            }
        }
        return temporary;
    }
}
