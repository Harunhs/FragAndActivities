package com.example.harun.fragandactivities.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.harun.fragandactivities.Activities.LoginActivity;
import com.example.harun.fragandactivities.Activities.ProfileActivity;
import com.example.harun.fragandactivities.Activities.RegisterActivity;
import com.example.harun.fragandactivities.Models.People;
import com.example.harun.fragandactivities.R;
import com.example.harun.fragandactivities.Utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harun on 25.10.2017.
 */

public class LoginFragment extends Fragment {


    @BindView(R.id.register_button_log)
    public Button registerButtonLog;
    @BindView(R.id.submit_button_log)
    public Button submitButtonLog;
    @BindView(R.id.user_name_log)
    public EditText userNameLog;
    @BindView(R.id.user_password_log)
    public EditText userPasswordLog;


    public static LoginFragment newInstance(){
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_login,container,false);
        ButterKnife.bind(this,view);
        return view;

    }

    @OnClick(R.id.register_button_log)
    public void register(){

        Intent intent=new Intent(getActivity(),RegisterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.submit_button_log)
    public void submit(){
        String userName=userNameLog.getText().toString();
        String password=userPasswordLog.getText().toString();
        People people =Utils.getUsers(getActivity());


        boolean a=true;
        for(int i=0;i<people.getPeople().size();i++) {

            while (!a) {

                if (userName.equals(people.getPeople().get(i).getName())
                        && password.equals(people.getPeople().get(i).getPassword())) {

                    Intent intent = new Intent(getActivity(), ProfileActivity.class);
                    startActivity(intent);
                    Utils.setLoggedInuser(getActivity(), people.getPeople().get(i));
                    a=false;


                } else
                    Toast.makeText(getActivity(), "Wrong username or password", Toast.LENGTH_LONG).show();

            }

        }
        Intent intent=new Intent(getActivity(), ProfileActivity.class);
        startActivity(intent);
    }
}
