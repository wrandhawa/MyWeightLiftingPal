package com.example.myweightliftingpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Experience extends AppCompatActivity {
    String[] sarry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
    }
    public void experience(View v){
        Intent i = new Intent(this, Plans.class);
        i.putExtra("arr", sarry);
        startActivity(i);
    }
    public String[] getIntent2(){
        Intent i = getIntent();
        String[] arry = i.getStringArrayExtra("arr");
        return arry;
    }

        public void beginner(View view){
            view.setEnabled(false);
            ((Button) findViewById(R.id.advanced)).setEnabled(true);
            ((Button) findViewById(R.id.inter)).setEnabled(true);
            sarry = this.getIntent2();
            sarry[7]="beginner";
        }
    public void intermediate(View view){
        view.setEnabled(false);
        ((Button) findViewById(R.id.advanced)).setEnabled(true);
        ((Button) findViewById(R.id.begin)).setEnabled(true);
        sarry = this.getIntent2();
        sarry[7]="intermediate";
    }
    public void advanced(View view){
        view.setEnabled(false);
        ((Button) findViewById(R.id.begin)).setEnabled(true);
        ((Button) findViewById(R.id.inter)).setEnabled(true);
        sarry = this.getIntent2();
        sarry[7]="advanced";
    }

}