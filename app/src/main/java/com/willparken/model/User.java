package com.willparken.model;

import android.media.Image;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    private String firstname;
    private String lastname;
    private Image profilePicture;
    private String address;
    private String telephoneNumber;
    private String email;
    private String passwordHash;

    public User(String firstname, String lastname, Image profilePicture, String address, int telephoneNumber, String email, String passwordHash) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.profilePicture = profilePicture;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public User(){

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

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
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

}
