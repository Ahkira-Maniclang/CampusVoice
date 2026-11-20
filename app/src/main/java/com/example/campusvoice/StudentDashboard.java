package com.example.campusvoice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student_dashboard);

        // CONNECT XML ELEMENTS
        ImageView backArrow =
                findViewById(R.id.studentBackArrow);

        ImageButton profileButton =
                findViewById(R.id.imageButton);

        ImageButton notificationButton =
                findViewById(R.id.imageButton2);

        ImageButton complaintButton =
                findViewById(R.id.imageButton3);

        ImageButton feedbackButton =
                findViewById(R.id.imageButton4);

        // BACK ARROW - RETURN TO LOGIN
        backArrow.setClickable(true);
        backArrow.setFocusable(true);
        backArrow.setElevation(100f);
        backArrow.bringToFront();

        backArrow.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboard.this,
                    LoginActivity.class
            );

            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP
                            | Intent.FLAG_ACTIVITY_SINGLE_TOP
            );

            startActivity(intent);
            finish();
        });

        // PROFILE
        profileButton.setOnClickListener(v ->
                showUnavailable("Profile"));

        // NOTIFICATION
        notificationButton.setOnClickListener(v ->
                showUnavailable("Notification"));

        // COMPLAINT
        complaintButton.setOnClickListener(v ->
                showUnavailable("Complaint"));

        // FEEDBACK
        feedbackButton.setOnClickListener(v ->
                showUnavailable("Feedback"));
    }

    // UNAVAILABLE FEATURE MESSAGE
    private void showUnavailable(String feature) {

        Toast.makeText(
                this,
                feature + " feature is not available in this demo yet.",
                Toast.LENGTH_SHORT
        ).show();
    }
}
