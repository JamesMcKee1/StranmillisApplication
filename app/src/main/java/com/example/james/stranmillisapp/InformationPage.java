package com.example.james.stranmillisapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by James on 27/06/2016.
 */
public class InformationPage extends MainPage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_page);
    }

    public void returnClick(View v) {
        startActivity(new Intent(InformationPage.this, MainPage.class));
    }
}
