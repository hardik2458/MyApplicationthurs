package com.example.dadabhagwan.fragmenttoactivity.LoginAndSignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dadabhagwan.fragmenttoactivity.R;

public class HOMEACTIVITY extends AppCompatActivity {

    Button createUser;
    Button loginPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        createUser= (Button) findViewById(R.id.btnSignUp);
        loginPage= (Button) findViewById(R.id.btnLogInPage);
        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HOMEACTIVITY.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HOMEACTIVITY.this,LoginPage.class);
                startActivity(intent);
            }
        });
    }
}
