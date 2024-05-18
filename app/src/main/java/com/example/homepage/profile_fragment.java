package com.example.homepage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class profile_fragment extends AppCompatActivity {
    Button close;
    GraphView graphView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_fragment);
        TextView name = findViewById(R.id.PROFILENAME);
        TextView id =findViewById(R.id.PROFILEROLLNO);
        TextView year =findViewById(R.id.PROFILEBATCH);
        TextView program =findViewById(R.id.PROFILEBRANCH);
        TextView grades =findViewById(R.id.grades);
        TextView maxtext =findViewById(R.id.textView12);
        TextView averagetext =findViewById(R.id.textView13);
        TextView mysgpatext =findViewById(R.id.textView14);
        name.setText("NAME : "+dataclasss.currentuser.getUsername());
        id.setText("ROLL NO : "+dataclasss.currentuser.getrollno());
        year.setText("SEMESTER : "+dataclasss.currentuser.getsemester());
        program.setText("BRANCH : "+dataclasss.currentuser.getbranch());
        if(dataclasss.reviewdsgpa == 0){
            grades.setText("SGPA : "+dataclasss.currentuser.getSgpa());
        }else{
            grades.setText("SGPA : "+dataclasss.reviewdsgpa);
        }

        maxtext.setText("MAX");
        maxtext.setTextColor(Color.GREEN);
        averagetext.setText("AVERAGE");
        averagetext.setTextColor(Color.RED);
        mysgpatext.setText("MY SGPA");
        mysgpatext.setTextColor(Color.BLUE);
        close = findViewById(R.id.dataRecordedClose);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        graphView = findViewById(R.id.idGraphView);
        LineGraphSeries<DataPoint> MYSGPA = new LineGraphSeries(new DataPoint[]{
                new DataPoint(1, dataclasss.currentuser.getSgpa()),
                new DataPoint(2, dataclasss.reviewdsgpa)
        });
        LineGraphSeries<DataPoint> MAX = new LineGraphSeries(new DataPoint[]{
                new DataPoint(1, 10),
                new DataPoint(2, 10),
                new DataPoint(3, 10),
                new DataPoint(4, 10),
                new DataPoint(5, 10)
        });
        graphView.getGridLabelRenderer().setVerticalAxisTitle("SGPA");
        graphView.getGridLabelRenderer().setHorizontalAxisTitle("SEMESTERS");
        graphView.setTitle("PERFORMANCE");
        MYSGPA.setColor(Color.BLUE);
        MAX.setColor(Color.GREEN);
        graphView.addSeries(MYSGPA);
        graphView.addSeries(MAX);
    }
    @Override
    public void onBackPressed(){

    }
}