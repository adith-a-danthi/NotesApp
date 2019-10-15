package com.example.notesapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.example.notesapp.data.Note;
import com.example.notesapp.database.NotesDao;
import com.example.notesapp.database.NotesDatabase;

import java.util.List;

public class NotesRepository {

    private NotesDao notesDao;
    private LiveData<List<Note>> mAllNotes;

    public NotesRepository(Application application){
        NotesDatabase notesDB = NotesDatabase.getDatabase(application);
        notesDao = notesDB.notesDao();
        mAllNotes = notesDao.getAllNotes();
    }

    public DataSource.Factory<Integer,Note> getAllPagedNotes(){
        return notesDao.getAllPagedNotes();
    }


    public LiveData<List<Note>> getAllNotes(){
        return mAllNotes;
    }

    public void addNote(Note note){
        new addNoteAsyncTask(notesDao).execute(note);
    }

    public void updateNotes(Note note){
        new updateNoteAsyncTask(notesDao).execute(note);
    }

    public void deleteNote(Note note){
        new deleteNoteAsyncTask(notesDao).execute(note);
    }

    public void deleteAll(){
        new deleteAllAsyncTask(notesDao);
    }

    //Async Tasks
    private static class addNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NotesDao mAsyncTaskDao;

        addNoteAsyncTask(NotesDao notesDao){
            mAsyncTaskDao = notesDao;
        }

        @Override
        protected Void doInBackground(Note... note) {
            mAsyncTaskDao.addNote(note[0]);
            return null;
        }
    }

    private static class updateNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NotesDao mAsyncTaskDao;

        updateNoteAsyncTask(NotesDao notesDao){
            mAsyncTaskDao = notesDao;
        }

        @Override
        protected Void doInBackground(Note... note) {
            mAsyncTaskDao.updateNote(note[0]);
            return null;
        }
    }

    private static class deleteNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NotesDao mAsyncTaskDao;

        deleteNoteAsyncTask(NotesDao notesDao){
            mAsyncTaskDao = notesDao;
        }

        @Override
        protected Void doInBackground(Note... note) {
            mAsyncTaskDao.deleteNote(note[0]);
            return null;
        }
    }

    private static class deleteAllAsyncTask extends AsyncTask<Void,Void,Void>{
        private NotesDao mAsyncTaskDao;

        deleteAllAsyncTask(NotesDao notesDao){
            mAsyncTaskDao = notesDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }
}
