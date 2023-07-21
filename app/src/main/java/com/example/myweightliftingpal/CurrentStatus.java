package com.example.myweightliftingpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CurrentStatus extends AppCompatActivity {
    String[] sarry;
    String heightfeet;
    String heightinches;
    String weight;
    String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_status);
    }
    public void costinue(View v){
        sarry = getIntent2();
        EditText tv = ((EditText)findViewById(R.id.feet));
        String tv2 = tv.getText().toString();
        sarry[2]=tv2;
        EditText tv3 = ((EditText)findViewById(R.id.inches));
        String tv4 = tv3.getText().toString();
        sarry[3]=tv4;
        EditText tv5 = ((EditText)findViewById(R.id.weight));
        String t6 = tv5.getText().toString();
        sarry[4]=t6;
        EditText tv7 = ((EditText)findViewById(R.id.age));
        String tv8 = tv7.getText().toString();
        sarry[5]=tv8;
        EditText tv9 = ((EditText)findViewById(R.id.cpd));
        String tv0 = tv9.getText().toString();
        sarry[6]=tv0;
        Intent i = new Intent(this, Experience.class);
        i.putExtra("arr", sarry);
        startActivity(i);
    }
    public String[] getIntent2(){
        Intent i = getIntent();
        String[] arry = i.getStringArrayExtra("arr");
        return arry;
    }
    public void getHeightFeet(View view){
        TextView tv = findViewById(R.id.TextView7);
        String tv2 = tv.toString();
        sarry = getIntent2();
        sarry[2]=tv2;

    }
    public void getHeightInches(View view){
        TextView tv = (EditText)findViewById(R.id.inches);
        String tv2 = tv.toString();
        sarry = getIntent2();
        sarry[3]=tv2;

    }
    public void getWeight(View view){
        TextView tv = (EditText)findViewById(R.id.weight);
        String tv2 = tv.toString();
        sarry[4]=tv2;

    }
    public void Age(View view){
        TextView tv = (EditText)findViewById(R.id.age);
        String tv2 = tv.toString();
        sarry[5]=tv2;

    }
}