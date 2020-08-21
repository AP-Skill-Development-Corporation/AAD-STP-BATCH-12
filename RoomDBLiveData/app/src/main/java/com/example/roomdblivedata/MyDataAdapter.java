package com.example.roomdblivedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MyViewHolder> {

    Context ct;
    List<User> list;

    public MyDataAdapter(MainActivity mainActivity, List<User> userList) {
        ct = mainActivity;
        list = userList;
    }

    @NonNull
    @Override
    public MyDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.rowdesign,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDataAdapter.MyViewHolder holder, int position) {

        final User user = list.get(position);

        holder.tv1.setText(user.getName());
        holder.tv2.setText(user.getMailid());
        holder.tv3.setText(user.getNumber());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.database.myDao().delete(user);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1,tv2,tv3;
        ImageView delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.readname);
            tv2 = itemView.findViewById(R.id.readmail);
            tv3 = itemView.findViewById(R.id.readphone);
            delete = itemView.findViewById(R.id.delete);

        }
    }
}
