package com.example.campusvoice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameInput, passwordInput;
    private RadioButton radioStudent, radioAdministrator;
    private MaterialButton loginButton, createAccountButton;
    private ImageView backArrow;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> insets
        );

        // CONNECT XML ELEMENTS TO JAVA
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);

        radioStudent = findViewById(R.id.radioStudent);
        radioAdministrator = findViewById(
                R.id.radioAdministrator
        );

        loginButton = findViewById(R.id.loginButton);
        createAccountButton = findViewById(
                R.id.createAccountButton
        );

        backArrow = findViewById(R.id.backArrow);
        forgotPassword = findViewById(R.id.forgotPassword);

        // BACK ARROW - RETURN TO WELCOME
        backArrow.setOnClickListener(v -> finish());

        // CREATE ACCOUNT BUTTON
        createAccountButton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LoginActivity.this,
                    CreateAccountActivity.class
            );
            startActivity(intent);
        });

        // FORGOT PASSWORD - DEMO MESSAGE
        forgotPassword.setOnClickListener(v -> {
            Toast.makeText(
                    LoginActivity.this,
                    "Password recovery is not available in this demo.",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // LOGIN BUTTON
        loginButton.setOnClickListener(v -> loginUser());
    }

    // LOGIN VALIDATION AND NAVIGATION
    private void loginUser() {

        String username = usernameInput.getText()
                .toString().trim();

        String password = passwordInput.getText()
                .toString();

        // VALIDATE USERNAME
        if (username.isEmpty()) {
            usernameInput.setError("Username is required");
            usernameInput.requestFocus();
            return;
        }

        // VALIDATE PASSWORD
        if (password.isEmpty()) {
            passwordInput.setError("Password is required");
            passwordInput.requestFocus();
            return;
        }

        // CHECK SELECTED ACCOUNT TYPE
        if (radioStudent.isChecked()) {

            // DEMO STUDENT CREDENTIALS
            if (username.equals("student")
                    && password.equals("student123")) {

                Toast.makeText(
                        this,
                        "Student demo login successful!",
                        Toast.LENGTH_SHORT
                ).show();

                Intent intent = new Intent(
                        LoginActivity.this,
                        StudentDashboard.class
                );

                startActivity(intent);
                finish();

            } else {
                showLoginError();
            }

        } else if (radioAdministrator.isChecked()) {

            // DEMO ADMIN CREDENTIALS
            if (username.equals("admin")
                    && password.equals("admin123")) {

                Toast.makeText(
                        this,
                        "Administrator demo login successful!",
                        Toast.LENGTH_SHORT
                ).show();

                Intent intent = new Intent(
                        LoginActivity.this,
                        AdministratorDashboard.class
                );

                startActivity(intent);
                finish();

            } else {
                showLoginError();
            }

        } else {
            Toast.makeText(
                    this,
                    "Please select an account type.",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    // INVALID CREDENTIALS MESSAGE
    private void showLoginError() {
        Toast.makeText(
                this,
                "Invalid demo username or password.",
                Toast.LENGTH_LONG
        ).show();
    }
}
