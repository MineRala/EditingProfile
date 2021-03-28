package com.example.editingprofile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class SignUp extends AppCompatActivity {

  public static final int CAMERA_ACTION_CODE = 1;
    Intent intent;
    Button btnPıckImage;
    ImageView imageView;
    Button btnSend;
    EditText name,surname,birthDate,email,aboutMe;
    RadioButton male,female;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnPıckImage = findViewById(R.id.btnPıckImage);
        imageView = findViewById(R.id.imageView);

        btnPıckImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_ACTION_CODE);
            }
        });




        name = findViewById(R.id.editTextTextPersonName);
        surname = findViewById(R.id.editTextTextPersonSurname);
        birthDate = findViewById(R.id.editTextTextPersonBirthDate);
        email = findViewById(R.id.editTextTextPersonEmail);
        aboutMe = findViewById(R.id.editTextTextPersonAboutMe);

        male = findViewById(R.id.radioButtonMale);
        female = findViewById(R.id.radioButtonFemale);

        btnSend = findViewById(R.id.buttonSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 = name.getText().toString();
                String surname1 = surname.getText().toString();
                String birthDate1 = birthDate.getText().toString();
                String email1 =  email.getText().toString();
                String aboutMe1 = aboutMe.getText().toString();

                String gender = "";
                if (male.isChecked()){
                    gender = male.getText().toString();
                }
                if (female.isChecked()){
                    gender = female.getText().toString();
                }
                intent = new Intent(SignUp.this,Profile.class);
                intent.putExtra("name",name1);
                intent.putExtra("surname",surname1);
                intent.putExtra("birthDate",birthDate1);
                intent.putExtra("gender",gender);
                intent.putExtra("email",email1);
                intent.putExtra("aboutMe",aboutMe1);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_ACTION_CODE && resultCode == RESULT_OK && data != null){
            Bundle b = data.getExtras();
            Bitmap bm = (Bitmap) b.get("data");
            imageView.setImageBitmap(bm);
            BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
            bm = drawable.getBitmap();


        }
    }
}


