package com.example.android.assignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpForm extends AppCompatActivity {
    private Button createAccountValue;
    private EditText userNameValue;
    private EditText passWordValue;
    private EditText confirmPassValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        createAccountValue = (Button) findViewById(R.id.btnCreateAccount);
          userNameValue = (EditText) findViewById(R.id.usernameET);
          passWordValue = (EditText) findViewById(R.id.passwordET);
        confirmPassValue = (EditText) findViewById(R.id.confirmPassET);


        //Registration button  validation
        createAccountValue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                final String userName = userNameValue.getText().toString();
                final String passWord = userNameValue.getText().toString();
                final String confirmPass = userNameValue.getText().toString();

                if (userName.isEmpty()) {
                    userNameValue.setError("User Name is empty");
                    userNameValue.requestFocus();
                }
                if (userName.length() > 16) {
                    userNameValue.setError("User name cannot be greater than 16");
                    userNameValue.requestFocus();
                }
                if (passWord.isEmpty()) {
                    passWordValue.setError("Password cannot be empty");
                    passWordValue.requestFocus();
                }
                if (passWord.length() < 8) {
                    passWordValue.setError("Password must be 8 or more charachter ");
                }
                if (passWord.length() > 20) {
                    passWordValue.setError("Password must be less than 20");
                    passWordValue.requestFocus();
                }
                if (passWord == confirmPass) {
                    Toast.makeText(SignUpForm.this, "Success", Toast.LENGTH_LONG).show();
                }
            }


        });
    }
}
