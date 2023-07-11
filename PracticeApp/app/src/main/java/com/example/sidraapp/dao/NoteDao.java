package com.example.sidraapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sidraapp.models.Notes;
import com.google.android.material.circularreveal.CircularRevealHelper;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNote(Notes notes);

    @Update
    void updateNote(Notes notes);

    @Delete
    void deleteNote(Notes notes);

    @Query("SELECT * FROM notes")
    List<Notes> getAllNotes();
}
