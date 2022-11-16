package com.example.a01honey_comb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    ImageView mImageReturn;
    TextInputEditText mTextInputEditTextUsernameR;
    TextInputEditText mTextInputEditTextEmailR;
    TextInputEditText mTextInputEditTextPasswordR;
    TextInputEditText mTextInputEditTextConfirmPasswordR;
    Button mButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //instanciamos...

        mImageReturn= findViewById(R.id.ImageReturn);
        mTextInputEditTextUsernameR= findViewById(R.id.TextInputEditTextUsernameR);
        mTextInputEditTextEmailR= findViewById(R.id.TextInputEditTextEmailR);
        mTextInputEditTextPasswordR= findViewById(R.id.TextInputEditTextPasswordR);
        mTextInputEditTextConfirmPasswordR= findViewById(R.id.TextInputEditTextConfirmPasswordR);
        mButtonRegister= findViewById(R.id.ButtonRegister);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        mImageReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void register() {
        String username= mTextInputEditTextUsernameR.getText().toString();
        String email= mTextInputEditTextEmailR.getText().toString();
        String password= mTextInputEditTextPasswordR.getText().toString();
        String confirmPassword= mTextInputEditTextConfirmPasswordR.getText().toString();

        if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()){
            if (isEmailValid(email)){
                Toast.makeText(this, "¡Perfecto!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Tu correo no es válido", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "¡Ups! Parece que te falta algo...", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isEmailValid(String email){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



}