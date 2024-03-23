package com.example.mad_workshop1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView userNameTextView, ageTextView, emailTextView, contactNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        userNameTextView = findViewById(R.id.textViewUserName);
        ageTextView = findViewById(R.id.textViewAge);
        emailTextView = findViewById(R.id.textViewEmail);
        contactNumberTextView = findViewById(R.id.textViewContactNumber);

        Intent intent = getIntent();
        if (intent != null) {
            String userName = intent.getStringExtra("USER_NAME");
            String age = intent.getStringExtra("AGE");
            String email = intent.getStringExtra("EMAIL");
            String contactNumber = intent.getStringExtra("CONTACT_NUMBER");

            userNameTextView.setText("User Name: " + userName);
            ageTextView.setText("Age: " + age);
            emailTextView.setText("Email: " + email);
            contactNumberTextView.setText("Contact Number: " + contactNumber);
        }
    }
}