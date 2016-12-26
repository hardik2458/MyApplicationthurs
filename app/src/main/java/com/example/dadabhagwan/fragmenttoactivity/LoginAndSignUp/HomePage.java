package com.example.dadabhagwan.fragmenttoactivity.LoginAndSignUp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dadabhagwan.fragmenttoactivity.R;

import static android.R.attr.fragment;

public class HomePage extends FragmentActivity{
    public FragmentCommunicator fragmentCommunicator;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        String accountInformation=getIntent().getStringExtra("user");
        fragmentCommunicator.passDataToFragment(accountInformation);
//        Intent intent=new Intent();
//        intent.putExtra("user1",accountInformation);
//        startActivity(intent);



    }

    @Override
    public void onAttachFragment(android.support.v4.app.Fragment fragment) {
        super.onAttachFragment(fragment);
        this.fragmentCommunicator= (FragmentCommunicator) fragment;

    }

    public interface FragmentCommunicator{
        public void passDataToFragment(String someValue);
    }


}