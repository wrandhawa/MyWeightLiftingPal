package com.example.myweightliftingpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

public class OpeningActivity extends AppCompatActivity {
    String[] sarry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
    }
    public String[] getIntent2(){
        Intent i = getIntent();
        String[] arry = i.getStringArrayExtra("arr");
        return arry;


    }
    public void Startotheractivity(String[] arry){
        Intent i = new Intent(OpeningActivity.this, CurrentStatus.class);
        i.putExtra("sarry", arry);
        startActivity(i);
    }
    public void bulk(View view){
        view.setEnabled(false);
        ((Button) findViewById(R.id.cut)).setEnabled(true);
        ((Button) findViewById(R.id.recomp)).setEnabled(true);
        sarry = this.getIntent2();
        sarry[1]="bulk";
    }public void cut(View view){
        view.setEnabled(false);
        ((Button) findViewById(R.id.bulk)).setEnabled(true);
        ((Button) findViewById(R.id.recomp)).setEnabled(true);
        sarry = this.getIntent2();
        sarry[1]="cut";
    }
    public void recomp(View view){
        view.setEnabled(false);
        ((Button) findViewById(R.id.bulk)).setEnabled(true);
        ((Button) findViewById(R.id.cut)).setEnabled(true);
        sarry = this.getIntent2();
        sarry[1]="recomp";
    }
    public void constinue(View view){
        Intent i = new Intent(this, CurrentStatus.class);
        i.putExtra("arr", sarry);
        startActivity(i);
    }

}