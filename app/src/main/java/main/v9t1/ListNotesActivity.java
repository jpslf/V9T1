package main.v9t1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

class Adapter extends RecyclerView.Adapter<NoteViewHolder> {
    NoteStorage storage;

    Adapter(NoteStorage storage_) {
        storage = storage_;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_view_holder, parent, false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = storage.getNotes().get(position);

        holder.NoteContentText.setText(note.content);
        holder.NoteIdText.setText(Integer.toString(note.id));
        holder.NoteTitleText.setText(note.title);
        holder.NoteTimeAndDateText.setText(note.timeAndDate);
    }

    @Override
    public int getItemCount() {
        return storage.getNotes().size();
    }
}

public class ListNotesActivity extends AppCompatActivity {
    RecyclerView notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_notes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        notes = findViewById(R.id.ListNotesRV);

        notes.setLayoutManager((new LinearLayoutManager(this)));

        notes.setAdapter(new Adapter(NoteStorage.getInstance()));
    }

    public void Back(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}