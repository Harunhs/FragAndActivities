package com.example.harun.fragandactivities.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.harun.fragandactivities.Fragments.RegisterFragment;
import com.example.harun.fragandactivities.R;

import butterknife.ButterKnife;

/**
 * Created by Harun on 25.10.2017.
 */

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerReg, RegisterFragment.newInstance())
                .commit();

    }
}
