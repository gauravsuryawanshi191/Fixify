package com.example.databasefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.databasefinal.Database.SPEntryClass;
import com.example.databasefinal.Database.UserEntryClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SPRegister extends AppCompatActivity {
    TextInputEditText edittextEmail , edittextPassword, edittextUserName, edittextFullName, editTextService;
    Button buttonreg;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView textView;

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
        setContentView(R.layout.activity_sp_register);
        mAuth= FirebaseAuth.getInstance();
        edittextEmail = findViewById(R.id.email);
        edittextPassword = findViewById(R.id.password);
        edittextUserName = findViewById(R.id.username);
        edittextFullName = findViewById(R.id.fullname);
        editTextService = findViewById(R.id.service);
        buttonreg =  findViewById(R.id.btn_register);
        progressBar= findViewById(R.id.progressBar);
        textView= findViewById(R.id.loginNow);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), SPLogin.class);
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
                    Toast.makeText(SPRegister.this, "", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(SPRegister.this, "", Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(SPRegister.this, "Account Created!",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(SPRegister.this, "Authentication failed.",
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

        String emailEntry,passwordEntry,userNameEntry,fullNameEntry,serviceEntry,uidEntry;
        emailEntry=edittextEmail.getText().toString();
        passwordEntry=edittextPassword.getText().toString();
        userNameEntry=edittextUserName.getText().toString();
        fullNameEntry=edittextFullName.getText().toString();
        serviceEntry=editTextService.getText().toString();
        uidEntry= userUid;
        SPEntryClass addNewSP= new SPEntryClass(userNameEntry,emailEntry,fullNameEntry,serviceEntry,passwordEntry);
        mDatabase.child("SPs").child(uidEntry).setValue(addNewSP);
    }
}