package com.example.databasefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.databasefinal.Database.UserEntryClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRegister extends AppCompatActivity {
    TextInputEditText edittextEmail , edittextPassword, edittextUsername, edittextFullName, editTextMobileNo;
    DatePicker date;
    Button buttonreg;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView textView;

    FirebaseUser user;

    String userUid;

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
        setContentView(R.layout.activity_user_register);
        mAuth= FirebaseAuth.getInstance();
        edittextEmail = findViewById(R.id.email);
        edittextPassword = findViewById(R.id.password);
        edittextUsername = findViewById(R.id.username);
        edittextFullName = findViewById(R.id.fullname);
        editTextMobileNo = findViewById(R.id.mobileno);
        date = findViewById(R.id.birthdate);
        buttonreg =  findViewById(R.id.btn_register);
        progressBar= findViewById(R.id.progressBar);
        textView= findViewById(R.id.loginNow);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), UserLogin.class);
                startActivity(intent);
                finish();
            }
        });
        buttonreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email= String.valueOf(edittextEmail.getText());
                password= String.valueOf(edittextPassword.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(UserRegister.this, "", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(UserRegister.this, "", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    userUid= mAuth.getUid();
                                    storeRealtimeData();
                                    Toast.makeText(UserRegister.this, "Account Created!",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(UserRegister.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });
    }

    private void storeRealtimeData() {
        DatabaseReference mDatabase;
        mDatabase= FirebaseDatabase.getInstance().getReference();

        String fulldate;
        int daydate,monthdate,yeardate;
        daydate=date.getDayOfMonth();
        monthdate=date.getMonth();
        yeardate=date.getYear();
        fulldate= Integer.toString(daydate)+"/"+Integer.toString(monthdate)+"/"+Integer.toString(yeardate);

        String emailEntry,passwordEntry,userNameEntry,fullNameEntry,mobileNoEntry, uidEntry, userBDate;
        emailEntry = edittextEmail.getText().toString();
        passwordEntry = edittextPassword.getText().toString();
        userNameEntry = edittextUsername.getText().toString();
        fullNameEntry = edittextFullName.getText().toString();
        mobileNoEntry = editTextMobileNo.getText().toString();
        userBDate = fulldate;
        uidEntry = userUid;
        UserEntryClass addNewUser= new UserEntryClass(userNameEntry,emailEntry,fullNameEntry,passwordEntry,mobileNoEntry,uidEntry,userBDate);
        mDatabase.child("Users").child(userUid).setValue(addNewUser);
    }
}