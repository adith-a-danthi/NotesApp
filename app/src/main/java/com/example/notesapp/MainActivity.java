package com.example.notesapp;

import android.os.Bundle;

import com.example.notesapp.adapters.NotesAdapter;
import com.example.notesapp.data.Note;
import com.example.notesapp.viewmodel.NotesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Adapter;

public class MainActivity extends AppCompatActivity {

    private NotesViewModel mNotesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mNotesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);
        final NotesAdapter mAdapter = new NotesAdapter();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mNotesViewModel.getAllPagedNotes().observe(this, new Observer<PagedList<Note>>() {
            @Override
            public void onChanged(PagedList<Note> notes) {
                mAdapter.submitList(notes);
            }
        });

    }

}
