package com.example.forget.guide;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import static android.R.id.button1;

public class MainActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }

    Button button= (Button) findViewById(R.id.);
        button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View ) {
            startActivity(new Intent(MainActivity.this,StandingsActivity.class));
        }
    });
}
