package com.example.srmar.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * This class, currently does nothing but open an empty screen. Eventually it will be show
 * the user interface for the coach.
 * @author Scott Martell, Jenna McNeil
 */
public class CoachActivity extends AppCompatActivity {
    /**
     * This method creates the coach activity user interface.
     * @param savedInstanceState not sure what it does.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);

        //initializing ui elements
        final Button coachBack = (Button) findViewById(R.id.coachBack);
        final Button athlete1Button = (Button) findViewById(R.id.athlete1Button);

        coachBack.setOnClickListener(new View.OnClickListener(){
            /**
             * On click opens MainActivity ui.
             * @param view sets the ui.
             */
            public void onClick(View view){
                Intent main = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(main, 0);
            }
        });

        athlete1Button.setOnClickListener(new View.OnClickListener(){
            /**
             * On click opens AthleteActivity ui.
             * @param view sets the ui.
             */
            public void onClick(View view){
                Intent athlete = new Intent(view.getContext(), AthleteActivity.class);
                startActivityForResult(athlete, 0);
            }
        });
    }
}
