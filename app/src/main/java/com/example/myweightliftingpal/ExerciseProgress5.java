package com.example.myweightliftingpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;

public class ExerciseProgress5 extends AppCompatActivity {

    HashMap<String, List<Exercise>> hashMap;
    List<Exercise> ls;
    String day;
    String userID;
    String name = "";
    user f;
    Exercise f1;
    int weight, reps, sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_progress5);
        Intent i = getIntent();
        day = i.getStringExtra("day");
        userID = i.getStringExtra("userID");
        f = (user) i.getSerializableExtra("user");
        hashMap = f.getPlan();
        ls = hashMap.get(day);
        f1 = ls.get(4);
        String name = f1.getName();
        TextView textView = (TextView) findViewById(R.id.textView7);
        textView.setText(name);
    }
    public void getWorkoutPlan(){

        FirebaseFirestore fstore = FirebaseFirestore.getInstance();
        DocumentReference docRef = fstore.collection("user").document(userID);
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    // Document exists, extract the specific fields
                    Log.d("message", document.getString("Height"));
                    hashMap= (HashMap<String, List<Exercise>>) document.getData().get("DayByDay Exercises");
                } else {
                    hashMap = null;
                }
            } else {
                Exception exception = task.getException();
            }
        });
    }
    public void getUserId(){
        Intent i = getIntent();
        userID = i.getStringExtra("userID");
    }
    public void getDay(){
        Intent i = getIntent();
        day= i.getStringExtra("day");
    }
    public void getWeight(View view){
        TextView tv = (EditText)findViewById(R.id.weight);
        String tv2 = tv.toString();
        weight= Integer.parseInt(tv2);
    }
    public void getReps(View view){
        TextView tv = (EditText)findViewById(R.id.reps);
        String tv2 = tv.toString();
        reps = Integer.parseInt(tv2);
    }
    public void getSets(View view){
        TextView tv = (EditText)findViewById(R.id.sets);
        String tv2 = tv.toString();
        int x = Integer.parseInt(tv2);
    }
    public void getSpecificDayExercise(){
        ls=hashMap.get(day);
    }

    public void nextExercise(View v){
        //Log.d("userID1", userID);
        EditText tv = ((EditText)findViewById(R.id.sets));
        String tv2 = tv.getText().toString();
        sets=Integer.parseInt(tv2);
        EditText tv3 = ((EditText)findViewById(R.id.reps));
        String tv4 = tv3.getText().toString();
        reps=Integer.parseInt(tv4);
        EditText tv5 = ((EditText)findViewById(R.id.weight));
        String tv6 = tv5.getText().toString();
        weight=Integer.parseInt(tv6);
        Intent i = new Intent(this, ExerciseProgress6.class);
        i.putExtra("userID", userID);
        i.putExtra("day", day);
        getSpecificDayExercise();
        f1.setReps(reps);
        f1.setWeight(weight);
        ls.set(4, f1);
        hashMap.put(day, ls);
        //i.putExtra(hashMap);
        f.SetPlan(hashMap);
        i.putExtra("user", f);
        startActivity(i);
    }



}