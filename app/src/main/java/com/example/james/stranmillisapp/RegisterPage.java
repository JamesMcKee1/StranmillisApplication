package com.example.james.stranmillisapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by James on 23/07/2016.
 */
public class RegisterPage extends MainPage {

    EditText email, password;
    String str_email, str_password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        email = (EditText)findViewById(R.id.editTextEmail);
        password = (EditText)findViewById(R.id.editPassword);
    }

    public void registerClick(View view) {

        String str_email = email.getText().toString();
        String str_password = password.getText().toString();
        String type = "register";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);

        backgroundWorker.execute(type, str_email, str_password);

    }


    public void backButton(View v) {

        startActivity(new Intent(RegisterPage.this, LoginRegisterPage.class));
    }

}
