package com.example.sidraapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sidraapp.AppDatabase;
import com.example.sidraapp.R;
import com.example.sidraapp.models.User;

public class AddUserActivity extends AppCompatActivity {
    private EditText username;
    private EditText email;
    private Button addUser;
    private User user;
    private AppDatabase db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_user);
        username = findViewById(R.id.usernameEdittext);
        email = findViewById(R.id.emailEdittext);
        addUser = findViewById(R.id.addUserBtn);

        db = AppDatabase.getInstance(this);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
    }

    private void addUser() {
        String uname = username.getText().toString();
        String uemail = email.getText().toString();

        if (uname.isEmpty()) {
            Toast.makeText(this, "Username is required!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (uemail.isEmpty()) {
            Toast.makeText(this, "Email is required!", Toast.LENGTH_SHORT).show();
            return;
        }

        user = new User(uname, uemail);
        db.userDao().insertUser(user);
        Toast.makeText(this, "User inserted!", Toast.LENGTH_SHORT).show();
        username.setText("");
        email.setText("");
        Intent intent = new Intent(AddUserActivity.this,UsersListActivity.class);
        startActivity(intent);


    }
}
