package com.example.footballzone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
// RegisterActivity.java

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView usernameTitle;
    private TextView emailTitle;
    private TextView passwordTitle;
    private Button continueButton;
    private ImageView lockIcon;
    private ImageView peopleIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameTitle = findViewById(R.id.userTitle);
        emailTitle = findViewById(R.id.mailTitle);
        passwordTitle = findViewById(R.id.passTitle);
        continueButton = findViewById(R.id.button);
        lockIcon = findViewById(R.id.imageView5);
        peopleIcon = findViewById(R.id.imageView6);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (validateEmail(email) && validatePassword(password)) {
                    Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration error. Check your details.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateEmail(String email) {
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Incorrect email address.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validatePassword(String password) {
        if (password.length() < 8) {
            Toast.makeText(this, "Password must be at least 8 characters long.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            Toast.makeText(this, "The password must contain at least one capital letter.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            Toast.makeText(this, "The password must contain at least one lowercase letter.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            Toast.makeText(this, "The password must contain at least one number.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.matches(".*[@#$%!^&*].*")) {
            Toast.makeText(this, "The password must contain at least one special character (@, #, $, %, !, ^, & or *).", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
