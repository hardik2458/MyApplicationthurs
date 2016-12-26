package com.example.dadabhagwan.fragmenttoactivity;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragB extends android.app.Fragment {


    public FragB() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_b, container, false);
    }

    public void displayResult(String result)
    {
        TextView getRes= (TextView) getActivity().findViewById(R.id.result);
        getRes.setText(result);
    }


}
