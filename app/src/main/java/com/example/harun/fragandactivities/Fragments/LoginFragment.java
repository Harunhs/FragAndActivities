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


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @OnClick(R.id.register_button_log)
    public void register() {

        Intent intent = new Intent(getActivity(), RegisterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.submit_button_log)
    public void submit() {
        String userName = userNameLog.getText().toString();
        String password = userPasswordLog.getText().toString();

        if (Utils.login(getActivity(), userName, password) == true) {
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            startActivity(intent);
        } else if(userName.equals(null) || password.equals(null)){
            Toast.makeText(getActivity(), "Fill the blanks", Toast.LENGTH_LONG).show();
    }
        else
            Toast.makeText(getActivity(),"Incorrect user or password",Toast.LENGTH_LONG).show();


    }
}