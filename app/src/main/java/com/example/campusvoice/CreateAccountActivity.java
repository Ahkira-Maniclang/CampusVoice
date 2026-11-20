package com.example.campusvoice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText fullNameInput;
    private EditText identifierInput;
    private EditText emailInput;
    private EditText usernameInput;
    private EditText passwordInput;
    private EditText confirmPasswordInput;
    private EditText adminCodeInput;

    private TextView identifierLabel;
    private RadioGroup accountTypeGroup;
    private View adminCodeContainer;
    private CheckBox termsCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // CONNECT XML LAYOUT
        setContentView(R.layout.activity_create_account);

        // CONNECT INPUT FIELDS
        fullNameInput = findViewById(R.id.fullNameInput);

        identifierInput = findViewById(R.id.identifierInput);

        emailInput = findViewById(R.id.emailInput);

        usernameInput = findViewById(
                R.id.registrationUsernameInput
        );

        passwordInput = findViewById(
                R.id.registrationPasswordInput
        );

        confirmPasswordInput = findViewById(
                R.id.confirmPasswordInput
        );

        adminCodeInput = findViewById(R.id.adminCodeInput);

        // CONNECT ACCOUNT TYPE ELEMENTS
        accountTypeGroup = findViewById(
                R.id.registrationAccountTypeGroup
        );

        adminCodeContainer = findViewById(
                R.id.adminCodeContainer
        );

        identifierLabel = findViewById(R.id.identifierLabel);

        // CONNECT CHECKBOX AND BUTTONS
        termsCheckBox = findViewById(R.id.termsCheckBox);

        MaterialButton submitButton = findViewById(
                R.id.submitRegistrationButton
        );

        ImageView backArrow = findViewById(
                R.id.registrationBackArrow
        );

        TextView backToLogin = findViewById(
                R.id.backToLogin
        );

        // BACK ARROW
        backArrow.setOnClickListener(v -> finish());

        // ALREADY HAVE AN ACCOUNT? LOG IN
        backToLogin.setOnClickListener(v -> {
            openLogin();
        });

        // STUDENT / ADMINISTRATOR SELECTION
        accountTypeGroup.setOnCheckedChangeListener(
                (group, checkedId) -> {

                    boolean isAdmin = checkedId ==
                            R.id.registrationAdministrator;

                    updateAccountType(isAdmin);
                }
        );

        // APPLY INITIAL STUDENT/ADMIN SELECTION
        updateAccountType(
                accountTypeGroup.getCheckedRadioButtonId()
                        == R.id.registrationAdministrator
        );

        // CREATE ACCOUNT BUTTON
        submitButton.setOnClickListener(v -> {
            validateRegistration();
        });
    }

    // UPDATE FIELDS BASED ON ACCOUNT TYPE
    private void updateAccountType(boolean isAdmin) {

        adminCodeContainer.setVisibility(
                isAdmin ? View.VISIBLE : View.GONE
        );

        identifierLabel.setText(
                isAdmin ? "Staff ID" : "Student ID"
        );

        identifierInput.setHint(
                isAdmin
                        ? "Enter your staff ID"
                        : "Enter your student ID"
        );
    }

    // VALIDATE REGISTRATION FORM
    private void validateRegistration() {

        String fullName = fullNameInput.getText()
                .toString().trim();

        String identifier = identifierInput.getText()
                .toString().trim();

        String email = emailInput.getText()
                .toString().trim();

        String username = usernameInput.getText()
                .toString().trim();

        String password = passwordInput.getText()
                .toString();

        String confirmPassword = confirmPasswordInput.getText()
                .toString();

        boolean isAdmin =
                accountTypeGroup.getCheckedRadioButtonId()
                        == R.id.registrationAdministrator;

        // CHECK FULL NAME
        if (fullName.isEmpty()) {
            showFieldError(
                    fullNameInput,
                    "Full name is required"
            );
            return;
        }

        // CHECK STUDENT OR STAFF ID
        if (identifier.isEmpty()) {
            showFieldError(
                    identifierInput,
                    isAdmin
                            ? "Staff ID is required"
                            : "Student ID is required"
            );
            return;
        }

        // CHECK EMAIL
        if (email.isEmpty()) {
            showFieldError(
                    emailInput,
                    "Email address is required"
            );
            return;
        }

        // VALIDATE EMAIL FORMAT
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showFieldError(
                    emailInput,
                    "Enter a valid email address"
            );
            return;
        }

        // CHECK USERNAME
        if (username.isEmpty()) {
            showFieldError(
                    usernameInput,
                    "Username is required"
            );
            return;
        }

        // CHECK PASSWORD
        if (password.isEmpty()) {
            showFieldError(
                    passwordInput,
                    "Password is required"
            );
            return;
        }

        // MINIMUM PASSWORD LENGTH
        if (password.length() < 6) {
            showFieldError(
                    passwordInput,
                    "Password must have at least 6 characters"
            );
            return;
        }

        // CHECK CONFIRM PASSWORD
        if (confirmPassword.isEmpty()) {
            showFieldError(
                    confirmPasswordInput,
                    "Please confirm your password"
            );
            return;
        }

        // CHECK IF PASSWORDS MATCH
        if (!password.equals(confirmPassword)) {
            showFieldError(
                    confirmPasswordInput,
                    "Passwords do not match"
            );
            return;
        }

        // ADMINISTRATOR REGISTRATION CODE
        if (isAdmin) {

            String adminCode = adminCodeInput.getText()
                    .toString().trim();

            if (adminCode.isEmpty()) {
                showFieldError(
                        adminCodeInput,
                        "Administrator code is required"
                );
                return;
            }
        }

        // TERMS AND CONDITIONS
        if (!termsCheckBox.isChecked()) {

            Toast.makeText(
                    this,
                    "Please agree to the Terms and Conditions.",
                    Toast.LENGTH_SHORT
            ).show();

            termsCheckBox.requestFocus();
            return;
        }

        // SUCCESSFUL DEMO VALIDATION
        showSuccessDialog();
    }

    // SHOW INPUT ERROR
    private void showFieldError(
            EditText input,
            String message
    ) {

        input.setError(message);
        input.requestFocus();
    }

    // SUCCESS MESSAGE
    private void showSuccessDialog() {

        new AlertDialog.Builder(this)
                .setTitle("Registration Demo Complete!")
                .setMessage(
                        "Your registration form passed validation.\n\n"
                                + "This is a classroom demo, so the account "
                                + "has not been saved.\n\n"
                                + "Please use the provided demo credentials "
                                + "to log in."
                )
                .setCancelable(false)
                .setPositiveButton(
                        "Go to Login",
                        (dialog, which) -> openLogin()
                )
                .show();
    }

    // NAVIGATE TO LOGIN SCREEN
    private void openLogin() {

        Intent intent = new Intent(
                CreateAccountActivity.this,
                LoginActivity.class
        );

        intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_SINGLE_TOP
        );

        startActivity(intent);
        finish();
    }
}
