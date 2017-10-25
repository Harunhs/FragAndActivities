package com.example.harun.fragandactivities.Models;

import java.util.ArrayList;

/**
 * Created by Harun on 25.10.2017.
 */
public class People {
    private ArrayList<Person> people;

    public People(ArrayList<Person> people) {
        this.people = people;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
}

