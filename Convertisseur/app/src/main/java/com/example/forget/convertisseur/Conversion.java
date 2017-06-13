package com.example.forget.convertisseur;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

public class Conversion extends AppCompatActivity {

    public static final String CONVERTISSEUR = "Convertisseur";
    private TextView mTextMessage;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }


    private EditText mEditCelcius;
    private EditText mEditFahrenheit;
    private List list = new ArrayList<>();
    private ListView listeSaved;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        mEditCelcius = (EditText) findViewById(R.id.celcius);
        mEditFahrenheit = (EditText) findViewById(R.id.fahrenheit);
        Button bSave = (Button) findViewById(R.id.save);
        listeSaved = (ListView) findViewById(R.id.listeSaved);

        mEditCelcius.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        String text = String.valueOf(mEditCelcius.getText());
                        if (mEditCelcius.hasFocus()) {
                            if (!text.isEmpty()) {
                                mEditFahrenheit.setText(String.valueOf(Double.valueOf(text) * 1.8 + 32));
                                Log.d(CONVERTISSEUR, text);
                            } else {
                                mEditFahrenheit.setText("");
                            }
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );
        mEditFahrenheit.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        String text = String.valueOf(mEditFahrenheit.getText());
                        if (mEditFahrenheit.hasFocus()) {
                            if (!text.isEmpty()) {
                                mEditCelcius.setText(String.valueOf((Double.valueOf(text) - 32) / 1.8));
                                Log.d(CONVERTISSEUR, text);
                            } else {
                                mEditCelcius.setText("");
                            }
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

        adapter = new ArrayAdapter<String>(
                Conversion.this, android.R.layout.simple_list_item_1, list
        );
        listeSaved.setAdapter(adapter);

        bSave.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         if (!mEditFahrenheit.getText().toString().isEmpty()) {
                                             list.add(mEditFahrenheit.getText().toString() + "<->" + mEditCelcius.getText().toString());
                                             adapter.notifyDataSetChanged();
                                             Log.d(CONVERTISSEUR, mEditFahrenheit.getText().toString() + "<->" + mEditCelcius.getText().toString());
                                         }
                                     }
                                 }
        );
        bSave.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Log.d(CONVERTISSEUR, "long click");
                return true;
            }
        });
    }
}
