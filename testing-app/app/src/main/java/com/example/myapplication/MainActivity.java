package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_learning=(Button)findViewById(R.id.button);
        btn_learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLearning();
            }
        });
        Button btn_quiz=(Button)findViewById(R.id.button2);
        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });


        Button btn_repo = (Button)findViewById(R.id.button3);
        btn_repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                openRepository();
            }
        });
    }

    void startLearning() {
        Intent intent=new Intent(MainActivity.this, learning_activity.class);
        startActivity(intent);
    }
    void openRepository() {
        String url = "https://github.com/Amjad-Ashfaq/Testing-App.git";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    void startQuiz(){
        Intent intent=new Intent(MainActivity.this, Quiz_activity.class);
        startActivity(intent);
    }
}