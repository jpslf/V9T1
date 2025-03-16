package main.v9t1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;

class Note {
    int Id;
    String title;
    String content;
    String timeAndDate;

    Note(String title_, String content_) {
        title = title_;
        content = content_;

        Calendar c = Calendar.getInstance();

        int hour, min, day, mon, year = 0;

        hour = c.get(Calendar.HOUR_OF_DAY);
        min = c.get(Calendar.MINUTE);
        day = c.get(Calendar.DAY_OF_MONTH);
        mon = c.get(Calendar.MONTH);
        year = c.get(Calendar.YEAR);

        timeAndDate = String.format("%d:%d %d.%d.%d", hour, min, day, mon, year);

        Id = ++NoteStorage.getInstance().id;
    }
}

class NoteStorage {
    ArrayList<Note> notes;

    int id;

    static NoteStorage instance;

    NoteStorage() {
        notes = new ArrayList<Note>();

        id = 0;
    }

    ArrayList<Note> getNotes() {
        return notes;
    }

    void addNote(Note note) {
        notes.add(note);
    }

    static NoteStorage getInstance() {
        if (instance == null) {
            instance = new NoteStorage();
        }

        return instance;
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void AddNote(View view) {
        Intent intent = new Intent(this, AddNoteActivity.class);

        startActivity(intent);
    }

    public void ListNotes(View view) {
        Intent intent = new Intent(this, ListNotesActivity.class);

        startActivity(intent);
    }
}