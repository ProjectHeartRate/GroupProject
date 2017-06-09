package com.example.srmar.groupproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing ui elements
        final Button coachButton = (Button) findViewById(R.id.coach);
        final Button athleteButton = (Button) findViewById(R.id.athlete);

        //on click change ui to athlete or coach
        coachButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //nothing yet
            }
        });
        athleteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent athleteScreen = new Intent(view.getContext(), AthleteActivity.class);
                startActivityForResult(athleteScreen, 0);
            }
        });
    }
}