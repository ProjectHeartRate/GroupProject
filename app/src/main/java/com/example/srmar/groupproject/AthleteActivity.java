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
    /**
     * This method creates the athlete activity user interface.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete);

        //initializing ui elements
        final Button athleteBack = (Button) findViewById(R.id.athleteBack);
        final Button athleteStep = (Button) findViewById(R.id.athleteStep);
        final Button athleteHr = (Button) findViewById(R.id.athleteHr);
        final Button athleteRange = (Button) findViewById(R.id.athleteRange);

        athleteStep.setOnClickListener(new View.OnClickListener(){
            /**
             * Does nothing
             * @param view sets the ui.
             */
            public void onClick(View view){
                //nothing yet
            }
        });
        athleteHr.setOnClickListener(new View.OnClickListener(){
            /**
             * Does nothing.
             * @param view sets the ui.
             */
            public void onClick(View view){
                //nothing yet
            }
        });
        athleteRange.setOnClickListener(new View.OnClickListener(){
            /**
             * On click opens AthleteRangeActivity ui.
             * @param view sets the ui.
             */
            public void onClick(View view){
                Intent athleteRangeScreen = new Intent(view.getContext(), AthleteRangeActivity.class);
                startActivityForResult(athleteRangeScreen, 0);
            }
        });
        athleteBack.setOnClickListener(new View.OnClickListener(){
            /**
             * On click opens MainActivity ui.
             * @param view sets the ui.
             */
            public void onClick(View view){
                Intent main = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(main, 0);
            }
        });
    }
}
