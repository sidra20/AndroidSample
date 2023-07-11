package com.example.sidraapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.sidraapp.dao.NoteDao;
import com.example.sidraapp.models.Notes;

@Database(entities = {Notes.class}, version = 1, exportSchema = false)
public abstract class MyDb extends RoomDatabase {
    private static MyDb instance;

    public abstract NoteDao noteDao();

    public static synchronized MyDb getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context,
                    MyDb.class, "myappdatabase").
                    allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
