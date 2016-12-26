package com.example.dadabhagwan.fragmenttoactivity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragA extends Fragment {

    FlighSearcher flighSearcher;

    public FragA() {
        // Required empty public constructor
    }

    public interface FlighSearcher
    {
        public void searchForFlights(String origin,String Destination);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fraga, container, false);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        this.flighSearcher= (FlighSearcher) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button= (Button) getActivity().findViewById(R.id.click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner origin= (Spinner) getActivity().findViewById(R.id.origin);
                Spinner dest= (Spinner) getActivity().findViewById(R.id.destination);

                flighSearcher.searchForFlights(origin.getSelectedItem().toString(),dest.getSelectedItem().toString());

            }
        });
    }
}
