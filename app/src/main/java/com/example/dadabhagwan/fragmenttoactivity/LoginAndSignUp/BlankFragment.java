package com.example.dadabhagwan.fragmenttoactivity.LoginAndSignUp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dadabhagwan.fragmenttoactivity.R;

public class BlankFragment extends Fragment implements HomePage.FragmentCommunicator {
    passDataToSecondActivity passdata;
    TextView userAccount;
    Button nextFragment;
    String public_data;
    Activity context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank, container, false);
          userAccount= (TextView) view.findViewById(R.id.Aname);
          nextFragment= (Button) view.findViewById(R.id.nextFrag);
        context=getActivity();
        return view;
    }

    @Override
    public void passDataToFragment(String someValue) {
    userAccount.setText(someValue);
    public_data=someValue;
    }

    @Override
    public void onStart() {
        super.onStart();
        nextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,SecondFragmentActivity.class);
                intent.putExtra("public_data",public_data);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public interface passDataToSecondActivity
    {
        public void sendDataToSecondActivity(String dataValue);
    }
}
