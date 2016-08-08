package com.example.james.stranmillisapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by James on 23/07/2016.
 */
public class LoginRegisterPage extends MainPage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register_page);
    }

    public void loginButton(View v) {
        startActivity(new Intent(LoginRegisterPage.this, LoginPage.class));
    }

    public void registerButton(View v) {
        startActivity(new Intent(LoginRegisterPage.this, RegisterPage.class));
    }

    public void backButtonClick(View v) {
        startActivity(new Intent(LoginRegisterPage.this, MainPage.class));
    }
}
