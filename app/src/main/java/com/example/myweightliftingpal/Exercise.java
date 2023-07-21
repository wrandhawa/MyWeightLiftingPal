package com.example.myweightliftingpal;


import java.io.Serializable;

public class Exercise implements Serializable{
    public int reps;
    public String name;
    public int sets;
    public Exercise(String name){
        this.name = name;
    }
    public int weight;
    public Exercise(){}


    public int getReps() {
        return reps;
    }
    public String getName(){return name;}
    public int getWeight(){return weight;}
    public int getSets(){return reps;}

    public void setReps(int x){reps = x;}
    public void setWeight(int x){weight = x;}
    public void setSets(int x){sets = x;}
    public String toString(){
        return name + "sets: " + sets + " reps:  " + reps + " weight:" + weight;

    }

}
