package com.example.srmar.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * This class presents a user interface that displays the number of steps the athlete has taken
 * today, as well as a history of their steps from previous days.
 * @author Scott Martell, Jenna McNeil
 */
public class AthleteStepsActivity extends AppCompatActivity {
    int steps;
    private Button stepsBack;
    private TextView stepsToday;
    private ListView stepHistory;
    private Athlete person;
    private MyApplicationData appState;

    /**
     * This method creates the athlete steps activity ui.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_steps);
        person = (Athlete)getIntent().getSerializableExtra("Athlete");
        appState = ((MyApplicationData) getApplicationContext());
        steps = Integer.parseInt(person.steps);

        //initialize ui elements
        stepsBack = (Button) findViewById(R.id.stepsBack);
        stepsToday = (TextView) findViewById(R.id.stepsToday);
        stepHistory = (ListView) findViewById(R.id.stepsHistory);

        if (steps >= 0){
            stepsToday.setText("Steps: "+steps+".");
        }
        if (steps < 0){
            stepsToday.setText("Steps: Invalid input.");
        }
    }

    /**
     * On click opens the Athlete activity ui.
     * @param view sets the ui.
     */
    public void stepsBack(View view){
        Intent athlete = new Intent(this, AthleteActivity.class);
        athlete.putExtra("Athlete", person);
        startActivity(athlete);
    }

    /**
     * Getter for the number of steps.
     * @return steps
     */
    public int getSteps(){
        return steps;
    }

    /**
     * Steer for the number of steps.
     * @param steps the number of steps
     */
    public void setSteps(int steps){
        this.steps = steps;
    }
}
