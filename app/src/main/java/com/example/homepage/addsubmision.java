package com.example.homepage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class addsubmision extends Activity {
    Button addSubmissionPostSubmission;


    TextView course1;
    SeekBar seekBar1;
    TextView grade1;
    EditText review1;
    RatingBar ratingBar1;

    TextView course2;
    SeekBar seekBar2;
    TextView grade2;
    EditText review2;
    RatingBar ratingBar2;

    TextView course3;
    SeekBar seekBar3;
    TextView grade3;
    EditText review3;
    RatingBar ratingBar3;

    TextView course4;
    SeekBar seekBar4;
    TextView grade4;
    EditText review4;
    RatingBar ratingBar4;

    TextView course5;
    SeekBar seekBar5;
    TextView grade5;
    EditText review5;
    RatingBar ratingBar5;

    int s1val = 0;
    int s2val = 0;
    int s3val = 0;
    int s4val = 0;
    int s5val = 0;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_submission);

        String c1name = "test1";
        String c2name = "test2";
        String c3name = "test3";
        String c4name = "test4";
        String c5name = "test5";

        addSubmissionPostSubmission = findViewById(R.id.addSubmissionPostSubmission);

        course1 = findViewById(R.id.course1);
        seekBar1 = findViewById(R.id.seekBar1);
        grade1 = findViewById(R.id.grade1);
        review1 = findViewById(R.id.review1);
        ratingBar1 = findViewById(R.id.ratingBar1);
        seekBar1.setMax(10);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                s1val = i;
                grade1.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        course2 = findViewById(R.id.course2);
        seekBar2 = findViewById(R.id.seekBar2);
        grade2 = findViewById(R.id.grade2);
        review2 = findViewById(R.id.review2);
        ratingBar2 = findViewById(R.id.ratingBar2);
        seekBar2.setMax(10);

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                s2val = i;
                grade2.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        course3 = findViewById(R.id.course3);
        seekBar3 = findViewById(R.id.seekBar3);
        grade3 = findViewById(R.id.grade3);
        review3 = findViewById(R.id.review3);
        ratingBar3 = findViewById(R.id.ratingBar3);
        seekBar3.setMax(10);

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                s3val = i;
                grade3.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        course4 = findViewById(R.id.course4);
        seekBar4 = findViewById(R.id.seekBar4);
        grade4 = findViewById(R.id.grade4);
        review4 = findViewById(R.id.review4);
        ratingBar4 = findViewById(R.id.ratingBar4);
        seekBar4.setMax(10);

        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                s4val = i;
                grade4.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        course5 = findViewById(R.id.course5);
        seekBar5 = findViewById(R.id.seekBar5);
        grade5 = findViewById(R.id.grade5);
        review5 = findViewById(R.id.review5);
        ratingBar5 = findViewById(R.id.ratingBar5);
        seekBar5.setMax(10);

        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                s5val = i;
                grade5.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        Log.d("aaa",dataclasss.currentuser.getC1());
        Log.d("aaa",dataclasss.currentuser.getC2());
        Log.d("aaa",dataclasss.currentuser.getC3());
        Log.d("aaa",dataclasss.currentuser.getC4());
        Log.d("aaa",dataclasss.currentuser.getC5());


        course1.setText(dataclasss.currentuser.getC1());
        course2.setText(dataclasss.currentuser.getC2());
        course3.setText(dataclasss.currentuser.getC3());
        course4.setText(dataclasss.currentuser.getC4());
        course5.setText(dataclasss.currentuser.getC5());

        addSubmissionPostSubmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String reviewc1 = String.valueOf(review1.getText());
                String reviewc2 = String.valueOf(review2.getText());
                String reviewc3 = String.valueOf(review3.getText());
                String reviewc4 = String.valueOf(review4.getText());
                String reviewc5 = String.valueOf(review5.getText());

                Float ratingc1 = ratingBar1.getRating();
                Float ratingc2 = ratingBar2.getRating();
                Float ratingc3 = ratingBar3.getRating();
                Float ratingc4 = ratingBar4.getRating();
                Float ratingc5 = ratingBar5.getRating();

                Boolean cusc1 = cusswordcheck.checker(reviewc1);
                Boolean cusc2 = cusswordcheck.checker(reviewc2);
                Boolean cusc3 = cusswordcheck.checker(reviewc3);
                Boolean cusc4 = cusswordcheck.checker(reviewc4);
                Boolean cusc5 = cusswordcheck.checker(reviewc5);

                String courseid1 = c1name;
                String courseid2 = c2name;
                String courseid3 = c3name;
                String courseid4 = c4name;
                String courseid5 = c5name;

                if(!cusc1){
                    Toast.makeText(addsubmision.this, "PLEASE MAINTAIN A DECORUM IN REVIEWS. TYPE THE REVIEW AGAIN", Toast.LENGTH_SHORT).show();
                    review1.setText("TYPE AGAIN WITH DECORUM");
                }                else if(!cusc2){
                    Toast.makeText(addsubmision.this, "PLEASE MAINTAIN A DECORUM IN REVIEWS. TYPE THE REVIEW AGAIN", Toast.LENGTH_SHORT).show();
                    review2.setText("TYPE AGAIN WITH DECORUM");
                }                else if(!cusc3){
                    Toast.makeText(addsubmision.this, "PLEASE MAINTAIN A DECORUM IN REVIEWS. TYPE THE REVIEW AGAIN", Toast.LENGTH_SHORT).show();
                    review3.setText("TYPE AGAIN WITH DECORUM");
                }                else if(!cusc4){
                    Toast.makeText(addsubmision.this, "PLEASE MAINTAIN A DECORUM IN REVIEWS. TYPE THE REVIEW AGAIN", Toast.LENGTH_SHORT).show();
                    review4.setText("TYPE AGAIN WITH DECORUM");
                }                else if(!cusc5){
                    Toast.makeText(addsubmision.this, "PLEASE MAINTAIN A DECORUM IN REVIEWS. TYPE THE REVIEW AGAIN", Toast.LENGTH_SHORT).show();
                    review5.setText("TYPE AGAIN WITH DECORUM");
                }else {
                    List<String> courseIds= new ArrayList<>();
                    List<String> courseReviews = new ArrayList<>();
                    List<Float> courseRatings = new ArrayList<>();

                    courseIds.add(courseid1);
                    courseIds.add(courseid2);
                    courseIds.add(courseid3);
                    courseIds.add(courseid4);
                    courseIds.add(courseid5);
                    courseReviews.add(reviewc1);
                    courseReviews.add(reviewc2);
                    courseReviews.add(reviewc3);
                    courseReviews.add(reviewc4);
                    courseReviews.add(reviewc5);
                    courseRatings.add(ratingc1);
                    courseRatings.add(ratingc2);
                    courseRatings.add(ratingc3);
                    courseRatings.add(ratingc4);
                    courseRatings.add(ratingc5);

                    dataclasss.reviewd = false;

                    dataclasss.reviewdsgpa = (s1val+s2val+s3val+s4val+s5val)/5;

                    new RatingStore().saveCourses(courseIds, courseReviews, courseRatings);
                    Intent intent = new Intent(getApplicationContext(), RecordedData.class);
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public void onBackPressed(){

    }
}
