package com.example.harun.fragandactivities.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.harun.fragandactivities.Models.People;
import com.example.harun.fragandactivities.Models.Person;
import com.google.gson.Gson;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Harun on 25.10.2017.
 */

public class Utils {

    private static final String USER_PREF = "USERS";
    private static final String LOGGED_IN_PREF = "LOGGED_IN";


    public static People getUsers(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREF,MODE_PRIVATE);
        Gson gson  = new Gson();
        String json = sharedPreferences.getString("People",null);
        return gson.fromJson(json,People.class);
    }

    public static void addUser(Context context, Person person){

        People people;
        if (getUsers(context) !=null){
            people = getUsers(context);
        }else{
            ArrayList<Person> persons = new ArrayList<>();
            people = new People(persons);
        }

        ArrayList<Person> tempPersons = people.getPeople();
        tempPersons.add(person);
        people.setPeople(tempPersons);

        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(people);
        editor.putString("People",json);
        editor.apply();
    }
    public static boolean login(Context context,String username,String password){
        if (getUsers(context) == null){
            return false;
        }else {
            ArrayList<Person> people = getUsers(context).getPeople();
            for (Person person : people) {
                if (person.getName().equals(username) && person.getPassword().equals(password)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void logout(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(LOGGED_IN_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        
        String json = gson.toJson(null);
        editor.putString("Logged_In",json);
        editor.apply();
    }


    public static void setLoggedInuser(Context context,Person person){
        SharedPreferences sharedPreferences = context.getSharedPreferences(LOGGED_IN_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(person);
        editor.putString("Logged_In",json);
        editor.apply();
    }



    public static Person getLoggedInUser(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(LOGGED_IN_PREF,MODE_PRIVATE);
        Gson gson  = new Gson();
        String json = sharedPreferences.getString("Logged_In",null);
        return gson.fromJson(json,Person.class);
    }

}
