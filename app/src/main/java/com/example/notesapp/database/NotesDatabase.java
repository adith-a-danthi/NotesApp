package com.example.notesapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notesapp.data.Note;

@Database(entities = {Note.class},version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NotesDao notesDao();

    public static NotesDatabase INSTANCE;

    public static NotesDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (NotesDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            NotesDatabase.class,
                            "notes_database"
                    )       .fallbackToDestructiveMigration()
                            /*.addCallback(sRoomDatabaseCallback)*/
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /*

    If notes need to be added by default on creation of database

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase SQLdb){
            super.onCreate(SQLdb);
            new populateDbAsync(INSTANCE).execute();
        }
    };

    private static class populateDbAsync extends AsyncTask<Void,Void,Void>{
        private final NotesDao mDao;

        populateDbAsync(NotesDatabase db){
            mDao = db.notesDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

    */
}
