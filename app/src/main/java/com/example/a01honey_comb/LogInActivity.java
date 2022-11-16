package com.example.a01honey_comb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class LogInActivity extends AppCompatActivity {

    TextInputEditText mTextInputEditTextEmail;
    TextInputEditText mTextInputEditTextPassword;
    Button mButtonLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mTextInputEditTextEmail= findViewById(R.id.TextInputEditTextEmail);
        mTextInputEditTextPassword= findViewById(R.id.TextInputEditTextPassword);
        mButtonLogIn= findViewById(R.id.ButtonLogIn);
        

        mButtonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String email= mTextInputEditTextEmail.getText().toString();
        String password= mTextInputEditTextPassword.getText().toString();
        Log.d("campo", "email" + email);
        Log.d("campo", "password" + password);
    }
}