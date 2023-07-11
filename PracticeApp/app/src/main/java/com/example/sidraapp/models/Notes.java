package com.example.sidraapp.models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Notes {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String noteTitle;
    @ColumnInfo
    private String noteDesc;


    public Notes(String noteTitle, String noteDesc){
        this.noteTitle = noteTitle;
        this.noteDesc = noteDesc;
    }

    @Ignore
    public Notes(int id,String noteTitle, String noteDesc){
        this.id = id;
        this.noteTitle = noteTitle;
        this.noteDesc = noteDesc;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setNoteTitle(String noteTitle){
        this.noteTitle = noteTitle;
    }
    public String getNoteTitle(){
        return noteTitle;
    }
    public void setNoteDesc(String noteDesc){
        this.noteDesc = noteDesc;
    }
    public String getNoteDesc(){
        return noteDesc;
    }
}
