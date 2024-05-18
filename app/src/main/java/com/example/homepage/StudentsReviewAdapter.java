package com.example.homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentsReviewAdapter extends RecyclerView.Adapter<StudentsReviewAdapter.ReviewViewHolder> {
    private List<StudentReview> reviews;

    public StudentsReviewAdapter(List<StudentReview> review) {
        reviews = review;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_row, parent, false);
        return new ReviewViewHolder(view);
    }


    //ACCORDING TO THE OBJECTS OF THE LIST CHANGE THIS TESTVIEW TEXT SETTERS

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        StudentReview review = reviews.get(position);
        holder.studentNameTextView.setText(review.getStudentName());
        holder.reviewTextView.setText(review.getReviewText());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public static class ReviewViewHolder extends RecyclerView.ViewHolder {
        public TextView studentNameTextView;
        public TextView reviewTextView;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            studentNameTextView = itemView.findViewById(R.id.student_name);
            reviewTextView = itemView.findViewById(R.id.review_text);
        }
    }
}

