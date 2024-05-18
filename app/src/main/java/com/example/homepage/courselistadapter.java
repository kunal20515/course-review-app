package com.example.homepage;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class courselistadapter extends RecyclerView.Adapter<viewholder> {

    Context context;
    List<courseclass> items;

    public courselistadapter(Context context, List<courseclass> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(context).inflate(R.layout.activity_coursecard,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.coursename.setText(items.get(position).getCoursename());
        holder.coursecode.setText(items.get(position).getCoursecode());
        holder.courseinstructor.setText(items.get(position).getCourseinstructor());
        holder.youCanScore.setText("YOU CAN SCORE : "+items.get(position).getscore());
//        int imghld = context.getResources().getIdentifier(items.get(position).getCourseimage(),"drawable",context.getPackageName());
//        holder.courseimage.setImageResource(imghld);
        holder.courseimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CourseDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("classcourse",String.valueOf(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}