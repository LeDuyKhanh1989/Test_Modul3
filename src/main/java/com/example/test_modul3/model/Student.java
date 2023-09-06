package com.example.test_modul3.model;

import java.util.Date;

public class Student {
    int id;
    String name;
    String email;
    String dateOfBirth;
    String Address;
    String phoneNumber;
    Class className;

    public Student(int id, String name, String email, String dateOfBirth, String address, String phoneNumber, Class className) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        Address = address;
        this.phoneNumber = phoneNumber;
        this.className = className;
    }

    public Student(String name, String email, String dateOfBirth, String address, String phoneNumber, Class className) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        Address = address;
        this.phoneNumber = phoneNumber;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }
}
