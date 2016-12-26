package com.example.dadabhagwan.fragmenttoactivity.LoginAndSignUp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dadabhagwan.fragmenttoactivity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dadabhagwan on 12/22/2016.
 */

public class CustomRecycleVIew extends RecyclerView.Adapter<CustomRecycleVIew.MyViewHolder> {

    Context context;
    List<UserObject> userObjects;

    public CustomRecycleVIew(Context context, List<UserObject> userObjects) {
        this.context = context;
        this.userObjects = userObjects;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_db,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.id.setText(userObjects.get(position).getId()+"");
        holder.name.setText(userObjects.get(position).getName());
        holder.username.setText(userObjects.get(position).getUsername());
        holder.email.setText(userObjects.get(position).getEmail());

        holder.password.setText(userObjects.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return userObjects.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id,name,username,password,email;
        public MyViewHolder(View itemView) {
            super(itemView);
            id= (TextView) itemView.findViewById(R.id.tvId);
            name= (TextView) itemView.findViewById(R.id.tvName);
            username= (TextView) itemView.findViewById(R.id.tvUserName);
            password= (TextView) itemView.findViewById(R.id.tvPassword);
            email= (TextView) itemView.findViewById(R.id.tvEmail);
        }
    }
}
