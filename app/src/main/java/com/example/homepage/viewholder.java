package com.example.homepage;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewholder extends RecyclerView.ViewHolder {
    TextView coursename;
    TextView coursecode;
    TextView courseinstructor;
    TextView youCanScore;
    ImageButton courseimage;
    public viewholder(@NonNull View itemView) {
        super(itemView);
        coursename = itemView.findViewById(R.id.courseName);
        coursecode = itemView.findViewById(R.id.courseCode);
        courseinstructor = itemView.findViewById(R.id.courseInstructor);
        courseimage = itemView.findViewById(R.id.imageButton);
        youCanScore = itemView.findViewById(R.id.youcanscore);
    }
}
