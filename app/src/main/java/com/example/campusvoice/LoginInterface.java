package com.example.campusvoice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginInterface extends AppCompatActivity {

    private Button loginButton;
    private Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Connect Welcome XML
        setContentView(R.layout.activity_welcome_interface);

        // Link XML buttons to Java
        loginButton = findViewById(R.id.loginButton);

        createAccountButton =
                findViewById(R.id.createAccountButton);

        // LOGIN BUTTON
        loginButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginInterface.this,
                    LoginActivity.class
            );

            startActivity(intent);
        });

        // CREATE ACCOUNT BUTTON
        createAccountButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginInterface.this,
                    CreateAccountActivity.class
            );

            startActivity(intent);
        });
    }
}
