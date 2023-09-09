/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
class DataBase {

    private List<user> listOfUsers;
    private File save = new File("save.io");

    public DataBase() throws FileNotFoundException {
        try {

            if (save.exists()) {
                ObjectInputStream readingUsers = new ObjectInputStream(new FileInputStream(save));
                listOfUsers = (List<user>) (readingUsers.readObject());
                readingUsers.close();
            } else {
                listOfUsers = new ArrayList<>();
                ObjectOutputStream writingT = new ObjectOutputStream(new FileOutputStream(save));
                writingT.writeObject(listOfUsers);
                writingT.close();

            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void addUser(user user) {

        listOfUsers.add(user);
        try {
            ObjectOutputStream writingT = new ObjectOutputStream(new FileOutputStream(save));
            writingT.writeObject(listOfUsers);
            writingT.close();
        } catch (IOException e) {
            System.out.println(e);

        }
    }

    public List<user> getUsers() {
        return listOfUsers;
    }

}
