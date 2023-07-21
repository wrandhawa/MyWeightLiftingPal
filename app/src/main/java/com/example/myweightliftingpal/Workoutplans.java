package com.example.myweightliftingpal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Workoutplans extends AppCompatActivity {
    FirebaseFirestore fstore;
    String[] sarry;
    String userId;
    String workouttypeplan;
    HashMap<String, List<Exercise>> ppl3;
    HashMap<String, List<Exercise>> ppl6;
    HashMap<String, List<Exercise>> fb3;
    HashMap<String, List<Exercise>> fb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fstore = FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_workoutplans);
    }
    public String getWorkoutPlan(){
        return null;
    }
    public String[] getUserId(){
        Intent i = getIntent();
        String[] s = i.getStringArrayExtra("arr");
        return s;
    }
    public void getWorkoutType(){
        String[] sarry = getUserId();
        if(sarry[7].equals("beginner")){
            if(sarry[8].equals("three")){
                workouttypeplan = "fullbody3";
            }
            else
                workouttypeplan = "fullbody6";
        }
        else{
            if(sarry[8].equals("three"))
                workouttypeplan = "ppl3";
            else
                workouttypeplan = "ppl6";
        }
    }
    public void sfn(){
        Exercise bench = new Exercise("Bench Press");
        Exercise squat = new Exercise("Barbell Back Squat");
        Exercise Parrallel_bar_dips = new Exercise("Parallel bar dips");
        Exercise BarbellBicepCurl= new Exercise("Barbell Bicep Curls");
        Exercise PullUps = new Exercise("Pull Ups");
        Exercise DumbellBicepCurl = new Exercise("Dumbell Bicep Curl");
        Exercise InclineDBCurl = new Exercise("Incline Dumbbell curl");
        Exercise PreacherCurl = new Exercise("Preacher Curl");
        Exercise RDL = new Exercise("Romanian Deadlifts");
        Exercise tricepextension = new Exercise("Tricep extension");
        Exercise OverheadPress= new Exercise("Overhead Press");
        Exercise InclineBenchDB = new Exercise("Incline Dumbell Bench");
        Exercise Rows = new Exercise("Barbell Rows");
        Exercise CloseGripBecnh = new Exercise("Close-Grip Bench Press");
        Exercise CalfRaises = new Exercise("Calf Raises");
        Exercise LegRaises = new Exercise("Leg Raises");
        Exercise Deadlifts = new Exercise("Deadlifts");
        Exercise skullcrushers = new Exercise("Skullcrushers");
        Exercise hammercurls = new Exercise("Hammer Curls");
        Exercise LatPullDowns = new Exercise("Lat Pull Downs");
        Exercise LateralRaises = new Exercise("Lateral Raises");
        Exercise FacePulls = new Exercise("Cable Face-Pulls");
        Exercise PecDeck = new Exercise("Pec Deck");
        Exercise Rest = new Exercise("rest");
        DayWorkoutPlan dayWorkoutPlan = new DayWorkoutPlan();
        List<Exercise> rest = new ArrayList<>();
        rest.add(Rest);
        List<Exercise> push = new ArrayList<Exercise>();
        push.add(bench);
        push.add(CloseGripBecnh);
        push.add(InclineBenchDB);
        push.add(Parrallel_bar_dips);
        push.add(tricepextension);
        push.add(skullcrushers);
        push.add(PecDeck);
        List<Exercise> pull = new ArrayList<Exercise>();
        pull.add(PullUps);
        pull.add(LatPullDowns);
        pull.add(Rows);
        pull.add(DumbellBicepCurl);
        pull.add(PreacherCurl);
        pull.add(InclineDBCurl);
        pull.add(hammercurls);
        List<Exercise> legsshoulders = new ArrayList<>();
        legsshoulders.add(Deadlifts);
        legsshoulders.add(squat);
        legsshoulders.add(CalfRaises);
        legsshoulders.add(RDL);
        legsshoulders.add(FacePulls);
        legsshoulders.add(LateralRaises);
        legsshoulders.add(OverheadPress);
        List<Exercise> workoutA = new ArrayList<>();
        workoutA.add(squat);
        workoutA.add(bench);
        workoutA.add(PullUps);
        workoutA.add(Parrallel_bar_dips);
        workoutA.add(BarbellBicepCurl);
        workoutA.add(tricepextension);
        List<Exercise> workoutB = new ArrayList<>();
        workoutB.add(squat);
        workoutB.add(InclineBenchDB);
        workoutB.add(Deadlifts);
        workoutB.add((Parrallel_bar_dips));
        workoutB.add(Rows);
        workoutB.add(BarbellBicepCurl);
        workoutB.add(CloseGripBecnh);
        fb3 = new HashMap<>();
        fb6 = new HashMap<>();
        ppl3 = new HashMap<>();
        ppl6 = new HashMap<>();
        fb3.put("1", workoutA);
        fb3.put("2", rest);
        fb3.put("3", workoutB);
        fb3.put("4", rest);
        fb3.put("5", workoutA);
        fb3.put("6", rest);
        fb3.put("7", rest);

        fb6.put("1", workoutA);
        fb6.put("2", rest);
        fb6.put("3", workoutB);
        fb6.put("4", rest);
        fb6.put("5", workoutA);
        fb6.put("5", rest);
        fb6.put("5", workoutB);


        ppl3.put("1", push);
        ppl3.put("2", rest);
        ppl3.put("3", pull);
        ppl3.put("4", rest);
        ppl3.put("5", legsshoulders);
        ppl3.put("6", rest);
        ppl3.put("7", rest);
        ppl6.put("1", push);
        ppl6.put("2", pull);
        ppl6.put("3", legsshoulders);
        ppl6.put("4", rest);
        ppl6.put("5", push);
        ppl6.put("6", pull);
        ppl6.put("7", legsshoulders);
    }
    public HashMap<String, List<Exercise>> hs(String wtp){
        if(wtp.equals("fullbody3"))
            return fb3;
        else if(wtp.equals("fullbody3"))
            return fb6;
        else if(wtp.equals("ppl3"))
            return ppl3;
        else
            return ppl6;
    }
    public int getCalories(){
        Intent i = getIntent();
        int x = Integer.parseInt(i.getStringExtra("calories"));
        return x;
    }
    public void constinue(View view) {
        this.sfn();
        this.getWorkoutType();
        Intent i = new Intent(this, ReturningMain.class);
        sarry = getUserId();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference documentReference = fstore.collection("user").document(sarry[0]);
        HashMap<String, HashMap<String, List<Exercise>>> data = new HashMap<>();
        HashMap<String, List<Exercise>> ls = hs(workouttypeplan);
        user f = new user();
        f.setAge(Integer.parseInt(sarry[5]));
        f.setexperience(sarry[7]);
        f.setgoal(sarry[1]);
        f.setDaysperweek(Integer.parseInt(sarry[8]));
        f.setHeight(sarry[2] + "," + sarry[3]);
        f.SetWeight(Integer.parseInt(sarry[4]));
        f.setCal(this.getCalories());
        f.setgoalcal(this.getCalories());
        f.SetPlan(ls);
        documentReference.set(f).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("Tag", "Hello");
            }
        });
        //data.put("DayByDay Exercises", ls);
        /*db.collection("user").document(s1[0])
                .set(data, SetOptions.merge());

        FirebaseFirestore db2 = FirebaseFirestore.getInstance();
        DocumentReference documentReference2 = fstore.collection("user").document(s1[0]);
        HashMap<String, String> data2 = new HashMap<>();
        data2.put("workouttypeplan", s1[8]);

        db2.collection("user").document(s1[0])
                .set(data, SetOptions.merge());*/

        i.putExtra("userID", sarry[0]);
        i.putExtra("calorie", this.getCalories());
        startActivity(i);
    }
}