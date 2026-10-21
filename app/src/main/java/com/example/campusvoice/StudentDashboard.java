package com.example.campusvoice;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

public class StudentDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            return insets;
        });

        ImageButton profileBtn = findViewById(R.id.imageButton);
        ImageButton notificationBtn = findViewById(R.id.imageButton2);
        ImageButton complaintBtn = findViewById(R.id.imageButton3);
        ImageButton feedbackBtn = findViewById(R.id.imageButton4);

        if (profileBtn != null) {
            profileBtn.setOnClickListener(v -> Toast.makeText(StudentDashboard.this, "Profile clicked", Toast.LENGTH_SHORT).show());
        }
        if (notificationBtn != null) {
            notificationBtn.setOnClickListener(v -> Toast.makeText(StudentDashboard.this, "Notification clicked", Toast.LENGTH_SHORT).show());
        }
        if (complaintBtn != null) {
            complaintBtn.setOnClickListener(v -> Toast.makeText(StudentDashboard.this, "Complaint clicked", Toast.LENGTH_SHORT).show());
        }
        if (feedbackBtn != null) {
            feedbackBtn.setOnClickListener(v -> Toast.makeText(StudentDashboard.this, "Feedback clicked", Toast.LENGTH_SHORT).show());
        }
    }
}
