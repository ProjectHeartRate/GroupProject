package com.example.srmar.groupproject;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This class creates an object that represents an athlete.
 * @author Scott Martell, Jenna McNeil.
 */
public class Athlete implements Serializable {

    public String name;
    public String uid;
    public String steps;
    public String heartRate;
    public String stepHigh;
    public String stepLow;
    public String hrHigh;
    public String hrLow;

    /**
     * Default constructor required for calls to DataSnapshot.getValue.
     */
    public Athlete() {
        //Default constructor.
    }

    /**
     * Constructor of Athlete object.
     * @param name name of athlete.
     */
    public Athlete(String uid,String name, String steps, String heartRate, String stepHigh, String stepLow, String hrHigh, String hrLow){
        this.uid = uid;
        this.name = name;
        this.steps = steps;
        this.heartRate = heartRate;
        this.stepHigh = stepHigh;
        this.stepLow = stepLow;
        this.hrHigh = hrHigh;
        this.hrLow = hrLow;
    }

    /**
     * Hashmap of stored data for the Athlete object.
     * @return result.
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("steps", steps);
        result.put("heart rate", heartRate);
        result.put("step high", stepHigh);
        result.put("step low", stepLow);
        result.put("heart rate high", hrHigh);
        result.put("heart rate low", hrLow);

        return result;
    }
}
