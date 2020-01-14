package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String STATE_SCORE_1, STATE_SCORE_2;
    private int val1, val2;
    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.text01);
        tv2 = findViewById(R.id.text02);
        val1 = 0;
        val2 = 0;
        if (savedInstanceState != null) {
            val1 = savedInstanceState.getInt(STATE_SCORE_1);
            val2 = savedInstanceState.getInt(STATE_SCORE_2);
//Set the score text views
            tv1.setText(Integer.toString(val1));
            tv2.setText(Integer.toString(val2));
        }
    }

    public void increaseScore(View view) {
        if (view.equals(findViewById(R.id.plus01))) {
            val1 += 1;
            tv1.setText(Integer.toString(val1));
        } else {
            val2 += 1;
            tv2.setText(Integer.toString(val2));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, val1);
        outState.putInt(STATE_SCORE_2, val2);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.night_mode:
                int nm = AppCompatDelegate.getDefaultNightMode();
                if (nm == AppCompatDelegate.MODE_NIGHT_NO) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
        }
        recreate();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);
//Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    public void decreaseScore(View view) {
        if (view.equals(findViewById(R.id.minus01))) {
            val1 -= 1;
            tv1.setText(Integer.toString(val1));
        } else {
            val2 -= 1;
            tv2.setText(Integer.toString(val2));
        }
    }
}
