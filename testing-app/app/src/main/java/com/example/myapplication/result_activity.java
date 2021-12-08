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

public class result_activity extends AppCompatActivity {
    Button share_btn;
    TextView result;
    Button Home_btn;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        loadUI();
        setUpAction();
        clickFunction();
    }

    void loadUI(){
        share_btn=(Button) findViewById(R.id.share_btn);
        result=(TextView) findViewById(R.id.result);
        result.setText(getIntent().getStringExtra("scores").concat("/5"));
        Home_btn=(Button) findViewById(R.id.Home_btn);
        share_btn.setBackgroundColor(Color.parseColor("#FF6200EE"));
        Home_btn.setBackgroundColor(Color.parseColor("#FF6200EE"));
        toolbar=(Toolbar) findViewById(R.id.backToQuiz);
    }
    void setUpAction(){
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }

    void clickFunction(){
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "My quiz result is " + result.getText().toString();
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Quiz result");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
        Home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(result_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}