package com.example.dadabhagwan.fragmenttoactivity.LoginAndSignUp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dadabhagwan.fragmenttoactivity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecycleViewFragmentActivity extends Fragment {


    DataBaseHelper dataBaseHelper;
    LinearLayoutManager linearLayoutManager;
    CustomRecycleVIew customRecycleVIew;
    List<UserObject> userObjects;
    Activity context;
    RecyclerView recyclerView;
    public RecycleViewFragmentActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_recycle_view, container, false);
        recyclerView= (RecyclerView) view.findViewById(R.id.showDataBase);
        context=getActivity();
        dataBaseHelper=new DataBaseHelper(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        userObjects=new ArrayList<>();
        userObjects=dataBaseHelper.getFullData();
        customRecycleVIew=new CustomRecycleVIew(context,userObjects);
        recyclerView.setAdapter(customRecycleVIew);
        return view;
    }


}
