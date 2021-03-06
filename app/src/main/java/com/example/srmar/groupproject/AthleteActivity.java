package com.example.srmar.groupproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This class presents a user interface with four buttons, one to go back to the previous screen,
 * one that opens an interface for tracking steps, one that opnes an interface for tracking
 * heart rate, and one that allows the athlete to set desired ranges for steps and heartrate.
 * @author Scott Martell, Jenna McNeil
 */
public class AthleteActivity extends AppCompatActivity{

    private Button athleteBack;
    private Button athleteStep;
    private Button athleteHr;
    private Button athleteRange;
    private Athlete person;

    /**
     * This method creates the athlete activity user interface.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete);
        person = (Athlete)getIntent().getSerializableExtra("Athlete");

        //initializing ui elements
        athleteBack = (Button) findViewById(R.id.athleteBack);
        athleteStep = (Button) findViewById(R.id.athleteStep);
        athleteHr = (Button) findViewById(R.id.athleteHr);
        athleteRange = (Button) findViewById(R.id.athleteRange);
    }

    /**
     * On click opens AthleteStepsActivity ui.
     * @param view sets the ui.
     */
    public void showAthleteStepsActivity(View view){
        Intent athleteStepsScreen = new Intent(this, AthleteStepsActivity.class);
        athleteStepsScreen.putExtra("Athlete", person);
        startActivity(athleteStepsScreen);
    }

    /**
     * On click opens AthleteHeartRateActivity ui.
     * @param view sets the ui.
     */
    public void showAthleteHeartRateActivity(View view){
        Intent athleteHeartrateScreen = new Intent(this, AthleteHeartRateActivity.class);
        athleteHeartrateScreen.putExtra("Athlete", person);
        startActivity(athleteHeartrateScreen);
    }

    /**
     * On click opens AthleteRangeActivity ui.
     * @param view sets the ui.
     */
    public void showAthleteRangeActivity(View view){
        Intent athleteRangeScreen = new Intent(this, AthleteRangeActivity.class);
        athleteRangeScreen.putExtra("Athlete", person);
        startActivity(athleteRangeScreen);
    }

    /**
     * On click opens MainActivity ui.
     * @param view sets the ui.
     */
    public void showAthleteBack(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
