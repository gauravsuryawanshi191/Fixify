package com.example.databasefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {

    FirebaseAuth auth;
    Button logoutBtn, homebutton;
    TextView textView, databasedata;
    FirebaseUser user;
    String mobileNo,password;;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        auth= FirebaseAuth.getInstance();
        logoutBtn= findViewById(R.id.logout);
        homebutton= findViewById(R.id.backtohome);
        textView= findViewById(R.id.userDetails);
        databasedata= findViewById(R.id.databasedata);
        user= auth.getCurrentUser();
        if(user== null){
            Intent intent= new Intent(getApplicationContext(), FirstPage.class);
            startActivity(intent);
            finish();
        }

        else{
            textView.setText(user.getUid());
        }

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent= new Intent(getApplicationContext(), FirstPage.class);
                startActivity(intent);
                finish();
            }
        });

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), UserHome.class);
                startActivity(intent);
                finish();
            }
        });
    }

}