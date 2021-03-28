package com.example.editingprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView nameSurname,birthDate,gender,email,aboutMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameSurname = findViewById(R.id.textViewNameSurname);
        birthDate = findViewById(R.id.textViewBirthdate);
        gender = findViewById(R.id.textViewGenderr);
        email = findViewById(R.id.textViewMail);
        aboutMe = findViewById(R.id.textViewAboutMee);


        Intent getIntent = getIntent();

        String getName = getIntent.getStringExtra("name");
        String getSurname = getIntent.getStringExtra("surname");
        String getBirthDate = getIntent.getStringExtra("birthDate");
        String getGender = getIntent.getStringExtra("gender");
        String getEmail = getIntent.getStringExtra("email");
        String getAboutMe = getIntent.getStringExtra("aboutMe");


        nameSurname.setText(getName+ " " + getSurname);
        birthDate.setText(getBirthDate);
        gender.setText(getGender);
        email.setText(getEmail);
        aboutMe.setText(getAboutMe);
    }
}