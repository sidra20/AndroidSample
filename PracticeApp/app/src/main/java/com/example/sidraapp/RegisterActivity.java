package com.example.sidraapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText password;
    TextView signupbtn;
    FirebaseAuth auth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);

        name = findViewById(R.id.nameRegister);
        email = findViewById(R.id.emailRegsiter);
        password = findViewById(R.id.passRegister);
        signupbtn = findViewById(R.id.signupBtn);

        auth = FirebaseAuth.getInstance();

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // registerUser();

                String userName = name.getText().toString();
                String userEmail = email.getText().toString();
                String userPass = password.getText().toString();

                if(userName.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Name is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(userEmail.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Email is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(userPass.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Password is required", Toast.LENGTH_SHORT).show();
                    return;
                }


                auth.createUserWithEmailAndPassword(userEmail, userPass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(RegisterActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }).addOnFailureListener( new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Unsucessfull!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


}
