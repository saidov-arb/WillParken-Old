package com.willparken.model;

import android.media.Image;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User implements Serializable {
    private String firstname;
    private String lastname;
    private Image profilePicture;
    private String address;
    private String telephoneNumber;
    private String email;
    private String passwordHash;

    public User(String firstname, String lastname, Image profilePicture, String address, String telephoneNumber, String email, String passwordHash) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.profilePicture = profilePicture;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public User() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Image getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Image profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }




    public void save() {
        SerializationFactory.getInstance().save(this);
    }

    public void remove() {
        SerializationFactory.getInstance().remove(this);
    }

    public static User selectByEmailPassword(String email, String password) {
        return SerializationFactory.getInstance().selectUserByEmailPassword(email, password);
    }

    public static String encryptPassword(String password) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes(), 0, password.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            //Impossible
            System.out.println("Error during encryption of: \"" + password + "\".");
            return null;
        }
    }


    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", email='" + email + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User iUser = (User) o;

        return getEmail().equals(iUser.getEmail());
    }
}
