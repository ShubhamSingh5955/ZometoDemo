package com.example.zometodemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zometodemo.model.Restaurant;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Restaurant> restaurants;
    private Context context;

    public MyAdapter(List<Restaurant> restaurants, Context context) {
        this.restaurants = restaurants;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant restaurant=restaurants.get(position);
        holder.textView_head.setText(restaurant.getName());
        holder.textView_desc.setText(restaurant.getId());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView_head;
        public TextView textView_desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_head= (TextView)itemView.findViewById(R.id.textView_header);
            textView_desc= (TextView)itemView.findViewById(R.id.textView_discription);
        }
    }

}
