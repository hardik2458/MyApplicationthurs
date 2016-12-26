package com.example.dadabhagwan.fragmenttoactivity.LoginAndSignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dadabhagwan.fragmenttoactivity.R;

public class LoginPage extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    EditText username,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        username= (EditText) findViewById(R.id.etLoginUserName);
        password= (EditText) findViewById(R.id.edLoginPassword);
        login= (Button) findViewById(R.id.btnSignIn);
        dataBaseHelper=new DataBaseHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              String pass1= password.getText().toString();
              String uname=username.getText().toString();

              String DBpassword=dataBaseHelper.searchPass(uname);
              if(DBpassword.equals(pass1))
              {
                  Intent ToYourAccount=new Intent(LoginPage.this,HomePage.class);
                  ToYourAccount.putExtra("user",uname);
                  startActivity(ToYourAccount);
              }
              else {
                  Toast.makeText(LoginPage.this, "Sorry User Not Dound...", Toast.LENGTH_SHORT).show();
              }
            }
        });

    }
}
