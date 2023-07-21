package com.example.myweightliftingpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Plans extends AppCompatActivity {
    String[] sarry;
    FirebaseFirestore fstore;
    String userId;
    int currentcal;
    int goalcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);
    }
    public String[] getIntent2(){
        Intent i = getIntent();
        String[] arry = i.getStringArrayExtra("arr");
        return arry;
    }
    public void six(View view){
        view.setEnabled(false);
        ((Button) findViewById(R.id.b5)).setEnabled(true);
        ((Button) findViewById(R.id.b4)).setEnabled(true);
        ((Button) findViewById(R.id.b3)).setEnabled(true);
        sarry = this.getIntent2();
        sarry[8]="6";
    }
    public void five(View view){
        view.setEnabled(false);
        ((Button) findViewById(R.id.b3)).setEnabled(true);
        ((Button) findViewById(R.id.b4)).setEnabled(true);
        ((Button) findViewById(R.id.b6)).setEnabled(true);
        sarry = this.getIntent2();
        sarry[8]="five";
    }
    public void four(View view){
        view.setEnabled(false);
        ((Button) findViewById(R.id.b3)).setEnabled(true);
        ((Button) findViewById(R.id.b5)).setEnabled(true);
        ((Button) findViewById(R.id.b6)).setEnabled(true);
        sarry = this.getIntent2();
        sarry[8]="four";
    }
    public void three(View view){
        view.setEnabled(false);
        ((Button) findViewById(R.id.b4)).setEnabled(true);
        ((Button) findViewById(R.id.b5)).setEnabled(true);
        ((Button) findViewById(R.id.b6)).setEnabled(true);
        sarry = this.getIntent2();
        sarry[8]="three";
    }
    public String getCalories(){
        String currentcal2 = sarry[6];
        int currentcal = Integer.parseInt(currentcal2);
        if(sarry[1].equals("cut"))
            goalcal = currentcal - 200;
        else if(sarry[2].equals("recomp"))
            goalcal = currentcal -100;
        else
            goalcal = currentcal + 350;
        return Integer.toString(goalcal);
    }
    public void constinue(View view){
        sarry = getIntent2();
        userId = sarry[0];
        /*
        fstore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = fstore.collection("user").document(userId);
        Map<String, String> user = new HashMap<>();
        user.put("WorkoutGoal", sarry[1]);
        user.put("Height", sarry[2] + "," + sarry[3]);
        user.put("Weight", sarry[4]);
        user.put("Age", sarry[5]);
        user.put("UserExperience", sarry[7]);
        user.put("DaysPerWeek", sarry[8]);
        user.put("Current Calories Per Day", sarry[6]);
        user.put("Goal Calories", this.getCalories());
        user f = new user();
        f.setAge(Integer.parseInt(sarry[5]));
        f.setexperience(sarry[7]);
        f.setgoal(sarry[1]);
        f.setDaysperweek(Integer.parseInt(sarry[8]));
        f.setHeight(sarry[2] + "," + sarry[3]);
        f.SetWeight(Integer.parseInt(sarry[4]));
        f.setCal(Integer.parseInt(this.getCalories()));
        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("Tag", "Hello");
            }
        });*/
        String s = sarry[0];
        Intent i = new Intent(this, Workoutplans.class);
        i.putExtra("arr", sarry);
        i.putExtra("calories", this.getCalories());
        startActivity(i);
    }
}