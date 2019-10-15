package com.example.notesapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.notesapp.data.Note;
import com.example.notesapp.repository.NotesRepository;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {
    private int PAGE_SIZE = 15;
    private NotesRepository mNotesRepository;
    private LiveData<List<Note>> mAllNotes;

    public NotesViewModel(@NonNull Application application) {
        super(application);
        mNotesRepository = new NotesRepository(application);
        mAllNotes = mNotesRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes(){
        return mAllNotes;
    }

    public void addNote(Note note){
        mNotesRepository.addNote(note);
    }

    public void updateNote(Note note){
        mNotesRepository.updateNotes(note);
    }

    public void deleteNote(Note note){
        mNotesRepository.deleteNote(note);
    }

    public void deleteAllNotes(){
        mNotesRepository.deleteAll();
    }

    public LiveData<PagedList<Note>> getAllPagedNotes(){
        LiveData<PagedList<Note>> mPagedList =
                new LivePagedListBuilder<>(
                        mNotesRepository.getAllPagedNotes(),
                        PAGE_SIZE
                ).build();
        return mPagedList;
    }
}
