package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class loginpage extends AppCompatActivity {
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        Button buttonlogin = findViewById(R.id.button_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        TextView s = findViewById(R.id.textView);
        TextView c = findViewById(R.id.textView4);
        TextView i = findViewById(R.id.textView3);
        TextView o = findViewById(R.id.textView5);
        TextView n = findViewById(R.id.textView44);
        s.setVisibility(View.INVISIBLE);
        c.setVisibility(View.INVISIBLE);
        i.setVisibility(View.INVISIBLE);
        o.setVisibility(View.INVISIBLE);
        n.setVisibility(View.INVISIBLE);
        password.setVisibility(View.INVISIBLE);
        username.setVisibility(View.INVISIBLE);
        buttonlogin.setVisibility(View.INVISIBLE);
        TextView[] words = new TextView[5];
        words[0] = s;
        words[1] = c;
        words[2] = i;
        words[3] = o;
        words[4] = n;

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    int delay = i*100;
                    final int pos = i;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(pos > 4){
                                password.setVisibility(View.VISIBLE);
                                username.setVisibility(View.VISIBLE);
                                buttonlogin.setVisibility(View.VISIBLE);
                                words[4].setTextSize(40);
                            }else{
                                words[pos].setVisibility(View.VISIBLE);
                                words[pos].setTextSize(80);
                                if(pos-1>=0){
                                    words[pos-1].setTextSize(40);
                                }
                            }
                        }
                    },delay);
                }
            }
        };
        handler.postDelayed(runnable, 0);

        String line = "";
        String delimiter = ",";
        if(dataclasss.craeted) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("users.csv")))) {
                while((line = br.readLine()) != null){
                    String[] values = line.split(delimiter);
                    int[] grdde = {Integer.parseInt(values[3]),Integer.parseInt(values[4]),Integer.parseInt(values[5]),Integer.parseInt(values[6]),Integer.parseInt(values[7])};
                    dataclasss.userlist.add(new userclass(values[0],values[1],values[8],values[9],values[10],values[11],values[12],grdde,Float.parseFloat(values[2]),values[13],values[14],values[15]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un = String.valueOf(username.getText());
                String pas = String.valueOf(password.getText());
                for(int i = 0 ; i < dataclasss.userlist.size() ; i++){
                    if(dataclasss.userlist.get(i).getUsername().equals(un)){
                        if(dataclasss.userlist.get(i).getPassword().equals(pas)){
                            dataclasss.currentuser = dataclasss.userlist.get(i);
                            Log.d("aaa",dataclasss.currentuser.getC1());
                            Log.d("aaa",dataclasss.currentuser.getC2());
                            Log.d("aaa",dataclasss.currentuser.getC3());
                            Log.d("aaa",dataclasss.currentuser.getC4());
                            Log.d("aaa",dataclasss.currentuser.getC5());
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            break;
                        }else{
                            Toast.makeText(loginpage.this, "WRONG PASSWORD", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });




    }
    @Override
    public void onBackPressed(){

    }
}