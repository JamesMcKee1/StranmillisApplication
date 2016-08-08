package com.example.james.stranmillisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void enterClick(View v) {
        startActivity(new Intent(MainPage.this, LoginRegisterPage.class));
    }
    public void infoClick(View v) {
        startActivity(new Intent(MainPage.this, InformationPage.class));
    }
}
