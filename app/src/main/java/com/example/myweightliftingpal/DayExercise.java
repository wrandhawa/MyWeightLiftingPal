package com.example.myweightliftingpal;

import java.util.ArrayList;
import java.util.List;

public class DayExercise{
    public ArrayList<Exercise> as;
    public DayExercise(){
        List<Exercise> as = new ArrayList();
    }
    public void addExercise(Exercise s){
        as.add(s);
    }

}
