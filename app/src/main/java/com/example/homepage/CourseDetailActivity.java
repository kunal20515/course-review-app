package com.example.homepage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class CourseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coursedetail);
        String position = getIntent().getStringExtra("classcourse");
        courseclass infom = dataclasss.objectlist.get(Integer.parseInt(position));
//        ImageView coursepic = findViewById(R.id.courseLogo);
        ImageView profpic = findViewById(R.id.couseprofpic);
        TextView coursetitle = findViewById(R.id.courseTitle);
        TextView coursecode = findViewById(R.id.courseCode);
        TextView coursedescription = findViewById(R.id.courseDetail);
        TextView courseinstructorname = findViewById(R.id.techtree);
        TextView courseinstructorquali = findViewById(R.id.profQualifications);
        TextView coursescore = findViewById(R.id.coursescore);
        TextView tktre = findViewById(R.id.tktre);
        TextView averagecourserating = findViewById(R.id.averagecourserating);
        ImageButton commnts = findViewById(R.id.imageButton3);
        ImageButton viewcontent = findViewById(R.id.imageButton4);

        tktre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(infom.gettechtreelink()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        coursetitle.setText(infom.getCoursename());
        coursecode.setText(infom.getCoursecode());
        coursedescription.setText(infom.getDescript());
        courseinstructorname.setText(infom.getCourseinstructor());
        courseinstructorquali.setText(infom.getProfQualifications());
        coursescore.setText(String.valueOf(infom.getscore()));
        String rating = infom.getrating();
        String rat = "1 2 3 4 5";
        if (rat.contains(rating)) {
            averagecourserating.setText(infom.getrating() + " / 5");
        }else{
            averagecourserating.setText("4 / 5");
        }


        String progimglink = infom.getProfimg();
        Picasso.get().load(progimglink).into(profpic);


        viewcontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), RecordedData.class);
//                startActivity(intent);
                Intent intent = new Intent(getApplicationContext(), coursematerialactivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("classcourse",String.valueOf(position));
                startActivity(intent);
            }
        });

        commnts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), RecordedData.class);
//                startActivity(intent);
                Intent intent = new Intent(getApplicationContext(), reviewfile.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("classcourse",String.valueOf(position));
                startActivity(intent);
            }
        });
    }
}