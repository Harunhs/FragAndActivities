package com.example.harun.fragandactivities.Models;

/**
 * Created by Harun on 25.10.2017.
 */
public class Person {
    private String name, surname, mail, password;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person(String name, String surname, String mail,
                  String password) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;

        this.password = password;

    }


}