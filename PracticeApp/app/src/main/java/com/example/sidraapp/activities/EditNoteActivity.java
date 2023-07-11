package com.example.sidraapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sidraapp.MyDb;
import com.example.sidraapp.R;
import com.example.sidraapp.models.Notes;

public class EditNoteActivity extends AppCompatActivity {

    private EditText noteTitle;
    private EditText noteDesc;
    private Button updateNoteBtn;
    private int id;
    private MyDb db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit_note);
        db = MyDb.getInstance(this);

        noteTitle = findViewById(R.id.updateNoteTitleEdittext);
        noteDesc =findViewById(R.id.updateNoteDescEdittext);
        updateNoteBtn = findViewById(R.id.updateNoteBtn);

        id = getIntent().getIntExtra("id",0);
        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");

        noteTitle.setText(title);
        noteDesc.setText(desc);

        updateNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNote();
            }
        });
    }

    private void updateNote() {
        String title = noteTitle.getText().toString();
        String desc = noteDesc.getText().toString();
        if(title.isEmpty()){
            Toast.makeText(this, "Title can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(desc.isEmpty()){
            Toast.makeText(this, "Note Description can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        Notes notes = new Notes(id,title, desc);
        db.noteDao().updateNote(notes);
        Toast.makeText(this, "Note updated!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EditNoteActivity.this,NotesListActivity.class);
        startActivity(intent);
    }
}
