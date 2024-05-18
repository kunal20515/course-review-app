package com.example.homepage;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class reviewfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviewactivity);

        RecyclerView recyclerView=findViewById(R.id.recycler_Student_reviews);

        String position = getIntent().getStringExtra("classcourse");
        courseclass infom = dataclasss.objectlist.get(Integer.parseInt(position));
        String coursecode = infom.getCoursecode();

        ArrayList<StudentReview> studentReviews = new ArrayList<>();
        ArrayList<CourseContent> courseContents=new ArrayList<>();
        AtomicInteger count = new AtomicInteger(1);
        new RatingStore().getCourses((List<String> courseIds_, List<String> courseReviews_, List<Float> courseRatings_) -> {
//          you can do anything here now
            Log.d("GETCOURSE", courseIds_.toString());
            Log.d("GETCOURSE", courseReviews_.toString());
            Log.d("GETCOURSE", courseRatings_.toString());

            for(int i = 0 ; i < courseReviews_.size() ; i++){
                String aa = " "+courseReviews_.get(i);
                studentReviews.add(new StudentReview("REVIEW "+count, aa));
                count.set(count.get() + 1);
                Log.d("aaa",aa);
            }

            return null;
        });
//        List<StudentReview> studentReviews = new ArrayList<>();
        studentReviews.add(new StudentReview("REVIEW "+count, "best"));
        count.set(count.get() + 1);
        studentReviews.add(new StudentReview("REVIEW "+count, "the instructor was good"));
        count.set(count.get() + 1);
        studentReviews.add(new StudentReview("REVIEW "+count, "superb course"));
        count.set(count.get() + 1);
        studentReviews.add(new StudentReview("REVIEW "+count, "best"));
        count.set(count.get() + 1);
        studentReviews.add(new StudentReview("REVIEW "+count, "the instructor was good"));
        count.set(count.get() + 1);
        studentReviews.add(new StudentReview("REVIEW "+count, "superb course"));
        count.set(count.get() + 1);
        studentReviews.add(new StudentReview("REVIEW "+count, "best"));
        count.set(count.get() + 1);
        studentReviews.add(new StudentReview("REVIEW "+count, "the instructor was good"));
        count.set(count.get() + 1);
        studentReviews.add(new StudentReview("REVIEW "+count, "superb course"));
        count.set(count.get() + 1);

//        StudentsReviewAdapter adapter = new StudentsReviewAdapter(studentReviews);

//        List<CourseContent> courseContents=new ArrayList<>();
        courseContents.add(new CourseContent("kunal", "https://classroom.google.com/u/0/h"));
        courseContents.add(new CourseContent("kunal", "https://classroom.google.com/u/0/h"));
        courseContents.add(new CourseContent("kunal", "https://classroom.google.com/u/0/h"));
        ViewContentAdapter ad =new ViewContentAdapter(courseContents);

        StudentsReviewAdapter adapter = new StudentsReviewAdapter(studentReviews);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}

