package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz_activity extends AppCompatActivity {
    Button opt1, opt2, opt3, opt4, next_btn;
    TextView ques, score_val, result;
    Toolbar toolbar;
    int i = 0, score=0;
    String question[] = {"1. To pronounce halqiyah huruf, sound produced from:",
            "2. To pronounce lahatiyah huruf, sound produced from:",
            "3. To pronounce neetiyah huruf, sound produced from:",
            "4. To pronounce lisaveyah huruf, sound produced from:",
            "5. To pronounce tarfiyah huruf, sound produced from:"};

    String options[][] = {{"A) End of throat", "B) Middle of throat", "C) Start of throat", "D) All of these"},
                          {"A) Base of tongue near Uvula", "B) Portion of tongue near its base", "C) both a and b", "D) none of these"},
                          {"A) Tip of the tongue","B) Middle of tongue","C) Base of the tongue","D) None of these"},
                          {"A) Tip of the tongue touching the tip of the frontal 2 teeth","B) Tip of the tongue comes between the front top and bottom teeth","C) Both a and b","D) none of these"},
                          {"A) Rounded tip of the tongue touching the base of the frontal 8 teeth","B) Rounded tip of the tongue touching the base of the frontal 6 teeth","C) Rounded tip of the tongue touching the base of the frontal 4 teeth","D) All of these"}};

    char selected[]={0,0,0,0,0};
    char answer[] = {'D','C','A','C','D'};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        loadUI();
        setUpAction();
        clickFunc();
    }

    void loadUI() {
        opt1 = (Button) findViewById(R.id.opt1);
        opt2 = (Button) findViewById(R.id.opt2);
        opt3 = (Button) findViewById(R.id.opt3);
        opt4 = (Button) findViewById(R.id.opt4);
        toolbar=(Toolbar) findViewById(R.id.backToMain);
        next_btn = (Button) findViewById(R.id.next_btn);
        next_btn.setText("Next");
        ques = (TextView) findViewById(R.id.question);
        score_val=(TextView) findViewById(R.id.val);
        result=(TextView) findViewById((R.id.result));
        ques.setText(question[0]);
        opt1.setText(options[0][0]);
        opt2.setText(options[0][1]);
        opt3.setText(options[0][2]);
        opt4.setText(options[0][3]);

        opt1.setBackgroundColor(Color.parseColor("#FF6200EE"));
        opt2.setBackgroundColor(Color.parseColor("#FF6200EE"));
        opt3.setBackgroundColor(Color.parseColor("#FF6200EE"));
        opt4.setBackgroundColor(Color.parseColor("#FF6200EE"));
    }
    void setUpAction(){
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }
    void clickFunc() {
        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#FF0000"));
                selected[i]='A';
                opt2.setBackgroundColor(Color.parseColor("#FF6200EE"));
                opt3.setBackgroundColor(Color.parseColor("#FF6200EE"));
                opt4.setBackgroundColor(Color.parseColor("#FF6200EE"));
            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#FF0000"));
                selected[i]='B';
                opt1.setBackgroundColor(Color.parseColor("#FF6200EE"));
                opt3.setBackgroundColor(Color.parseColor("#FF6200EE"));
                opt4.setBackgroundColor(Color.parseColor("#FF6200EE"));
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#FF0000"));
                selected[i]='C';
                opt1.setBackgroundColor(Color.parseColor("#FF6200EE"));
                opt2.setBackgroundColor(Color.parseColor("#FF6200EE"));
                opt4.setBackgroundColor(Color.parseColor("#FF6200EE"));
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#FF0000"));
                selected[i]='D';
                opt1.setBackgroundColor(Color.parseColor("#FF6200EE"));
                opt2.setBackgroundColor(Color.parseColor("#FF6200EE"));
                opt3.setBackgroundColor(Color.parseColor("#FF6200EE"));
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i<4)
                    myview();
                else {
                    myview();
                    Intent intent=new Intent(Quiz_activity.this,result_activity.class);
                    intent.putExtra("scores", String.valueOf(score));
                    Quiz_activity.this.startActivity(intent);
                }
            }
        });
    }

    public void myview() {
        if(selected[i]==answer[i]){
            score++;
            score_val.setText(String.valueOf(score));
        }
        i++;
        if (i<5) {
            ques.setText(question[i]);
            opt1.setText(options[i][0]);
            opt2.setText(options[i][1]);
            opt3.setText(options[i][2]);
            opt4.setText(options[i][3]);
            opt1.setBackgroundColor(Color.parseColor("#FF6200EE"));
            opt2.setBackgroundColor(Color.parseColor("#FF6200EE"));
            opt3.setBackgroundColor(Color.parseColor("#FF6200EE"));
            opt4.setBackgroundColor(Color.parseColor("#FF6200EE"));
            if(i==4){
                next_btn.setText("End Quiz");
            }
        }
    }
}