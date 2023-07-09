package com.example.sidraapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidraapp.R;
import com.example.sidraapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder>{

    private List<User> arrayList;
    private Context context;
    private UsersInterface listener;

    public UsersAdapter(List<User> arrayList, Context context, UsersInterface listener){
        this.arrayList = arrayList;
        this.context = context;
        this.listener = listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View myView = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
       MyViewHolder obj = new MyViewHolder(myView);
        return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = arrayList.get(position);
        holder.username.setText(user.getUsername());
        holder.email.setText(user.getEmail());
        holder.deletUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.deleteUser(user);
                notifyDataSetChanged();
            }
        });
        holder.editUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView username ;
        TextView email;
        TextView editUser;
        TextView deletUser;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            editUser = itemView.findViewById(R.id.edit);
            deletUser = itemView.findViewById(R.id.delete);
        }
    }

    public interface UsersInterface{
        void deleteUser(User user);
        void editUser(User user);
    }
}
