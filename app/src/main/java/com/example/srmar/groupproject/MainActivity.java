package com.example.srmar.groupproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This class presents an interface with two buttons, Coach and Athlete, which opens the UI
 * for the coach or the athlete, respectively.
 * @author Scott Martell, Jenna McNeil
 */
public class MainActivity extends AppCompatActivity {
    /**
     * This method creates the main activity user interface.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing ui elements
        final Button coachButton = (Button) findViewById(R.id.coach);
        final Button athleteButton = (Button) findViewById(R.id.athlete);


        coachButton.setOnClickListener(new View.OnClickListener(){
            /**
             * On click opens CoachActivity ui.
             * @param view sets the ui.
             */
            public void onClick(View view){
                Intent coachScreen = new Intent(view.getContext(), CoachActivity.class);
                startActivityForResult(coachScreen, 0);
            }
        });
        athleteButton.setOnClickListener(new View.OnClickListener(){
            /**
             * On click opens AthleteActivity ui.
             * @param view sets the ui.
             */
            public void onClick(View view){
                Intent athleteScreen = new Intent(view.getContext(), AthleteActivity.class);
                startActivityForResult(athleteScreen, 0);
            }
        });
    }
}