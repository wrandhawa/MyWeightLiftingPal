package com.example.myweightliftingpal;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Source;

import java.util.Arrays;

public class ReturningMain extends AppCompatActivity {
    private DatabaseReference mDatabase;
    String calgoal;
    user f;
// ...


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returning);
        FirebaseFirestore fstore = FirebaseFirestore.getInstance();
        Intent i2 = getIntent();
        String s2 = i2.getStringExtra("userID");
        Log.d("home", s2);
        DocumentReference docRef = fstore.collection("user").document(s2);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user users1 = documentSnapshot.toObject(user.class);
                f=users1;
                TextView textView = (TextView) findViewById(R.id.textView10);
                textView.setText("Current Calorie Goal: " + users1.getGoalcal());
            }
        });

}


    public void onsignout(View v){
        Intent i = new Intent(this, login.class);
        startActivity(i);
    }
    public void onUserRead(View v){
        Intent i = new Intent(this, USERREAD.class);
        startActivity(i);
    }
    public void onquiz(View v){
        Intent i = new Intent(this, OpeningActivity.class);
        startActivity(i);
    }
    public void history(View v){
        Intent i = new Intent(this, workouthistory.class);
        startActivity(i);
    }
    public void reset(View v){
        user f = new user();
        f = null;
        Intent i = new Intent(this, OpeningActivity.class);
        startActivity(i);
    }
    public String getUserID(){
        Intent i2 = getIntent();
        String s= i2.getStringExtra("userID");
        return s;

    }
    public void getHistory(View v){
        Intent i = new Intent(this, HistoryWorkout.class);
        i.putExtra("user", f);
        i.putExtra("userID", getUserID());
        startActivity(i);

    }

    public void startWorkout(View v){
        Intent i = new Intent(this, DayByDayPlanning.class);
        i.putExtra("userID", getUserID());
        //Intent intent = new Intent(this, DayByDayPlanning.class);
        i.putExtra("user", f);
        //Log.d("tag", f.getHeight());
        //Bundle bundle = new Bundle();
       //bundle.putSerializable("user", f);
        //intent.putExtras(bundle);
        //startActivity(intent);
        startActivity(i);
    }
}