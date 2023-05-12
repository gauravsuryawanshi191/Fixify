package com.example.databasefinal;



        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Collections;
        import java.util.Comparator;

public class SPList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<SPItem> list;

    boolean isSortByPrice = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_list);
        recyclerView = findViewById(R.id.userList);
        database = FirebaseDatabase.getInstance().getReference("SPs");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    SPItem user = dataSnapshot.getValue(SPItem.class);
                    list.add(user);


                }
                myAdapter.notifyDataSetChanged();
                //changed


                Button cleaningButton = findViewById(R.id.Cleaning);
                cleaningButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<SPItem> cleaningList = new ArrayList<>();
                        for (SPItem user : list) {
                            if (user.getService().equals("cleaning")) {
                                cleaningList.add(user);
                            }
                        }
                        myAdapter = new MyAdapter(getApplicationContext(), cleaningList);
                        recyclerView.setAdapter(myAdapter);

                        Button pa = findViewById(R.id.price);
                        pa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Collections.sort(cleaningList, new Comparator<SPItem>() {
                                    @Override
                                    public int compare(SPItem user, SPItem t1) {
                                        return user.Price.compareToIgnoreCase(t1.Price);
                                    }
                                });
                                myAdapter.notifyDataSetChanged();
                            }
                        });

                        Button ra = findViewById(R.id.rating);
                        ra.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Collections.sort(cleaningList, new Comparator<SPItem>() {
                                    @Override
                                    public int compare(SPItem user, SPItem t1) {
                                        return user.Rating.compareToIgnoreCase(t1.Rating);
                                    }
                                });
                                Collections.reverse(cleaningList);
                                myAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });



                //   myAdapter.notifyDataSetChanged();

                Button plumbingButton = findViewById(R.id.Plumbing);
                plumbingButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<SPItem> cleaningList = new ArrayList<>();
                        for (SPItem user : list) {
                            if (user.getService().equals("Plumbing")) {
                                cleaningList.add(user);
                            }
                        }
                        myAdapter = new MyAdapter(getApplicationContext(), cleaningList);
                        recyclerView.setAdapter(myAdapter);

                        Button pa = findViewById(R.id.price);
                        pa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Collections.sort(cleaningList, new Comparator<SPItem>() {
                                    @Override
                                    public int compare(SPItem user, SPItem t1) {
                                        return user.Price.compareToIgnoreCase(t1.Price);
                                    }
                                });
                                myAdapter.notifyDataSetChanged();
                            }
                        });

                        Button ra = findViewById(R.id.rating);
                        ra.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Collections.sort(cleaningList, new Comparator<SPItem>() {
                                    @Override
                                    public int compare(SPItem user, SPItem t1) {
                                        return user.Rating.compareToIgnoreCase(t1.Rating);
                                    }
                                });
                                Collections.reverse(cleaningList);
                                myAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });


                Button ElectricianButton = findViewById(R.id.Electrician);
                ElectricianButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<SPItem> cleaningList = new ArrayList<>();
                        for (SPItem user : list) {
                            if (user.getService().equals("Electrician")) {
                                cleaningList.add(user);
                            }
                        }
                        myAdapter = new MyAdapter(getApplicationContext(), cleaningList);
                        recyclerView.setAdapter(myAdapter);

                        Button pa = findViewById(R.id.price);
                        pa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Collections.sort(cleaningList, new Comparator<SPItem>() {
                                    @Override
                                    public int compare(SPItem user, SPItem t1) {
                                        return user.Price.compareToIgnoreCase(t1.Price);
                                    }
                                });
                                myAdapter.notifyDataSetChanged();
                            }
                        });

                        Button ra = findViewById(R.id.rating);
                        ra.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Collections.sort(cleaningList, new Comparator<SPItem>() {
                                    @Override
                                    public int compare(SPItem user, SPItem t1) {
                                        return user.Rating.compareToIgnoreCase(t1.Rating);
                                    }
                                });
                                Collections.reverse(cleaningList);
                                myAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });


                Button GardningButton = findViewById(R.id.Gardning);
                GardningButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<SPItem> cleaningList = new ArrayList<>();
                        for (SPItem user : list) {
                            if (user.getService().equals("Gardning")) {
                                cleaningList.add(user);
                            }
                        }
                        myAdapter = new MyAdapter(getApplicationContext(), cleaningList);
                        recyclerView.setAdapter(myAdapter);

                        Button pa = findViewById(R.id.price);
                        pa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Collections.sort(cleaningList, new Comparator<SPItem>() {
                                    @Override
                                    public int compare(SPItem user, SPItem t1) {
                                        return user.Price.compareToIgnoreCase(t1.Price);
                                    }
                                });
                                myAdapter.notifyDataSetChanged();
                            }
                        });

                        Button ra = findViewById(R.id.rating);
                        ra.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Collections.sort(cleaningList, new Comparator<SPItem>() {
                                    @Override
                                    public int compare(SPItem user, SPItem t1) {
                                        return user.Rating.compareToIgnoreCase(t1.Rating);
                                    }
                                });
                                Collections.reverse(cleaningList);
                                myAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });

                Button pa = findViewById(R.id.price);
                pa.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Collections.sort(list, new Comparator<SPItem>() {
                            @Override
                            public int compare(SPItem user, SPItem t1) {

                                return user.Price.compareToIgnoreCase(t1.Price);
                            }

                        });


                        myAdapter.notifyDataSetChanged();

                    }
                });



                Button ra = findViewById(R.id.rating);
                ra.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Collections.sort(list, new Comparator<SPItem>() {
                            @Override
                            public int compare(SPItem user, SPItem t1) {

                                return user.Rating.compareToIgnoreCase(t1.Rating);
                            }

                        });
                        Collections.reverse(list);

                        myAdapter.notifyDataSetChanged();

                    }
                });


                //changed end
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }
}