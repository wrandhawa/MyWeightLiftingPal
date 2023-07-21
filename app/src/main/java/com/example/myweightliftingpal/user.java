package com.example.myweightliftingpal;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class user implements Serializable {
    private int weight;
    private String height;
    private String experience;
    private int daysperweek;
    private int age;
    private int goalcal;
    private int cal;
    private String fitnessgoal;
    private HashMap<String, List<Exercise>> plan;



    public int getWeight(){return weight;}
    public int getGoalcal(){return goalcal;}
    public String getHeight(){return height;}
    public String getexperience(){return experience;}
    public int getDaysperweek(){return daysperweek;}
    public int getAge(){return age;}
    public String getgoal(){return fitnessgoal;}
    public int getCal(){return  cal;}
    public HashMap<String, List<Exercise>> getPlan(){return plan;}

//setters
    public void SetWeight(int x){weight =x;}
    public void SetPlan(HashMap<String, List<Exercise>> x){plan=x;}
    public void setCal(int x){cal=x;}
    public void setHeight(String x){height=x;}
    public void setexperience(String x){experience=x;}
    public void setDaysperweek(int x){daysperweek=x;}
    public void setAge(int x){age=x;}
    public void setgoal(String x){fitnessgoal = x;}
    public void setgoalcal(int x){goalcal = x;}



}
