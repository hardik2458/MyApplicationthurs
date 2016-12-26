package com.example.dadabhagwan.fragmenttoactivity;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.dadabhagwan.fragmenttoactivity.R.id.fragmentB;

public class MainActivity extends AppCompatActivity implements FragA.FlighSearcher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void searchForFlights(String origin, String Destination) {
    FragB fragB=new FragB();

    fragB= (FragB)getFragmentManager().findFragmentById(fragmentB);
    String result=origin+" "+Destination;
    fragB.displayResult(result);
    }
}
