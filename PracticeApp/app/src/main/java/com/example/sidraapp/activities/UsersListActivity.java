package com.example.sidraapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidraapp.AppDatabase;
import com.example.sidraapp.R;
import com.example.sidraapp.adapters.UsersAdapter;
import com.example.sidraapp.models.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class UsersListActivity extends AppCompatActivity implements UsersAdapter.UsersInterface {
    private FloatingActionButton floatingActionButton;
    private RecyclerView userRv;
    private AppDatabase db;
    private UsersAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_userslist);

        floatingActionButton = findViewById(R.id.floatAddUser);
        userRv = findViewById(R.id.usersListRv);
        userRv.setLayoutManager(new LinearLayoutManager(this));


        db = AppDatabase.getInstance(this);

        getAllUsers();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UsersListActivity.this,AddUserActivity.class);
                startActivity(intent);
            }
        });



    }
    private List<User> getAllUsers(){
        List<User> users = db.userDao().getAllUsers();


        adapter = new UsersAdapter(users, this, this);
        userRv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return users;

    }

    @Override
    public void deleteUser(User user) {
        db.userDao().deleteUser(user);
        Toast.makeText(this, "User Deleted!", Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void editUser(User user) {

    }
}
