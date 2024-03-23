package com.example.mad_workshop1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText userNameEditText, ageEditText, emailEditText, contactNumberEditText;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.editTextUserName);
        ageEditText = findViewById(R.id.editTextAge);
        emailEditText = findViewById(R.id.editTextEmail);
        contactNumberEditText = findViewById(R.id.editTextContactNumber);
        submitButton = findViewById(R.id.buttonSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameEditText.getText().toString();
                String age = ageEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String contactNumber = contactNumberEditText.getText().toString();

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("USER_NAME", userName);
                intent.putExtra("AGE", age);
                intent.putExtra("EMAIL", email);
                intent.putExtra("CONTACT_NUMBER", contactNumber);
                startActivity(intent);
            }
        });
    }
}