package com.example.sidraapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sidraapp.MyDb;
import com.example.sidraapp.R;
import com.example.sidraapp.models.Notes;

public class AddNoteActivity extends AppCompatActivity {

    private EditText title;
    private EditText noteDesc;
    private Button addNoteBtn;
    private MyDb db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_note);

        title = findViewById(R.id.noteTitleEdittext);
        noteDesc = findViewById(R.id.noteDescEdittext);
        addNoteBtn = findViewById(R.id.addNoteBtn);

        db = MyDb.getInstance(this);
        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNote();
            }
        });
    }

    private void addNote() {

        String noteTitle = title.getText().toString();
        String noteDescription = noteDesc.getText().toString();

        if(noteTitle.isEmpty()){
            Toast.makeText(this,"Title is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if(noteDescription.isEmpty()){
            Toast.makeText(this,"Description is required", Toast.LENGTH_SHORT).show();
            return;
        }

        Notes notes = new Notes(noteTitle, noteDescription);
        db.noteDao().insertNote(notes);
        Toast.makeText(this,"Note is added!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddNoteActivity.this, NotesListActivity.class);
        startActivity(intent);

    }
}
