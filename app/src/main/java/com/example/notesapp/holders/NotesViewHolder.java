package com.example.notesapp.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.R;
import com.example.notesapp.data.Note;

public class NotesViewHolder extends RecyclerView.ViewHolder {

    private final TextView titleView, contentView;

   public NotesViewHolder(@NonNull View itemView){
       super(itemView);
       titleView = itemView.findViewById(R.id.titleTv);
       contentView = itemView.findViewById(R.id.contentTv);
   }

   public void bind(Note note){
        titleView.setText(note.getLabel());
        contentView.setText(note.getContent());
   }
}
