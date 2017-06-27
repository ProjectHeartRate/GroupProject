package com.example.srmar.groupproject;

/**
 * Created by srmar on 2017-06-08.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AthleteActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete);

        //initializing ui elements
        final Button athleteBack = (Button) findViewById(R.id.athleteBack);
        final Button athleteStep = (Button) findViewById(R.id.athleteStep);
        final Button athleteHr = (Button) findViewById(R.id.athleteHr);
        final Button athleteRange = (Button) findViewById(R.id.athleteRange);

        //on click change ui
        athleteStep.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //nothing yet
            }
        });
        athleteHr.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //nothing yet
            }
        });
        athleteRange.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent athleteRangeScreen = new Intent(view.getContext(), AthleteRangeActivity.class);
                startActivityForResult(athleteRangeScreen, 0);
            }
        });
        athleteBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent main = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(main, 0);
            }
        });
    }
}
