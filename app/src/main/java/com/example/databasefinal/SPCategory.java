package com.example.databasefinal;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.Query;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.List;

public class SPCategory extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database2;
    MyAdapter myAdapter;
    ArrayList<SPItem> list;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sp_category);
        button1 = findViewById(R.id.category1btn);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ArrayList<SPItem> cleaningList = new ArrayList<>();
//                for (SPItem user : list) {
//                    if (user.getService().equals("cleaning")) {
//                        cleaningList.add(user);
//                    }
//                }
//
//                myAdapter = new MyAdapter(getApplicationContext(), cleaningList);
//                recyclerView.setAdapter(myAdapter);
//            }
//        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SPCategory.this, SPList.class);
                startActivity(intent);


            }


        });


        button2 = findViewById(R.id.category2btn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SPCategory.this, SPList.class);
                startActivity(intent);


            }


        });
        button4 = findViewById(R.id.category3btn);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SPCategory.this, SPList.class);
                startActivity(intent);


            }


        });
        button3 = findViewById(R.id.category4btn);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SPCategory.this, SPList.class);
                startActivity(intent);


            }


        });

    }
}
