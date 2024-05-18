package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    ImageButton addsub;
    ImageButton profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addsub = findViewById(R.id.imageButton20);
        if(!dataclasss.reviewd){
            addsub.setVisibility(View.INVISIBLE);
        }
        addsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), addsubmision.class);
                startActivity(intent);
            }
        });
        profile = findViewById(R.id.imageButton22);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), profile_fragment.class);
                startActivity(intent);
            }
        });
        int[] grdde = dataclasss.currentuser.getLs();
        Log.d("llll", String.valueOf(grdde[0]));
        Log.d("llll", String.valueOf(grdde[1]));
        Log.d("llll", String.valueOf(grdde[2]));
        Log.d("llll", String.valueOf(grdde[3]));
        Log.d("llll", String.valueOf(grdde[4]));
        float[] jjj = recommendor.returner(grdde);
        String line = "";
        String delimiter = ",";
        int rowNum = 0;
//        Course_Name,Course_Code,Course_Type,Course_Description,Professor_name,Professor_credentials,Professor_photo,Techtree_Links,Course Image Link,Course_Rating,Course_Count,Assignment_link,Quiz_Link,Project_Link,Midsem_Link,Endsem_Link,Course_content_link,Miscellaneous_link
        if(dataclasss.craeted) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("Project_Courses_List.csv")))) {
                while((line = br.readLine()) != null){
                    String[] values = line.split(delimiter);
                    if(rowNum < 42){
                        dataclasss.objectlist.add(new courseclass(values[0],values[1],values[4],"gandu",values[6],values[3],values[5],values[7],jjj[rowNum],values[11],values[12],values[13],values[14],values[15],values[16],values[17],values[9]));
                        rowNum = rowNum + 1;
                    }else{
                        dataclasss.objectlist.add(new courseclass(values[0],values[1],values[4],"gandu",values[6],values[3],values[5],values[7],10,values[11],values[12],values[13],values[14],values[15],values[16],values[17],values[9]));
                        rowNum = rowNum + 1;
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            dataclasss.craeted = false;
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new courselistadapter(getApplicationContext(),dataclasss.objectlist));

    }
    @Override
    public void onBackPressed(){

    }
}