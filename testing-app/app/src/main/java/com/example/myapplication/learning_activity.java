package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class learning_activity extends AppCompatActivity {
    Button halqiyah_btn;
    Button lahatiyah_btn;
    Button shajariyah_btn;
    Button tarfiyah_btn;
    Button niteeyah_btn;
    Button lasaviyah_btn;
    Button ghunna_btn;
    ImageView learn_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        getComponents();
        clickFunctions();
    }

    void getComponents(){
        halqiyah_btn=(Button) findViewById(R.id.halqiyah_button);
        lahatiyah_btn=(Button) findViewById(R.id.lahatiyah);
        shajariyah_btn=(Button) findViewById(R.id.shajariah);
        tarfiyah_btn=(Button) findViewById(R.id.tarfiyah);
        niteeyah_btn=(Button) findViewById(R.id.niteeyah);
        lasaviyah_btn=(Button) findViewById(R.id.lasaviyah);
        ghunna_btn=(Button) findViewById(R.id.ghunna);
        learn_img=(ImageView) findViewById(R.id.learn_img);
    }

    void clickFunctions(){
        halqiyah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.halqiyah);
                setImage(bitmap);
            }
        });
        lahatiyah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lahatiyah);
                setImage(bitmap);
            }
        });
        shajariyah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shajariyah);
                setImage(bitmap);
            }
        });
        tarfiyah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tarfiyah);
                setImage(bitmap);
            }
        });
        niteeyah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.neetiyah);
                setImage(bitmap);
            }
        });
        lasaviyah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lisaveyah);
                setImage(bitmap);
            }
        });
        ghunna_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ghunnah);
                setImage(bitmap);
            }
        });
    }

    void setImage(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();

        Intent intent=new Intent(getApplicationContext(), learn_huruf.class);
        intent.putExtra("picture", b);
        learning_activity.this.startActivity(intent);
    }
}