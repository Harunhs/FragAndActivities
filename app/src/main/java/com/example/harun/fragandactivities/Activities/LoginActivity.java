package com.example.harun.fragandactivities.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.harun.fragandactivities.Fragments.LoginFragment;
import com.example.harun.fragandactivities.Fragments.ProfileFragment;
import com.example.harun.fragandactivities.Fragments.RegisterFragment;
import com.example.harun.fragandactivities.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harun on 25.10.2017.
 */

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commit();



    }
}
