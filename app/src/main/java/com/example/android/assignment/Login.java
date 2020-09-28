package com.example.android.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class Login extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;
    private Button Signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginform);
        Name = (EditText) findViewById(R.id.editText);
        Password = (EditText) findViewById(R.id.editText2);
        Info = (TextView) findViewById(R.id.infoText);
        Login = (Button) findViewById(R.id.btnlogin);
        Signup=(Button) findViewById(R.id.btnSignUp);






        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String NameText = Name.getText().toString();
                final String PasswordText= Password.getText().toString();

                validate(NameText, PasswordText,NameText,Name, PasswordText, Password);
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUpForm.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String userName, String userPassword, String nameUser, EditText valuename, String passTxt, EditText valuepass) {
        if ((userName.equals("Admin")) && (userPassword.equals("1234")) && validatePassWord(nameUser,valuename) && validateUsername(passTxt,valuepass)) {
            Intent intent = new Intent(Login.this, NewsFeed.class);
            startActivity(intent);
        } else {
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if (counter == 0) {
                Login.setEnabled(false);
            }
        }
    }



    public Boolean validateUsername(String name, EditText value) {
        if (name.isEmpty()) {
            value.setError("Field cannot be empty");
            return false;
        } else if (name.length() >= 15) {
            value.setError("Username too long");
            return false;


        } else {

            return true;
        }
    }




    public Boolean validatePassWord(String namepass, EditText valuepass) {


        if (namepass.isEmpty()) {
            valuepass.setError("Field cannot be empty");
            return false;

        } else if (namepass.length() > 20) {
            valuepass.setError("password is too long");
            return false;
        } else {

            return true;
        }
    }


    //public class Login extends AppCompatActivity  {
//
//
//
//
//    @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.loginform);
//            // when the signin button is clicked then we should display this
//
//            Button button= (Button) findViewById(R.id.button);
//        final EditText userNameValue= (EditText) findViewById(R.id.editText);
//        final EditText passWordValue= (EditText) findViewById(R.id.editText2);
//        final String userName= userNameValue.getText().toString();
//        final String passCode=passWordValue.getText().toString();
//
//
//            button.setOnClickListener(new View.OnClickListener(){
//
//
//

}
//
//                @Override
//                public void onClick(View view) {
//
//
//                    if( validatePassWord () && validateUsername()) {
//                        Intent newsFeed = new Intent(Login.this, NewsFeed.class);
//                        startActivity(newsFeed);
//
//                    }
//                    else{
//                        Toast.makeText(Login.this,"User name and password did not match",Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//            });
//
//
//
//            Button  signUpbtn=(Button) findViewById(R.id.button2);
//
//            signUpbtn.setOnClickListener(new View.OnClickListener(){
//
//
//                @Override
//                public void onClick(View view) {
//
//
//
//                        Intent newsFeed1 = new Intent(Login.this, SignUpForm.class);
//                        startActivity(newsFeed1);
//
//
//                }
//            });
//        }
//
//
//}
