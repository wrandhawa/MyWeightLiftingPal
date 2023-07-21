package com.example.myweightliftingpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayByDayPlanning extends AppCompatActivity {
    String s;
    String day = "";
    String workouttypelan = "";
    user f;
    HashMap<String, List<Exercise>> ppl3;
    HashMap<String, List<Exercise>> ppl6;
    HashMap<String, List<Exercise>> fb3;
    HashMap<String, List<Exercise>> fb6;
    HashMap<String, List<Exercise>> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_by_day_planning);
    }
    /*
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
    }*/
    public void day1(View v){
        v.setEnabled(false);
        ((Button) findViewById(R.id.day2)).setEnabled(true);
        ((Button) findViewById(R.id.day3)).setEnabled(true);
        ((Button) findViewById(R.id.day4)).setEnabled(true);
        ((Button) findViewById(R.id.day5)).setEnabled(true);
        ((Button) findViewById(R.id.day6)).setEnabled(true);
        ((Button) findViewById(R.id.day7)).setEnabled(true);
         day = "1";
    }
    public void day2(View v){
        v.setEnabled(false);
        ((Button) findViewById(R.id.day1)).setEnabled(true);
        ((Button) findViewById(R.id.day3)).setEnabled(true);
        ((Button) findViewById(R.id.day4)).setEnabled(true);
        ((Button) findViewById(R.id.day5)).setEnabled(true);
        ((Button) findViewById(R.id.day6)).setEnabled(true);
        ((Button) findViewById(R.id.day7)).setEnabled(true);
        day = "2";
    }
    public void day3(View v){
        v.setEnabled(false);
        day = "3";
        ((Button) findViewById(R.id.day1)).setEnabled(true);
        ((Button) findViewById(R.id.day2)).setEnabled(true);
        ((Button) findViewById(R.id.day4)).setEnabled(true);
        ((Button) findViewById(R.id.day5)).setEnabled(true);
        ((Button) findViewById(R.id.day6)).setEnabled(true);
        ((Button) findViewById(R.id.day7)).setEnabled(true);
    }
    public void day4(View v){
        v.setEnabled(false);
        ((Button) findViewById(R.id.day1)).setEnabled(true);
        ((Button) findViewById(R.id.day2)).setEnabled(true);
        ((Button) findViewById(R.id.day3)).setEnabled(true);
        ((Button) findViewById(R.id.day5)).setEnabled(true);
        ((Button) findViewById(R.id.day6)).setEnabled(true);
        ((Button) findViewById(R.id.day7)).setEnabled(true);
        day = "4";
    }
    public void day5(View v){
        v.setEnabled(false);
        ((Button) findViewById(R.id.day1)).setEnabled(true);
        ((Button) findViewById(R.id.day2)).setEnabled(true);
        ((Button) findViewById(R.id.day3)).setEnabled(true);
        ((Button) findViewById(R.id.day4)).setEnabled(true);
        ((Button) findViewById(R.id.day6)).setEnabled(true);
        ((Button) findViewById(R.id.day7)).setEnabled(true);
        day = "5";

    }
    public void day6(View v){
        v.setEnabled(false);
        ((Button) findViewById(R.id.day1)).setEnabled(true);
        ((Button) findViewById(R.id.day2)).setEnabled(true);
        ((Button) findViewById(R.id.day3)).setEnabled(true);
        ((Button) findViewById(R.id.day4)).setEnabled(true);
        ((Button) findViewById(R.id.day5)).setEnabled(true);
        ((Button) findViewById(R.id.day7)).setEnabled(true);

        day = "6";

    }
    public void day7(View v){
        v.setEnabled(false);
        ((Button) findViewById(R.id.day1)).setEnabled(true);
        ((Button) findViewById(R.id.day2)).setEnabled(true);
        ((Button) findViewById(R.id.day3)).setEnabled(true);
        ((Button) findViewById(R.id.day4)).setEnabled(true);
        ((Button) findViewById(R.id.day5)).setEnabled(true);
        ((Button) findViewById(R.id.day6)).setEnabled(true);
        day = "7";
    }
    public void getWorkoutTypePlan(){
        Intent i2 = getIntent();
        s = i2.getStringExtra("userID");
        FirebaseFirestore fstore = FirebaseFirestore.getInstance();
        DocumentReference docRef = fstore.collection("user").document(s);
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    // Document exists, extract the specific fields
                    workouttypelan = document.getString("workouttypeplan");
                    // Continue processing or displaying the retrieved fields
                } else {
                    workouttypelan = null;
                }
            } else {
                // Handle the exception if the retrieval was not successful
                Exception exception = task.getException();
            }
        });
    }
    public void Fnallystart(View v){
       // Bundle extras = getIntent().getExtras();
        //if (extras != null)
            //f = (user)getIntent().getSerializableExtra("user");
        Intent i2 = getIntent();
        f = (user) i2.getSerializableExtra("user");
        Log.d("message", f.getHeight());
        s = i2.getStringExtra("userID");
        Intent i = new Intent(this, ExerciseProgress.class);
        i.putExtra("userID", s);
        i.putExtra("day", day);
        i.putExtra("user", f);
        startActivity(i);
    }
}