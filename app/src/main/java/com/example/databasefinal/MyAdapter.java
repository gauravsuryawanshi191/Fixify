package com.example.databasefinal;



        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.firebase.ui.database.FirebaseRecyclerOptions;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<SPItem> list;


    public MyAdapter(Context context, ArrayList<SPItem> list) {
        this.context = context;
        this.list = list;
    }

    public MyAdapter(FirebaseRecyclerOptions<SPItem> options) {

    }

    public MyAdapter(ValueEventListener valueEventListener, List<SPItem> userList) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_sp_list_item,parent,false);

        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        SPItem user = list.get(position);
        holder.fullName.setText(user.getFullName());
        holder.Rating.setText(user.getRating());
        holder.Price.setText(user.getPrice());
        holder.service.setText(user.getService());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void startListening() {

    }
    private List<SPItem> mList;
    public void updateList(List<SPItem> cleaningList) {
        mList = cleaningList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fullName, Rating, Price,service;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fullName = itemView.findViewById(R.id.tvfullName);
            Rating = itemView.findViewById(R.id.tvRating);
            Price = itemView.findViewById(R.id.tvprice);
            service = itemView.findViewById(R.id.tvService);
        }
    }

}
