package com.example.notesapp.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int mNoteId;

    @ColumnInfo(name = "title")
    private String mNoteLabel;

    @ColumnInfo(name = "content")
    private String mNoteContent;


    public Note (String noteLabel, String noteContent){
        this.mNoteLabel = noteLabel;
        this.mNoteContent = noteContent;
    }

    @Ignore
    public Note (int noteId, String noteLabel, String noteContent){
        this.mNoteLabel = noteLabel;
        this.mNoteId = noteId;
        this.mNoteContent = noteContent;
    }



    public String getLabel(){
        return this.mNoteLabel;
    }

    public String getContent(){
        return this.mNoteContent;
    }

    public int getNoteId(){
        return this.mNoteId;
    }

}
