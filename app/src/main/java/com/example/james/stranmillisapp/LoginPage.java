package com.example.james.stranmillisapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by James on 23/07/2016.
 */
public class LoginPage extends MainPage {

    private EditText userNameField, passwordField;

    // initialising the variable for the counter as an integer
    int countDown = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        // creating the button
        final Button loginButton = (Button) findViewById(R.id.loginButton);
        // creating the TextView counter
        final TextView counter = (TextView) findViewById(R.id.text_attempts);
        // creating the EditText username
        userNameField = (EditText) findViewById(R.id.edit_username);
        // creating the EditText password
        passwordField = (EditText) findViewById(R.id.edit_password);

//        // register click event with first button
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                // if statement to check if the string is the correct login details
//                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
//                    // correct password
//                    successfulLoginToast();
//
//
//                }else{
//                    // wrong password
//                    unsuccessfulLoginToast();
//
//                    // decrementing the counter
//                    countDown--;
//                    counter.setText(Integer.toString(countDown));
//                    counter.setVisibility(View.VISIBLE);
//
//                    // setting the text color of the counter to red
//                    counter.setTextColor(Color.RED);
//
//                    // setting the color of the button to red
//                    loginButton.setBackgroundColor(Color.RED);
//
//                    // disabling the button after reaching 3 attempts
//                    if(countDown == 0) {
//                        loginButton.setEnabled(false);
//                    }
//                }
//            }
//
//        });

    }

//    // Method to produce a Toast after an successful login attempt
//    public void successfulLoginToast() {
//
//        Toast.makeText(getApplicationContext(), "You are successful to login",
//                Toast.LENGTH_SHORT).show();
//    }
//
//    // Method to produce a Toast after an unsuccessful login attempt
//    public void unsuccessfulLoginToast() {
//
//        Toast.makeText(getApplicationContext(), "Wrong username or password",
//                Toast.LENGTH_SHORT).show();
//    }

    public void backButton(View v) {

        startActivity(new Intent(LoginPage.this, LoginRegisterPage.class));
    }

    public void loginNowClick(View view) {

        String username = userNameField.getText().toString();
        String password = passwordField.getText().toString();
        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);

        backgroundWorker.execute(type, username, password);

//        openCourseSelection();

    }

//    public void openCourseSelection() {
//
//        Intent loginIntent = new Intent(LoginPage.this, CourseSelectionPage.class);
//        startActivity(loginIntent);
//    }

}

