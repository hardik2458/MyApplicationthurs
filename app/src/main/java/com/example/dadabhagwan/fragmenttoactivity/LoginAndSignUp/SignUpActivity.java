package com.example.dadabhagwan.fragmenttoactivity.LoginAndSignUp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dadabhagwan.fragmenttoactivity.R;

public class SignUpActivity extends AppCompatActivity {

    EditText name,username,password,confirm_password,email;
    Button signup;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name= (EditText) findViewById(R.id.etName);
        username= (EditText) findViewById(R.id.etUserName);
        password= (EditText) findViewById(R.id.etPassword);
        confirm_password= (EditText) findViewById(R.id.etConfirmPassword);
        email= (EditText) findViewById(R.id.etEmail);

        signup= (Button) findViewById(R.id.btnSubmit);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass1=password.getText().toString();
                String pass2=confirm_password.getText().toString();


              if(pass1.equals(pass2))
              {
                insertdata();
              }
              else
              {
                  Toast.makeText(SignUpActivity.this, "sorry password not matched", Toast.LENGTH_SHORT).show();
              }

            }
        });


    }

    private String insertdata()   {
    dataBaseHelper=new DataBaseHelper(this);

     UserObject userObject=new UserObject();
     userObject.setName(name.getText().toString());
     userObject.setUsername(username.getText().toString());
     userObject.setPassword(password.getText().toString());
     userObject.setEmail(email.getText().toString());

    String status=dataBaseHelper.insertData(userObject);
        Toast.makeText(this, status+"", Toast.LENGTH_SHORT).show();
    return status;
    }
}
