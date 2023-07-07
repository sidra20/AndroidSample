package com.example.sidraapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sidraapp.R;
import com.example.sidraapp.models.Food;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder>  {
    private Context context;
    private ArrayList<Food> arrayList;

    public FoodAdapter(Context context, ArrayList<Food> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View myView = LayoutInflater.from(context).inflate(R.layout.layout_food_item, parent, false);
       MyViewHolder obj = new MyViewHolder(myView);
        return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Food item = arrayList.get(position);
        holder.foodName.setText(item.getFoodName());
        holder.weight.setText(item.getWeight());
        holder.price.setText(item.getPrice());
        Glide
                .with(context)
                .load(item.getImage())
                .centerCrop()
                .placeholder(R.drawable.food)
                .into(holder.image);


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(item);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView foodName;
        TextView weight;
        TextView price;
        TextView delete;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
            weight = itemView.findViewById(R.id.weight);
            price = itemView.findViewById(R.id.price);
            delete = itemView.findViewById(R.id.deleteFood);
            image = itemView.findViewById(R.id.foodImage);
        }
    }
}
