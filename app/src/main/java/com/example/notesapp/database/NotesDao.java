package com.example.notesapp.database;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notesapp.data.Note;

import java.util.List;

@Dao
public interface NotesDao {

    @Insert
    void addNote(Note note);

    //Live Data
    @Query("SELECT * FROM notes ORDER BY mNoteId ASC")
    LiveData<List<Note>> getAllNotes();

    //Paging Library
    @Query("SELECT * FROM notes ORDER BY mNoteId ASC")
    DataSource.Factory<Integer,Note> getAllPagedNotes();

    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM notes")
    void deleteAll();

    @Update
    void updateNote(Note note);
}
