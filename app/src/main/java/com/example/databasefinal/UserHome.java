package com.example.databasefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserHome extends AppCompatActivity {

    Button buttonprofile, buttonAboutus, buttonServiceBooking;
    String mobileNo, nameFromDb;;
    TextView textView1,textView2;

    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        buttonprofile =  findViewById(R.id.btn_profile);
        buttonAboutus = findViewById(R.id.btn_aboutUs);
        buttonServiceBooking = findViewById(R.id.btn_orderbooking);
        //mobileNo = getIntent().getStringExtra("mobileNo");
        nameFromDb = getIntent().getStringExtra("fullname");
        textView1 = findViewById(R.id.userdata);
        textView2 = findViewById(R.id.mobileedit);
        auth= FirebaseAuth.getInstance();
        user= auth.getCurrentUser();

        buttonprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                //intent.putExtra("mobileNo",mobileNo);
                startActivity(intent);
                finish();
            }
        });

        buttonAboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BookingPage.class);
                startActivity(intent);
                finish();
            }
        });

        buttonServiceBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SPCategory.class);
                startActivity(intent);
                finish();
            }
        });

        textView1.setText(user.getUid());
        textView2.setText(nameFromDb);
    }

}