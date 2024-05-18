package com.example.homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewContentAdapter extends RecyclerView.Adapter<ViewContentAdapter.ContentView_ViewHolder> {

    private List<CourseContent> content;

    public ViewContentAdapter(List<CourseContent> content) {
        this.content=content;
    }

    @NonNull
    @Override
    public ContentView_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewcontent_row, parent, false);
        return new ContentView_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentView_ViewHolder holder, int position) {
        CourseContent courseContent = content.get(position);
        holder.contentNameTextView.setText(courseContent.getContentName());
        holder.linkTextView.setText(courseContent.getLinkText());
    }

    @Override
    public int getItemCount() {

        return content.size();
    }

    public static class ContentView_ViewHolder extends RecyclerView.ViewHolder{
        public TextView contentNameTextView;
        public TextView linkTextView;
        public ContentView_ViewHolder(@NonNull View itemView) {
            super(itemView);
            contentNameTextView = itemView.findViewById(R.id.content_name);
            linkTextView = itemView.findViewById(R.id.link_text);
        }
    }
}
