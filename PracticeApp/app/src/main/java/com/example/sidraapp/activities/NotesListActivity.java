package com.example.sidraapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidraapp.MyDb;
import com.example.sidraapp.R;
import com.example.sidraapp.adapters.NotesAdapter;
import com.example.sidraapp.models.Notes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NotesListActivity extends AppCompatActivity implements NotesAdapter.NotesInterface {

    private FloatingActionButton floatAdd;
    private RecyclerView notesRv;
    private MyDb db;
    private NotesAdapter notesAdapter;
    private List<Notes> notesList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_noteslist);

        db = MyDb.getInstance(this);
        notesRv = findViewById(R.id.notesRv);
        notesRv.setLayoutManager(new LinearLayoutManager(this));
        floatAdd = findViewById(R.id.floatAddNote);
        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesListActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });


        getAllNotes();
    }

    private void getAllNotes(){
        notesList = db.noteDao().getAllNotes();
        if(notesList!=null){
            notesAdapter = new NotesAdapter(notesList, this,this);
            notesRv.setAdapter(notesAdapter);
        }
        notesAdapter.notifyDataSetChanged();

    }

    @Override
    public void editNote(Notes notes) {
        int id = notes.getId();
        String title = notes.getNoteTitle();
        String desc = notes.getNoteDesc();

        Intent intent = new Intent(NotesListActivity.this,EditNoteActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("title", title);
        intent.putExtra("desc", desc);
        startActivity(intent);
    }

    @Override
    public void deleteNote(Notes notes) {
        db.noteDao().deleteNote(notes);
        notesList.remove(notes);
        notesAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Note deleted!", Toast.LENGTH_SHORT).show();
    }
}
