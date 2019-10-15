package com.example.notesapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.example.notesapp.R;
import com.example.notesapp.data.Note;
import com.example.notesapp.holders.NotesViewHolder;


public class NotesAdapter extends PagedListAdapter<Note,NotesViewHolder> {

    public NotesAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflator = LayoutInflater.from(parent.getContext());
        View mItemVew = mLayoutInflator.inflate(R.layout.recycler_view_item,parent,false);
        return new NotesViewHolder(mItemVew);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        final Note currentNote = getItem(position);
        if(currentNote != null){
            holder.bind(currentNote);
        }
    }

    private static DiffUtil.ItemCallback<Note> DIFF_CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getNoteId() == newItem.getNoteId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.equals(newItem);
        }
    };
}
