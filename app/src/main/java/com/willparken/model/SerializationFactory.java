package com.willparken.model;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class SerializationFactory
{
    private static SerializationFactory instance = null;

    /**
     * List objects contains all the objects, that are going to be written into the file.
     */
    private List<Serializable> objects;

    private SerializationFactory() {
        this.objects = new LinkedList<>();
    }


    /**
     * Returns the actual Instance.
     * With it, it is possible to access all the Methods in here, as if
     * the Methods were static.
     * For example:
     *      SerializationFactory.getInstance().persist();
     * @return
     */
    public static SerializationFactory getInstance() {
        if (instance == null) {
            instance = new SerializationFactory();
        }
        return instance;
    }


    /**
     * Saves an object into the List objects.
     * If this object already exits, it's going to be deleted and added as a ned Object.
     * @param ser
     */
    public void save(Serializable ser)
    {
        if (objects.contains(ser)) {
            objects.remove(ser);
        }
        objects.add(ser);
    }


    /**
     * Removes an object from the List objects, if objects contains the object
     * @param ser
     */
    public void remove(Serializable ser) {
        if (objects.contains(ser)) {
            objects.remove(ser);
        }

        System.out.println(objects);
    }


    /**
     * Checks, if object exists in objects List.
     * @param ser
     * @return
     */
    public boolean exists(Serializable ser) {
        if (objects.contains(ser)) {
            return true;
        }
        return false;
    }


    /**
     * Saves the objects List in a File called "serialObjects.ser".
     */
    public void persist(Context fileContext) {
        try (ObjectOutputStream oos = new ObjectOutputStream(fileContext.openFileOutput("serialObjects.ser",MODE_PRIVATE))) {
            //This line saves the objects into the File given.
            oos.writeObject(objects);
        }
        catch (IOException e) {
            // kann nicht auftreten
            e.printStackTrace();
        }
    }


    /**
     * Reads the objects out of the File called "serialObjects.ser" and saves every object
     * into the List objects.
     */
    public void restore(Context fileContext) {
        try (ObjectInputStream ois = new ObjectInputStream(fileContext.openFileInput("serialObjects.ser"))) {
            //This line reads out the objects from the File given.
            //But why for gods sake do I have to Generify SerializationFactory???
            objects = (List<Serializable>) ois.readObject();
            System.out.println(objects);
        }
        catch (FileNotFoundException e) {
            System.out.println("No Users found! Nothing to restore!");
        }
        catch (InvalidClassException e) {
            System.out.println("Catalog contains class description of different version! Nothing to restore!");
        }
        catch (ClassNotFoundException | IOException e) {
            //Should be Impossible. I have no Idea why I should do this. But please, if it's needed, why not.
            e.printStackTrace();
        }
    }


    /**
     * This Method needs an email and a password as parameters.
     * With these two parameters it checks, whether a User with this email exists and whether
     * the password matches or not.
     * If everythings fine, the user with the exact same email will be returned.
     * @param email String
     * @param password String
     * @return User
     */
    public User selectUserByEmailPassword(String email,String password)
    {
        User found = null;

        int i = 0;

        //Gets the user, with the Email.
        while (i < objects.size() &&
                (!(objects.get(i) instanceof User) ||
                        (objects.get(i) instanceof User &&
                                !((User) (objects.get(i))).getEmail().equals(email)))) {
            i++;
        }

        if (i < objects.size() &&
                objects.get(i) instanceof User)
        {

            found = (User) objects.get(i);
            //Checks, if the password ist correct.
            if (User.encryptPassword(password).equals(found.getPasswordHash()))
            {
                return found;
            }
        }
        return null;
    }
}
