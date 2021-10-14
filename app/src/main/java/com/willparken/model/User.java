package com.willparken.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String familyname;
    private String drivingLicense;
    private String address;
    private int telephoneNumber;
    private String email;
    private String passwordHash;

    public User(String name, String familyname, String drivingLicense, String address, int telephoneNumber, String email, String passwordHash) {
        this.name = name;
        this.familyname = familyname;
        this.drivingLicense = drivingLicense;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
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
                "name='" + name + '\'' +
                ", familyname='" + familyname + '\'' +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", email='" + email + '\'' +
                '}';
    }

}
