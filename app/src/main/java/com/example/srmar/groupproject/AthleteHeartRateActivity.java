package com.example.srmar.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.*;

/**
 * This class presents a user interface that displays the heartrate the athlete, as well as a
 * history of their heartrate from previous days.
 * @author Scott Martell, Jenna McNeil
 */
public class AthleteHeartRateActivity extends AppCompatActivity {
    int heartRate;
    private Button heartrateBack;
    private TextView heartrateCurrent;
    private ListView heartrateHistory;
    private Athlete person;
    private MyApplicationData appState;

    /**
     * This method creates the athlete heartrate activity ui.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_heartrate);
        person = (Athlete)getIntent().getSerializableExtra("Athlete");
        appState = ((MyApplicationData) getApplicationContext());
        heartRate = Integer.parseInt(person.heartRate);

        //initialize ui elements
        heartrateBack = (Button) findViewById(R.id.heartrateBack);
        heartrateCurrent = (TextView) findViewById(R.id.heartrateCurrent);
        heartrateHistory = (ListView) findViewById(R.id.heartRateHistory);

        if (heartRate >= 0){
            heartrateCurrent.setText("Heart Rate: "+heartRate+".");
        }
        if (heartRate < 0){
            heartrateCurrent.setText("Heart Rate: Invalid input.");
        }
    }

    /**
     * On click opens the Athlete activity ui.
     * @param view sets the ui.
     */
    public void hrBack(View view){
        Intent athlete = new Intent(this, AthleteActivity.class);
        athlete.putExtra("Athlete", person);
        startActivity(athlete);
    }

    /**
     * Getter for heartrate.
     * @return heartRate.
     */
    public int getHeartRate(){
        return heartRate;
    }

    /**
     * Setter for heartrate
     * @param heartRate value for current heartrate.
     */
    public void setHeartRate(int heartRate){
        this.heartRate = heartRate;
    }
}
