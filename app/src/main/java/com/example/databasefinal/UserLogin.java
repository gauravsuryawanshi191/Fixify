package com.example.databasefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class UserLogin extends AppCompatActivity {

    TextInputEditText edittextemail , edittextpassword, editTextmobileNo;
    Button buttonLogin;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView textView;
    String nameFromDb;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent= new Intent(getApplicationContext(), UserHome.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        mAuth= FirebaseAuth.getInstance();
        edittextemail = findViewById(R.id.email);
        edittextpassword = findViewById(R.id.password);
        editTextmobileNo = findViewById(R.id.mobileNo);
        buttonLogin =  findViewById(R.id.btn_login);
        progressBar= findViewById(R.id.progressBar);
        textView= findViewById(R.id.registerNow);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), UserRegister.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email= String.valueOf(edittextemail.getText());
                password= String.valueOf(edittextpassword.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(UserLogin.this, "enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(UserLogin.this, "", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    //Toast.makeText(UserLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                                    displayDbData();
                                    Intent intent= new Intent(getApplicationContext(), UserHome.class);
                                    intent.putExtra("fullname",nameFromDb);
//                                    String mobileNo;
//                                    mobileNo= String.valueOf(editTextmobileNo.getText());
//                                    intent.putExtra("mobileNo",mobileNo);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    Toast.makeText(UserLogin.this, "Login failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }
    private void displayDbData() {
        Query dbData= FirebaseDatabase.getInstance().getReference("Users").orderByChild("uID").equalTo(mAuth.getUid());

        dbData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                nameFromDb= snapshot.child("Users").child("fullName").getValue(String.class);
                Toast.makeText(UserLogin.this, nameFromDb, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}