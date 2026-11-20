package com.example.campusvoice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

public class AdministratorDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ENABLE EDGE TO EDGE
        EdgeToEdge.enable(this);

        // CONNECT XML LAYOUT
        setContentView(R.layout.activity_administrator_dashboard);

        // HANDLE WINDOW INSETS
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> insets
        );

        // CONNECT XML ELEMENTS
        View profileCard = findViewById(R.id.profileCard);
        View notificationCard = findViewById(R.id.notificationCard);

        TextView feedbackText = findViewById(R.id.feedbackText);
        TextView complaintsText = findViewById(R.id.complaintsText);
        TextView manageTitle = findViewById(R.id.manageTitle);
        TextView statusTitle = findViewById(R.id.statusTitle);

        ImageView adminBackArrow =
                findViewById(R.id.adminBackArrow);

        // BACK ARROW - RETURN TO LOGIN SCREEN
        adminBackArrow.setOnClickListener(v -> {

            Intent intent = new Intent(
                    AdministratorDashboard.this,
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
        profileCard.setOnClickListener(v ->
                showUnavailable("Profile"));

        // NOTIFICATION
        notificationCard.setOnClickListener(v ->
                showUnavailable("Notification"));

        // FEEDBACK
        feedbackText.setOnClickListener(v ->
                showUnavailable("Feedback"));

        // COMPLAINTS
        complaintsText.setOnClickListener(v ->
                showUnavailable("Complaints"));

        // UPDATE AND MANAGE
        manageTitle.setOnClickListener(v ->
                showUnavailable("Update and Manage"));

        // COMPLAINT STATUS
        statusTitle.setOnClickListener(v ->
                showUnavailable("Complaint Status"));
    }

    // UNAVAILABLE FEATURE MESSAGE
    private void showUnavailable(String feature) {

        Toast.makeText(
                AdministratorDashboard.this,
                feature + " feature is not available in this demo yet.",
                Toast.LENGTH_SHORT
        ).show();
    }
}
