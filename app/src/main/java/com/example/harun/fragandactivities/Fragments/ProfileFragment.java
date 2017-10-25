package com.example.harun.fragandactivities.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.harun.fragandactivities.Models.People;
import com.example.harun.fragandactivities.Models.Person;
import com.example.harun.fragandactivities.R;
import com.example.harun.fragandactivities.Utils.Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Harun on 25.10.2017.
 */

public class ProfileFragment extends Fragment {
    @BindView(R.id.nameText)
    public TextView nameText;
    @BindView(R.id.surNameText)
    public TextView surNameText;
    @BindView(R.id.emailText)
    public TextView emailText;


    public static ProfileFragment newInstance(){
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_profile,container,false);
        ButterKnife.bind(this,view);
        setViews();
        return view;

    }


    public void setViews(){

        Person person=Utils.getLoggedInUser(getActivity());

        nameText.setText(person.getName());
        surNameText.setText(person.getSurname());
        emailText.setText(person.getMail());


    }

}
