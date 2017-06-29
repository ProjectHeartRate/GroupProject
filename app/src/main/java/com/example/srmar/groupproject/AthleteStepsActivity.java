package com.example.srmar.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * This class presents a user interface that displays the number of steps the athlete has taken
 * today, as well as a history of their steps from previous days.
 * @author Scott Martell, Jenna McNeil
 */
public class AthleteStepsActivity extends AppCompatActivity {
    /**
     * This method creates the athlete steps activity ui.
     * @param savedInstanceState not sure what it does.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_steps);

        //initialize ui elements
        final Button stepsBack = (Button) findViewById(R.id.stepsBack);

        stepsBack.setOnClickListener(new View.OnClickListener(){
            /**
             * On click opens the Athlete activity ui.
             * @param view sets the ui.
             */
            public void onClick(View view){
                Intent athlete = new Intent(view.getContext(), AthleteActivity.class);
                startActivityForResult(athlete, 0);
            }
        });
    }
}
