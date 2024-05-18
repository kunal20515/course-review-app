package com.example.homepage;
// data class for recycler view of students review recycler view
public class StudentReview {
    private String studentName;
    private String reviewText;

    public StudentReview(String studentName, String reviewText) {
        this.studentName = studentName;
        this.reviewText = reviewText;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getReviewText() {
        return reviewText;
    }
}

