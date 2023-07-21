package com.example.myweightliftingpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class HistoryWorkout extends AppCompatActivity {
    String userID;
    HashMap<String, List<Exercise>> hashMap;
    user f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_workout);
        Intent i = getIntent();
        userID = i.getStringExtra("userID");
        f= (user) i.getSerializableExtra("user");
        hashMap = f.getPlan();
        String hasherString = hashMap.toString();
        TextView textView = (TextView) findViewById(R.id.CHANGER);
        textView.setText(hasherString);

    }
}