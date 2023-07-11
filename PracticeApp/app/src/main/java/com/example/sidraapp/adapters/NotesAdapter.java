package com.example.sidraapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidraapp.R;
import com.example.sidraapp.models.Notes;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private List<Notes> notesList;
    private Context context;
    private NotesInterface listener;

    public NotesAdapter(List<Notes> notesList, Context context, NotesInterface listener){
        this.context = context;
        this.notesList=notesList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(context).inflate(R.layout.item_note,parent,false);
        MyViewHolder obj = new MyViewHolder(myView);
        return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Notes notes = notesList.get(position);
        holder.title.setText(notes.getNoteTitle());
        holder.desc.setText(notes.getNoteDesc());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.editNote(notes);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.deleteNote(notes);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView desc;
        TextView edit;
        TextView delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.noteTitle);
            desc = itemView.findViewById(R.id.noteDesc);
            edit = itemView.findViewById(R.id.editNote);
            delete = itemView.findViewById(R.id.deleteNote);
        }
    }

    public interface NotesInterface{
        void editNote(Notes notes);
        void deleteNote(Notes notes);
    }
}
