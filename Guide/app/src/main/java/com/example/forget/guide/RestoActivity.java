package com.example.forget.guide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RestoActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto);

        textViewTitle = (TextView) findViewById(R.id.title);
        textViewDescription = (TextView) findViewById(R.id.description);

        textViewTitle.setText("Les Restaurants");
        textViewDescription.setText("Masts hobble on death at east india! For a crushed iced tart, add some mint sauce and brown sugar. I disrupt this modification, it's called greatly exaggerated love.");
    }
}
