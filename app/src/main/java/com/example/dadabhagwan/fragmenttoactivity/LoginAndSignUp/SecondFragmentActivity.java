package com.example.dadabhagwan.fragmenttoactivity.LoginAndSignUp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.dadabhagwan.fragmenttoactivity.R;

public class SecondFragmentActivity extends FragmentActivity implements BlankFragment.passDataToSecondActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_fragment);
        Intent intent=getIntent();
        String wait=intent.getStringExtra("public_data");
        Toast.makeText(this, wait+"", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void sendDataToSecondActivity(String dataValue) {

    }

}
