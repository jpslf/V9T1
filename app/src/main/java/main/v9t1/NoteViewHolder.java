package main.v9t1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    public TextView NoteIdText, NoteContentText, NoteTitleText, NoteTimeAndDateText;

    public NoteViewHolder(View itemView) {
        super(itemView);

        NoteIdText = itemView.findViewById(R.id.NoteIdText);
        NoteContentText = itemView.findViewById(R.id.NoteContentText);
        NoteTitleText = itemView.findViewById(R.id.NoteTitleText);
        NoteTimeAndDateText = itemView.findViewById(R.id.NoteTimeAndDateText);
    }
}