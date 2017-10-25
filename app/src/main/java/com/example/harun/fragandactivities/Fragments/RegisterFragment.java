package com.example.harun.fragandactivities.Fragments;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.example.harun.fragandactivities.Activities.LoginActivity;
        import com.example.harun.fragandactivities.Models.Person;
        import com.example.harun.fragandactivities.R;
        import com.example.harun.fragandactivities.Utils.Utils;

        import butterknife.BindView;
        import butterknife.ButterKnife;
        import butterknife.OnClick;

/**
 * Created by Harun on 25.10.2017.
 */

public class RegisterFragment  extends Fragment{

    @BindView(R.id.submit_button_reg)
    public Button submitButton;
    @BindView(R.id.user_name_reg)
    public EditText userName;
    @BindView(R.id.user_surname_reg)
    public EditText userSurname;
    @BindView(R.id.user_password_reg)
    public EditText userPassword;
    @BindView(R.id.user_email_reg)
    public EditText userEmail;

    public static RegisterFragment newInstance(){
        return new RegisterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_register,container,false);
        ButterKnife.bind(this,view);
        return view;

    }

    @OnClick(R.id.submit_button_reg)
    public void register(){
        String name=userName.getText().toString();
        String surName=userSurname.getText().toString();
        String email=userEmail.getText().toString();
        String password=userPassword.getText().toString();
        if(name.isEmpty() || surName.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(getActivity(),"Please fill all blanks",Toast.LENGTH_LONG).show();


        }else {

        Person person=new Person(name,surName,email,password);
        Utils.addUser(getActivity(),person);
        Utils.setLoggedInuser(getActivity(),person);
        Toast.makeText(getActivity(),person.getName(),Toast.LENGTH_LONG).show();
        Intent intent =new Intent(getActivity(),LoginActivity.class);
        startActivity(intent);
    }

}}
